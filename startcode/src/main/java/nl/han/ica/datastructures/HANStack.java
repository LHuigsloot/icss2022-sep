package nl.han.ica.datastructures;

public class HANStack<ASTNode> implements IHANStack<ASTNode>{

    HANLinkedListNode<ASTNode> topOfStack;
    @Override
    public void push(ASTNode value) {
        topOfStack = new HANLinkedListNode<ASTNode>(value, topOfStack);
    }

    @Override
    public ASTNode pop() {
        ASTNode temp = topOfStack.value;
        topOfStack = topOfStack.link;
        return temp;
    }

    @Override
    public ASTNode peek() {
        return topOfStack.value;
    }
}
