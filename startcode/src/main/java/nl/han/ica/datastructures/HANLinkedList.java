package nl.han.ica.datastructures;

public class HANLinkedList<T> implements IHANLinkedList<T> {

    private HANLinkedListNode<T> startNode = null;
    @Override
    public void addFirst(T value) {
        HANLinkedListNode<T> newNode = new HANLinkedListNode<T>();
        newNode.value = value;
        if (startNode != null) {
            newNode.link = startNode;
        }
        startNode = newNode;
    }

    @Override
    public void clear() {
        startNode = null;
    }

    @Override
    public void insert(int index, T value) {
        HANLinkedListNode<T> newNode = new HANLinkedListNode<T>();
        newNode.value = value;

        int count = 0;

        if(startNode.link != null){

        }
    }

    @Override
    public void delete(int pos) {
        HANLinkedListIterator<T> previous = findPrevious( pos );

        if(previous.current.link != null){
            previous.current.link = previous.current.link.link;
        }
    }

    public HANLinkedListIterator<T> findPrevious(int pos){
        HANLinkedListNode<T> itr = startNode;

        while ( itr.link != null && !itr.link.value.equals(pos)){
            itr = itr.link;
        }

        return new HANLinkedListIterator<T>(itr);
    }

    @Override
    public T get(int pos) {
        HANLinkedListNode<T> itr = startNode.link;

        while (itr != null && !itr.value.equals( pos )){
            itr = itr.link;
        }

        return itr.value;
    }

    @Override
    public void removeFirst() {
        startNode = startNode.link;
    }

    @Override
    public T getFirst() {
        return startNode.value;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
