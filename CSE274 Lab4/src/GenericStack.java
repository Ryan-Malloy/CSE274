import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Complete the empty methods so that this class works with the StackDriver.java
 * class given. You may implement using either a LinkedList or an array. You MAY
 * NOT use the Java library Stack, LinkedList, or ArrayList classes.
 * 
 * @author john1819
 *
 */
public class GenericStack<T> implements StackInterface<T> {
    // Generic LinkedList nodes
    private Node<T> top = null;

    private static class Node<T> {
        private T data;
        private Node<T> next = null;

        Node(T element) {
            data = element;
        }
    }

    /**
     * Adds a new entry to the top of this stack.
     * 
     * @param newEntry An object to be added to the stack.
     */
    @Override
    public void push(T newEntry) {
        Node<T> newItem = new Node<T>(newEntry);
        if (top == null) {
            top = newItem;
        } else {
            newItem.next = top;
            top = newItem;
        }
    }

    /**
     * Removes and returns this stack's top entry.
     * 
     * @return The object at the top of the stack.
     * @throws EmptyStackException if the stack is empty before the operation.
     */
    @Override
    public T pop() {
        if (top == null) {
            throw new NoSuchElementException("The stack is empty.");
        }
        T output = top.data;
        top = top.next;
        return output;
    }

    /**
     * Retrieves this stack's top entry.
     * 
     * @return The object at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    @Override
    public T peek() {
        if (top == null) {
            throw new NoSuchElementException("The stack is empty.");
        }
        return top.data;
    }

    /**
     * Detects whether this stack is empty.
     * 
     * @return True if the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Removes all entries from this stack.
     */
    @Override
    public void clear() {
        top = null;

    }

}
