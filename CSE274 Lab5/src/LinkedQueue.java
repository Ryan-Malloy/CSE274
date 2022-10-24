import java.util.NoSuchElementException;import GenericStack.Node;/** * A class that implements the ADT queue by using a chain of linked nodes that * has references to the front and end of the chain. Adds will be after the last * node. Removes will be from the front node. */public final class LinkedQueue<T> implements QueueInterface<T> {	private Node firstNode; // References node at front of queue	private Node lastNode; // References node at back of queue	public LinkedQueue() {		firstNode = null;		lastNode = null;	} // end default constructor		/**	 * A method that adds a new entry to the linked queue.	 * 	 * @param newEntry An object to be added to the linked queue.	 */	public void add(T newEntry) {	    Node temp = new Node(newEntry);        if (this.firstNode == null && this.lastNode == null) {            firstNode = temp;            lastNode = temp;        } else {            lastNode.next = temp;            lastNode = temp;        }	} // end enqueue	/**	 * A method that will return the first node.	 */	public T peek() {		if (isEmpty())			throw new NoSuchElementException();		else			return firstNode.data;	} // end getFront	/**	 * A method that will remove and return the first node.	 */	public T remove() {	    if (firstNode == null) {	        throw new NoSuchElementException();	    } 		T frontData = peek(); // Might throw NoSuchElementException		firstNode = firstNode.next;		return frontData;	} // end dequeue	/**	 * A method that returns true if the linked queue is empty.	 */	public boolean isEmpty() {	    return firstNode == null;	} // end isEmpty	/**	 * A method that clears the linked queue.	 */	public void clear() {		firstNode = null;	} // end clear	// A private Node class. By making it an inner class,    // the outer class can access it easily, but the client cannot.	private class Node {		private T data;		private Node next;				// Constructs a new node with the specified data.		private Node(T data) {			this.data = data;			this.next = null;		}	}}