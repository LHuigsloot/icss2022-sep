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

    public void check(AST ast) {
        variableTypes = new HANLinkedList<>();
        checkSemantics(ast.root);
    }

    //controleert de semantische regels
    private void checkSemantics(ASTNode node){
        if(node instanceof Stylesheet | node instanceof Stylerule | node instanceof IfClause ) {
            variableTypes.addFirst(new HashMap<String, ExpressionType>());
        }

        checkVariables(node);
        checkOperationForAllowedType(node);
        checkAddOrSubtractOperationForExpressionType(node);
        checkMultiplyOperationForScalar(node);
        checkIfClauseForBoolean(node);
        checkDeclaration(node);

        for(ASTNode childNode: node.getChildren()){
            if(!node.getChildren().isEmpty()) {
                checkSemantics(childNode);
            }
        }

        if(node instanceof Stylesheet | node instanceof Stylerule | node instanceof IfClause ) {
            variableTypes.removeFirst();
        }
    }

    //Controleer of een variabel een ASSignment heeft
    private void checkVariables(ASTNode variable){
        if(variable instanceof VariableAssignment) {
            if (((VariableAssignment) variable).expression != null) {
                ExpressionType expression = getExpressionTypeFromNode(((VariableAssignment) variable).expression);
                variableTypes.getFirst().put(variable.getChildren().get(0).getNodeLabel(), expression);
            }
        }
        if(variable instanceof VariableReference) {
            ExpressionType expression = getExpressionTypeFromVariableReference(variable);
            if (expression == ExpressionType.UNDEFINED) {
                variable.setError("Variabel ongedefinieerd");
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
                        declaration.setError("Alleen px of % in width of height");
                    }
                    break;
                case "color":
                case "background-color":
                    if (expression != ExpressionType.COLOR) {
                        declaration.setError("Alleen hex-codes in color of background-color");
                    }
                    break;
            }
        }
    }

    //Check of een som geen kleurcode bevat.
    private void checkOperationForAllowedType(ASTNode operation){
        if(operation instanceof Operation){
            for (ASTNode child: operation.getChildren()) {
                if (child instanceof ColorLiteral) {
                    operation.setError("Geen hex-codes in sommen");
                }
                if (child instanceof BoolLiteral){
                    operation.setError("Geen booleans in sommen");
                }
            }
        }
    }

    //Check of een optelling of aftrekking van hetzelfde is.
    private void checkAddOrSubtractOperationForExpressionType(ASTNode addOrSubtractOperation){
        if(addOrSubtractOperation instanceof AddOperation || addOrSubtractOperation instanceof SubtractOperation){
            if(getExpressionTypeFromNode(((Operation) addOrSubtractOperation).lhs) != getExpressionTypeFromNode(((Operation) addOrSubtractOperation).rhs)
                    & !(((Operation) addOrSubtractOperation).rhs instanceof MultiplyOperation)
                    & !(((Operation) addOrSubtractOperation).lhs instanceof MultiplyOperation)){
                addOrSubtractOperation.setError(" +/- sommen alleen met gelijke px of %");
            }
        }
    }

    //Check of een vermenigvuldiging minstens 1 scalair type bevat.
    private void checkMultiplyOperationForScalar(ASTNode multiplyOperation){
        if(multiplyOperation instanceof MultiplyOperation){
            if(getExpressionTypeFromNode(((MultiplyOperation) multiplyOperation).rhs) != ExpressionType.SCALAR & getExpressionTypeFromNode(((MultiplyOperation) multiplyOperation).lhs) != ExpressionType.SCALAR) {
                multiplyOperation.setError("* som bevat geen scalar");
            }
        }
    }

    //Check of een if-statement een boolean is.
    private void checkIfClauseForBoolean(ASTNode ifClause){
        if(ifClause instanceof IfClause){
            ExpressionType expressionType = getExpressionTypeFromNode(((IfClause) ifClause).getConditionalExpression());
            if(expressionType != ExpressionType.BOOL){
                ifClause.setError("Conditie is geen BOOlean");
            }
        }
    }

    //Haal de expressie type uit een node.
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

    //haalt de expression type uit een variabele
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

    //haalt de expression type uit een rekensom
    private ExpressionType getExpressionTypeFromOperation(ASTNode operation){
        ExpressionType expression = ExpressionType.UNDEFINED;
        if(operation instanceof Operation) {
            if (((Operation) operation).lhs instanceof VariableReference) {
                expression = getExpressionTypeFromVariableReference(((Operation) operation).lhs);
            } else if (((Operation) operation).lhs instanceof Operation) {
                expression = getExpressionTypeFromOperation(((Operation) operation).lhs);
            } else {
                expression = getExpressionTypeLiteral(((Operation) operation).lhs);
            }
            if (expression == ExpressionType.UNDEFINED || expression == ExpressionType.SCALAR) {
                if (((Operation) operation).rhs instanceof VariableReference) {
                    expression = getExpressionTypeFromVariableReference(((Operation) operation).rhs);
                } else if (((Operation) operation).rhs instanceof Operation) {
                    expression = getExpressionTypeFromOperation(((Operation) operation).rhs);
                } else {
                    expression = getExpressionTypeLiteral(((Operation) operation).rhs);
                }
            }
        }
        return expression;
    }

    //haalt de expression type uit een literal
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