package nl.han.ica.datastructures;

public class HANLinkedListIterator<T> {

    HANLinkedListNode current;

    HANLinkedListIterator(HANLinkedListNode node){
        current = node;
    }

    public boolean isValid(){
        return current != null;
    }

    public Object retrieve(){
        return isValid() ? current.value : null;
    }

    public void advance(){
        if (isValid()){
            current = current.link;
        }
    }

}
