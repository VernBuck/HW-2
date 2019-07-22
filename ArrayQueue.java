import java.util.NoSuchElementException;

/**
 * Your implementation of a Queue backed by an array.
 *
 * @author Vernon Buck
 * @version 1.0
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    // DO NOT ALTER OR ADD INSTANCE VARIABLES
    private T[] backingArray;
    private int size;
    private int back;
    private int front;

    /**
     * Constructs a Queue with an initial capacity of {@code INITIAL_CAPACITY}.
     *
     * You must use constructor chaining to implement this constructor.
     */
    public ArrayQueue() {
        this(INITIAL_CAPACITY);
    }


    /**
     * Constructs a Queue with the specified initial capacity of
     * {@code initialCapacity}.
     *
     * @param initialCapacity the initial capacity of the backing array
     */
    public ArrayQueue(int initialCapacity) {
        backingArray = (T[]) new Object[initialCapacity];
    }


    @Override
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException("null data");
        }
        int z = 0;
        if (size == backingArray.length) {
            T[] temp = (T[]) new Object[backingArray.length * 2];
            for (int i = front; i < backingArray.length; i++) {
                temp[z] = backingArray[i];
                z++;
            }
            if (back < backingArray.length) {
                for (int i = 0; i < back; i++) {
                    temp[z] = backingArray[i];
                    z++;
                }
            }
            backingArray = temp;
            backingArray[size] = data;
            size++;
            front = 0;
            back = (front + size) % backingArray.length;
        } else {
            backingArray[back] = data;
            size++;
            back = (front + size) % backingArray.length;
        }
    }


    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("empty queue");
        }
        T temp = backingArray[front];
        backingArray[front] = null;
        size--;
        front = (front + 1) % backingArray.length;
        return temp;
    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    // DO NOT ALTER OR USE ANYTHING BEYOND THIS POINT!


    /**
     * Used for testing and grading purposes.
     * DO NOT USE THIS METHOD IN YOUR IMPLEMENTATION!
     *
     * @return the backing array of this queue
     */
    public Object[] getBackingArray() {
        return backingArray;
    }

}
