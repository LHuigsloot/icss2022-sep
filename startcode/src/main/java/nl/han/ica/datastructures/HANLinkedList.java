package nl.han.ica.datastructures;

public class HANLinkedList<T> implements IHANLinkedList<T> {

    private HANLinkedListNode<T> startNode = null;
    @Override
    public void addFirst(T value) {
        HANLinkedListNode<T> newNode = new HANLinkedListNode<T>();
        newNode.value = value;
        if (startNode != null) {
            newNode.link = startNode;
            startNode = newNode;
        } else {
            startNode = newNode;
        }
    }

    @Override
    public void clear() {
        startNode = null;
    }

    @Override
    public void insert(int index, T value) {
        HANLinkedListIterator<T> previous = findPreviousOnPos( index );
        HANLinkedListNode<T> newNode = new HANLinkedListNode<T>();
        newNode.value = value;

        if(previous.current.link != null){
            newNode.link = previous.current.link;
            previous.current.link = newNode;
        }
    }

    @Override
    public void delete(int pos) {
        HANLinkedListIterator<T> previous = findPreviousOnPos( pos );

        if(previous.current.link != null){
            previous.current.link = previous.current.link.link;
        }
    }

    @Override
    public T get(int pos) {
        if(pos > getSize()){
            throw new RuntimeException("out of bounds");
        }
        HANLinkedListNode<T> itr = startNode;
        int count = 0;

        while (itr.link != null && count != pos ){
            itr = itr.link;
            count++;
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
        HANLinkedListNode<T> itr = startNode;
        int count = 0;
        if(itr != null) {
            count++;
            while (itr.link != null) {
                itr = itr.link;
                count++;
            }
        }
        return count;
    }

    public HANLinkedListIterator<T> findPreviousOnPos(int pos){
        HANLinkedListNode<T> itr = startNode;
        int count = 0;

        while ( itr.link != null && count != pos){
            itr = itr.link;
            count++;
        }

        return new HANLinkedListIterator<T>(itr);
    }

    public boolean checkForValue(T value){
        if(startNode != null) {
            HANLinkedListNode<T> itr = startNode;

            while (itr.link != null && itr.value.equals(value)) {
                itr = itr.link;
            }
            return itr.value.equals(value);
        }
        return false;
    }

    public int getPos(T value){
        HANLinkedListNode<T> itr = startNode;
        int count = 0;

        while (itr.link != null && itr.value != value){
            count++;
        }

        return count;
    }
}
