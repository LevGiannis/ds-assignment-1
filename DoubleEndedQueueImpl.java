import java.io.PrintStream;
import java.util.NoSuchElementException;

public class DoubleEndedQueueImpl<T> implements DoubleEndedQueue<T> {
    private Node<T> first;  // The first node of the queue
    private Node<T> last;   // The last node of the queue
    private int size;       // The size of the queue

    // Inner class for representing nodes in the queue
    private static class Node<T> {
        T item;            // The object stored in each node
        Node<T> next;      // The next node
        Node<T> prev;      // The previous node
        public String toString() {
            return item.toString();
        }
    }

    // Constructor to initialize the queue
    public DoubleEndedQueueImpl() {
        first = null;
        last = null;
        size = 0;
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Adds an item to the front of the queue
    public void addFirst(T item) {
        Node<T> newNode = new Node<>();
        newNode.item = item;
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }

    // Removes and returns the item from the front of the queue
    public T removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = first.item;
        first = first.next;
        if (first != null) {
            first.prev = null;
        } else {
            last = null; // The queue is now empty
        }
        size--;
        return item;
    }

    // Adds an item to the end of the queue
    public void addLast(T item) {
        Node<T> newNode = new Node<>();
        newNode.item = item;
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    // Removes and returns the item from the end of the queue
    public T removeLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = last.item;
        last = last.prev;
        if (last != null) {
            last.next = null;
        } else {
            first = null; // The queue is now empty
        }
        size--;
        return item;
    }

    // Returns the item from the front of the queue without removing it
    public T getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    // Returns the item from the end of the queue without removing it
    public T getLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return last.item;
    }

    // Prints the items in the queue, starting from the front
    public void printQueue(PrintStream stream) {
        Node<T> current = first;
        while (current != null) {
            stream.print(current.item + " ");
            current = current.next;
        }
        stream.println();
    }

    @Override
    public String toString() {
        Node<T> current = this.first;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current);
            current = current.next;
        }
        return sb.toString();
    }

    // Returns the size of the queue
    public int size() {
        return size;
    }

}