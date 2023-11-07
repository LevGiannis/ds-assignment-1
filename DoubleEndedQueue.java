import java.io.PrintStream;
import java.util.NoSuchElementException;

/**
 * Defines the methods for a Double-ended Queue that handles items of generic type.
 */
public interface DoubleEndedQueue<T> {
    /**
     * @return true if the queue is empty
     */
    public boolean isEmpty();

    /**
     * Insert an item at the front of the queue.
     */
    public void addFirst(T item);

    /**
     * Remove and return the item at the front of the queue.
     *
     * @return Item from the front of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public T removeFirst() throws NoSuchElementException;

    /**
     * Insert an item at the end of the queue.
     */
    public void addLast(T item);

    /**
     * Remove and return the item at the end of the queue.
     *
     * @return Item from the end of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public T removeLast() throws NoSuchElementException;

    /**
     * Return without removing the item at the front of the queue.
     *
     * @return Item from the front of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public T getFirst();

    /**
     * Return without removing the item at the end of the queue.
     *
     * @return Item from the end of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public T getLast();

    /**
     * Print the items of the queue, starting from the front,
     * to the print stream given as an argument. For example, to
     * print the elements to the standard output, pass System.out as a parameter. E.g.,
     * printQueue(System.out);
     */
    public void printQueue(PrintStream stream);

    /**
     * Return the size of the queue, 0 if empty.
     *
     * @return Number of elements in the queue.
     */
    public int size();
}
