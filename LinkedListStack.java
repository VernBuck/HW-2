import java.util.NoSuchElementException;

/**
 * Your implementation of a Stack backed by a LinkedList.
 *
 * @author Vernon Buck
 * @version 1.0
 */
public class LinkedListStack<T> implements StackInterface<T> {

    // DO NOT ALTER OR ADD INSTANCE VARIABLES
    private LinkedListInterface<T> backingList;

    /**
     * Constructs an empty Stack.
     */
    public LinkedListStack() {
        backingList = new DoublyLinkedList<>();
    }


    @Override
    public void push(T data) {
        backingList.add(data);
    }


    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("no item to pop");
        }
        return backingList.remove();
    }


    @Override
    public int size() {
        return backingList.size();
    }


    @Override
    public boolean isEmpty() {
        return backingList.isEmpty();
    }


    // DO NOT ALTER OR USE ANYTHING BEYOND THIS POINT!


    /**
     * Used for testing and grading purposes.
     * DO NOT USE THIS METHOD IN YOUR IMPLEMENTATION!
     *
     * @return the backing list of this stack
     */
    public LinkedListInterface<T> getBackingList() {
        return backingList;
    }

}