
/**
 * Your implementation of a DoublyLinkedList. Note the slightly different
 * time complexities from a SinglyLinkedList in the interface.
 *
 * @author Vernon Buck
 * @version 1.0
 */
public class DoublyLinkedList<T> implements LinkedListInterface<T> {

    // DO NOT ALTER OR ADD INSTANCE VARIABLES
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size;

    @Override
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("null data passed");
        }
        if (isEmpty()) {
            LinkedListNode<T> node = new LinkedListNode<>(data);
            head = node;
            tail = node;
        } else {
            LinkedListNode<T> node = new LinkedListNode<>(tail, data);
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    @Override
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("null data passed");
        }
        if (isEmpty()) {
            head = new LinkedListNode<>(data);
            tail = head;
        } else {
            LinkedListNode<T> f = head;
            LinkedListNode<T> newNode = new LinkedListNode<T>(data, head);
            f.setPrev(newNode);
            head = newNode;
        }
        size++;
    }


    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        if (size == 1) {
            return removeFromFront();
        }
        LinkedListNode<T> current = tail.getPrev();
        T temp = tail.getData();
        current.setNext(tail.getNext());
        tail = current;
        size--;
        return temp;
    }


    @Override
    public T removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        T temp = head.getData();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = head;
        }
        return temp;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public int size() {
        return size;
    }


    // DO NOT MODIFY CODE OR USE CODE BEYOND THIS POINT.


    @Override
    public LinkedListNode<T> getHead() {
        return head;
    }


    @Override
    public LinkedListNode<T> getTail() {
        return tail;
    }
}
