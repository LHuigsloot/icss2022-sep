package nl.han.ica.icss.transforms;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.BoolLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import nl.han.ica.icss.ast.types.ExpressionType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Evaluator implements Transform {

    private IHANLinkedList<HashMap<String, Literal>> variableValues;
    private Stylerule currentStylerule;

    public Evaluator() {
        //variableValues = new HANLinkedList<>();
    }

    @Override
    public void apply(AST ast) {
        variableValues = new HANLinkedList<>();
        autobotsRollOut(ast.root);
    }

    private void autobotsRollOut(ASTNode node){
        if(node instanceof Stylesheet | node instanceof Stylerule | node instanceof IfClause ) {
            variableValues.addFirst(new HashMap<String, Literal>());
        }
        if(node instanceof Stylerule){
            currentStylerule = (Stylerule) node;
        }

        //transform
        retrieveVariableValues(node);
        replaceVariableWithValue(node);
        replaceOperationWithFinalValue(node);
        replaceIfClause(node);

        for(ASTNode childNode: node.getChildren()){
            if(!node.getChildren().isEmpty()) {
                autobotsRollOut(childNode);
            }
        }

        if(node instanceof Stylesheet | node instanceof Stylerule | node instanceof IfClause ) {
            variableValues.removeFirst();
        }
        if(node instanceof Stylerule){
            currentStylerule = null;
        }
    }

    private void replaceIfClause(ASTNode node) {
        if (node instanceof IfClause) {
            ArrayList<ASTNode> body = new ArrayList<>();
            if (((IfClause) node).conditionalExpression instanceof BoolLiteral) {
                if (((BoolLiteral) ((IfClause) node).conditionalExpression).value) {
                    for (ASTNode ifClauseBody : ((IfClause) node).body) {
                        if (ifClauseBody instanceof Declaration) {
                            body.add(ifClauseBody);
                        }
                    }
                } else if (((IfClause) node).elseClause != null) {
                    for (ASTNode elseClauseBody : ((IfClause) node).elseClause.body) {
                        if (elseClauseBody instanceof Declaration) {
                            body.add(elseClauseBody);
                        }
                    }
                }
                if (!body.isEmpty()) {
                    currentStylerule.body.addAll(body);
                }
            }
            currentStylerule.body.remove(node);
        }
    }

    private void retrieveVariableValues(ASTNode node){
        if(node instanceof VariableAssignment){
            if(((VariableAssignment) node).expression instanceof Operation){
                ((VariableAssignment) node).expression = calculateOperation((Operation) ((VariableAssignment) node).expression);
            }
            if(((VariableAssignment) node).expression instanceof VariableReference){
                ((VariableAssignment) node).expression = getLiteralFromVariableReference(((VariableReference) ((VariableAssignment) node).expression).name);
            }
            variableValues.getFirst().put(((VariableAssignment) node).name.name, (Literal) ((VariableAssignment) node).expression);
        }
    }

    private void replaceVariableWithValue(ASTNode node){
        if(node instanceof Declaration) {
            if(((Declaration) node).expression instanceof VariableReference) {
                ((Declaration) node).expression = getLiteralFromVariableReference(((VariableReference) ((Declaration) node).expression).name);
            }
        }
        if(node instanceof Operation){
            if(((Operation) node).lhs instanceof VariableReference){
                ((Operation) node).lhs = getLiteralFromVariableReference(((VariableReference) ((Operation) node).lhs).name);
            }
            if(((Operation) node).rhs instanceof VariableReference){
                ((Operation) node).rhs = getLiteralFromVariableReference(((VariableReference) ((Operation) node).rhs).name);
            }
        }
        if(node instanceof IfClause){
            if(((IfClause) node).conditionalExpression instanceof VariableReference){
                ((IfClause) node).conditionalExpression = getLiteralFromVariableReference(((VariableReference) ((IfClause) node).conditionalExpression).name);
            }
        }
    }

    private void replaceOperationWithFinalValue(ASTNode node) {
        if(node instanceof Declaration){
            if(((Declaration) node).expression instanceof Operation) {
                ((Declaration) node).expression = calculateOperation((Operation) ((Declaration) node).expression);
            }
        }
    }


    private Literal calculateOperation(Operation node) {
        Literal literal = null;
        Literal literalRight;
        Literal literalLeft;
        int valueRight;
        int valueLeft;

        if(node.rhs instanceof Operation){
            literalRight = calculateOperation((Operation) node.rhs);
        } else if(node.rhs instanceof VariableReference){
            literalRight = getLiteralFromVariableReference(((VariableReference) node.rhs).name);
        } else {
            literalRight = (Literal) node.rhs;
        }

        if(node.lhs instanceof Operation){
            literalLeft = calculateOperation((Operation) node.lhs);
        } else if(node.lhs instanceof VariableReference){
            literalLeft = getLiteralFromVariableReference(((VariableReference) node.lhs).name);
        } else {
            literalLeft = (Literal) node.lhs;
        }

        if(literalRight instanceof PercentageLiteral){
            valueRight = ((PercentageLiteral) literalRight).value;
            literal = new PercentageLiteral(valueRight);
        }if(literalRight instanceof PixelLiteral){
            valueRight = ((PixelLiteral) literalRight).value;
            literal = new PixelLiteral(valueRight);
        } else {
            valueRight = ((ScalarLiteral) literalRight).value;
        }

        if(literalLeft instanceof PercentageLiteral){
            valueLeft = ((PercentageLiteral) literalLeft).value;
            literal = new PercentageLiteral(valueLeft);
        } if(literalLeft instanceof PixelLiteral){
            valueLeft = ((PixelLiteral) literalLeft).value;
            literal = new PixelLiteral(valueLeft);
        } else {
            valueLeft = ((ScalarLiteral) literalLeft).value;
        }

        if(node instanceof MultiplyOperation){
            if(literalRight instanceof PixelLiteral || literalLeft instanceof PixelLiteral){
                literal = new PixelLiteral(valueLeft * valueRight);
            } else {
                literal = new PercentageLiteral(valueLeft * valueRight);
            }
        } if (node instanceof AddOperation) {
            if(literalRight instanceof PixelLiteral || literalLeft instanceof PixelLiteral){
                literal = new PixelLiteral(valueLeft + valueRight);
            } else {
                literal = new PercentageLiteral(valueLeft + valueRight);
            }
        } if (node instanceof SubtractOperation) {
            if(literalRight instanceof PixelLiteral || literalLeft instanceof PixelLiteral){
                literal = new PixelLiteral(valueLeft - valueRight);
            } else {
                literal = new PercentageLiteral(valueLeft - valueRight);
            }
        }

        return literal;
    }

    private Literal getLiteralFromVariableReference(String key){
        Literal literal = null;
        for (int i = 0; i < variableValues.getSize(); i++){
            if(variableValues.get(i).containsKey(key)){
                literal = variableValues.get(i).get((key));
                break;
            }
        }
        return literal;
    }

}
