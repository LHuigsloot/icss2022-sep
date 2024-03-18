package nl.han.ica.datastructures;

public class HANLinkedListNode<T> {
    public T value;
    public HANLinkedListNode link;

    public HANLinkedListNode(T value, HANLinkedListNode link){
        this.value = value;
        this.link = link;
    }

    public HANLinkedListNode(T value){
        this.value = value;
    }

    public HANLinkedListNode(){}

}
