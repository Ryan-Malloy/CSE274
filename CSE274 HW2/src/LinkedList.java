import java.util.*;

public class LinkedList<T> {
    // Node and linked list variables.
    Node<T> head;
    private int size = 0;

    /**
     * constructor for linked list.
     */
    public LinkedList() {
        this.head = null;
    }

    /**
     * A simple method that returns teh list size.
     * 
     * @return size of list.
     */
    public int getSize() {
        return size;
    }

    /**
     * A method that gets an object (address) from the linked list at a cetain
     * index.
     * 
     * @param index The index of the object (address) in the list.
     * @return The object at the specifed index (address
     */
    public Object get(int index) {
        LinkedList<T>.Node<E> temp = head;
        int i = 0;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            while (i < index - 1) {
                temp = temp.next;
                i++;
            }
        }
        return temp.data;
    }

    /**
     * A method that adds an object (address) to the list.
     * 
     * @param data The data object (address) to be added.
     */
    public void add(E data) {
        Node<E> temp = new Node<>(data);

        if (this.head == null) {
            head = temp;
        } else {
            Node<E> X = head;
            while (X.next != null) {
                X = X.next;
            }
            X.next = temp;
        }
        size++;
    }

    /**
     * A method that removes an object (address) from the list.
     * 
     * @param key The object (address) to be removed.
     */
    public void remove(E key) {
        // creating previous Node, temporary Node, and next Node.
        Node<E> prev = new Node<>(null);
        prev.next = head;
        Node<E> next = head.next;
        Node<E> temp = head;

        // checking if Node is same.
        boolean exists = false;
        if (head.data == key) {
            head = head.next;
            exists = true;
        }

        // looping through list to find Node that matches.
        while (temp.next != null) {
            if (String.valueOf(temp.data).equals(String.valueOf(key))) {
                prev.next = next;
                exists = true;
                break;
            }
            prev = temp;
            temp = temp.next;
            next = temp.next;
        }
        if (exists == false
                && String.valueOf(temp.data).equals(String.valueOf(key))) {
            prev.next = null;
            exists = true;
        }
        if (exists) {
            size--;
        } else {
            System.out.println("Given Value is not present in linked list");
        }
    }

    /**
     * A private Node class for the linkedlist to use.
     * 
     * @author Ryan Malloy
     *
     * @param <E> A generic for the Node.
     */
    private class Node<T> {
        private E data;
        private Node<E> next;

        /**
         * A Node constructor.
         * 
         * @param data Generic data to be added with the Node.
         */
        private Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    Node<E> sortedMerge(Node<E> a, Node<E> b) {
        Node<E> result = null;

        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        if (a.data.compareTo(b.data) < 0) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(b.next, a);
        }

        return result;
    }

    Node<E> mergeResult(Node<E> n) {
        if (n == null || n.next == null) {
            return n;
        }

        Node<E> middle = getMiddle(n);

        Node<E> nextMiddle = middle.next;
        middle.next = null;

        Node<E> left = mergeResult(n);
        Node<E> right = mergeResult(nextMiddle);
        Node<E> sorted = sortedMerge(left, right);
        return sorted;
    }

    public Node<E> getMiddle(Node<E> n) {
        if (n == null) {
            return n;
        }

        Node<E> slow = n;
        Node<E> fast = n;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}