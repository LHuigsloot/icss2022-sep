package nl.han.ica.icss.checker;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import nl.han.ica.icss.ast.types.ExpressionType;

import java.util.HashMap;


public class Checker {

    private IHANLinkedList<HashMap<String, ExpressionType>> variableTypes;
    private boolean variableAssignmentBranch;

    public void check(AST ast) {
        variableTypes = new HANLinkedList<>();
        variableAssignmentBranch = false;
        checkSemantics(ast.root);
    }

    private void checkSemantics(ASTNode node){
        if(node instanceof Stylesheet | node instanceof Stylerule | node instanceof IfClause ) {
            variableTypes.addFirst(new HashMap<String, ExpressionType>());
        }
        if(node instanceof VariableAssignment){
            variableAssignmentBranch = true;
        }

        checkVariables(node);
        checkDeclaration(node);
        checkOperationForColorType(node);
        checkAddOrSubtractOperationForExpressionType(node);
        checkMultiplyOperationForScalar(node);
        checkIfClauseForBoolean(node);
        for(ASTNode childNode: node.getChildren()){
            if(!node.getChildren().isEmpty()) {
                checkSemantics(childNode);
            }
        }

        if(node instanceof Stylesheet | node instanceof Stylerule | node instanceof IfClause ) {
            variableTypes.removeFirst();
        }
        if(node instanceof VariableAssignment){
            variableAssignmentBranch = false;
        }
    }

    //Controleer of een variabel een ASS heeft
    private void checkVariables(ASTNode variable){
        if(variable instanceof VariableAssignment) {
            if (((VariableAssignment) variable).expression != null) {
                ExpressionType expression = getExpressionTypeFromNode(((VariableAssignment) variable).expression);
                variableTypes.getFirst().put(variable.getChildren().get(0).getNodeLabel(), expression);
            }
        }
        if(variable instanceof VariableReference & !variableAssignmentBranch) {
            ExpressionType expression = getExpressionTypeFromVariableReference(variable);
            if (expression == ExpressionType.UNDEFINED) {
                variable.setError("HEY! Deze variabel is nog helemaal niet gedefineerd maat XoXo - gossipgirl");
            }
        }
    }

    //Check if de gegeven waarde van een property van de juiste type is.
    private void checkDeclaration(ASTNode declaration){
        if(declaration instanceof Declaration){
            String propertyName = ((Declaration) declaration).property.name;
            ExpressionType expression = getExpressionTypeFromNode(((Declaration) declaration).expression);

            switch (propertyName){
                case "width":
                case "height":
                    if (expression != ExpressionType.PERCENTAGE & expression != ExpressionType.PIXEL) {
                        declaration.setError("Alleen px of %");
                    }
                    break;
                case "color":
                case "background-color":
                    if (expression != ExpressionType.COLOR) {
                        declaration.setError("Alleen hex kleur codes >:(");
                    }
                    break;
            }
        }
    }

    //Check of een som geen kleurcode bevat.
    private void checkOperationForColorType(ASTNode operation){
        if(operation instanceof Operation){
            for (ASTNode child: operation.getChildren()) {
                if (child instanceof ColorLiteral) {
                    operation.setError("Kan niet rekenen met kleuren");
                }
            }
        }
    }

    //Check of een optelling of aftrekking van hetzelfde is.
    private void checkAddOrSubtractOperationForExpressionType(ASTNode addOrSubtractOperation){
        if(addOrSubtractOperation instanceof AddOperation || addOrSubtractOperation instanceof SubtractOperation){
            if(getExpressionTypeFromNode(((Operation) addOrSubtractOperation).lhs) != getExpressionTypeFromNode(((Operation) addOrSubtractOperation).rhs)){
                addOrSubtractOperation.setError("Fakka niffoe wat denk jij px + px of % + %, anders nie");
            }
        }
    }

    //Check of een vermenigvuldiging minstens 1 scalair type bevat.
    private void checkMultiplyOperationForScalar(ASTNode multiplyOperation){
        if(multiplyOperation instanceof MultiplyOperation){
            if(getExpressionTypeFromNode(((MultiplyOperation) multiplyOperation).rhs) != ExpressionType.SCALAR & getExpressionTypeFromNode(((MultiplyOperation) multiplyOperation).lhs) != ExpressionType.SCALAR) {
                multiplyOperation.setError("ER ZIT GEEN SCALAR IN JE KEERSOM");
            }
        }
    }

    //Check of een if-statement een boolean is.
    private void checkIfClauseForBoolean(ASTNode ifClause){
        if(ifClause instanceof IfClause){
            ExpressionType expressionType = getExpressionTypeFromNode(((IfClause) ifClause).getConditionalExpression());
            if(expressionType != ExpressionType.BOOL){
                ifClause.setError("Conditie is geen BOOLean");
            }
        }
    }

    //Check de scope van een variabel

    private ExpressionType getExpressionTypeFromNode(ASTNode node){
       ExpressionType expressionType = getExpressionTypeLiteral(node);
       if(expressionType == ExpressionType.UNDEFINED) {
           expressionType = getExpressionTypeFromVariableReference(node);
       }
       if(expressionType == ExpressionType.UNDEFINED)  {
           expressionType = getExpressionTypeFromOperation(node);
       }
       return expressionType;
    }

    private ExpressionType getExpressionTypeFromVariableReference(ASTNode variableReference){
        ExpressionType expression = ExpressionType.UNDEFINED;
        for (int i = 0; i < variableTypes.getSize(); i++){
            if(variableTypes.get(i).containsKey(variableReference.getNodeLabel())) {
                expression = variableTypes.get(i).get((variableReference.getNodeLabel()));
                break;
            }
        }
        return expression;
    }

    private ExpressionType getExpressionTypeFromOperation(ASTNode operation){
        ExpressionType expression = ExpressionType.UNDEFINED;
        if(operation instanceof Operation){
            for(ASTNode child: operation.getChildren()){
                if(child instanceof Literal){
                    expression = getExpressionTypeLiteral(child);
                } else if (child instanceof VariableReference){
                    expression = getExpressionTypeFromVariableReference(child);
                }
            }
        }
        return expression;
    }

    private ExpressionType getExpressionTypeLiteral(ASTNode node){
        if (node instanceof BoolLiteral) {
            return ExpressionType.BOOL;
        } else if (node instanceof ColorLiteral) {
            return ExpressionType.COLOR;
        } else if (node instanceof PercentageLiteral) {
            return ExpressionType.PERCENTAGE;
        } else if (node instanceof PixelLiteral) {
            return ExpressionType.PIXEL;
        } else if (node instanceof ScalarLiteral) {
            return ExpressionType.SCALAR;
        } else {
            return ExpressionType.UNDEFINED;
        }
    }

}