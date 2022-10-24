import java.util.NoSuchElementException;

/**
 * @author Ryan Malloy CSE 274 Lab 2 Linked List Methods
 */
public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    /*
     * Creates an empty list.
     */
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /*
     * Returns a space-separated list of the elements in the list. If the list
     * contains no elements, return an empty string ""
     */
    public String toString() {
        String newString = "";
        Node current = head;
        while (current != null) {
            newString = newString + current.data + " ";
            current = current.next;
        }
        return newString;
    }

    /*
     * Returns the first item in the list. If the list is empty, throw a
     * NoSuchElementException.
     */
    public int getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    /*
     * Returns the last item in the list. If the list is empty, throw a
     * NoSuchElementException.
     */
    public int getLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    /*
     * Returns the item at the specified index. If the index is not valid, throw
     * an IndexOutOfBoundsException.
     */
    public int getAt(int index) {
        Node node = head;
        int i = 0;
        if (index <= 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            while (i < index - 1) {
                node = node.next;
                i++;
            }
        }
        return node.data;
    }

    /*
     * Inserts an item at the beginning of the list.
     */
    public void insertFirst(int num) {
        Node node = new Node(num);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }
        size++;
    }

    /*
     * Inserts an item at the end of the list.
     */
    public void insertLast(int num) {
        Node node = new Node(num);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /*
     * Removes and returns the first element from the list. If the list is
     * empty, throw a NoSuchElementException.
     */
    public int removeFirst() {
        if (head == null && tail == null) {
            throw new NoSuchElementException();
        } else {
            Node r = head;
            head = head.next;
            head.previous = null;
            size--;
            return r.data;
        }
    }

    /*
     * Removes and returns the last element from the list. If the list is empty,
     * throw a NoSuchElementException.
     */
    public int removeLast() {
        if (head == null && tail == null) {
            throw new NoSuchElementException();
        } else {
            Node t = tail;
            tail = tail.previous;
            tail.next = null;
            size--;
            return t.data;
        }
    }

    /*
     * Returns the number of elements in the list.
     */
    public int getSize() {
        return size;
    }

    /*
     * Returns true if the list is empty, and false otherwise.
     */
    public boolean isEmpty() {
        if (head == null || tail == null) {
            return false;
        }
        return true;
    }

    // A private Node class. By making it an inner class,
    // the outer class can access it easily, but the client cannot.
    private class Node {
        private int data;
        private Node next;
        private Node previous;

        // Constructs a new node with the specified data
        private Node(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }
}
