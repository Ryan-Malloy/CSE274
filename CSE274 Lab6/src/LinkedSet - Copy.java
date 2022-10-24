/**
 * Implements a set of strings using linked nodes.
 * 2/18/2020
 * @author Norm Krumpe
 * @version 1.0
 * 
 *
 */
public class LinkedSet implements Set {

	private Node head;
	private int size;

	/**
	 * Constructor for linked set.
	 */
	public LinkedSet() {
		head = null;
		size = 0;
	}

	/**
	 * Method that adds string to linked set if it does
	 * not already exist in it.
	 * @param s string to be added.
	 * @return boolean true or false if s was added.
	 */
	@Override
	public boolean add(String s) {
		boolean success = false;
		if (find(s) == null) {
			Node tmp = head;
			head = new Node(s);
			head.next = tmp;
			size++;
			success = true;
		}
		return success;
	}
	
	/**
	 * Method that adds array of strings to linked set.
	 * @param strings the array of strings to be added.
	 * @return boolean true or false if strings were added.
	 */
	@Override
	public boolean addAll(String[] strings) {
		boolean success = false;
		if (!isEmpty()) {
			for (int i = 0; i < strings.length; i++) {
				add(strings[i]);
			}
		}
		return success;
	}
			
		

	/**
	 * Method that removes node from linked set containing
	 * string s
	 * @param s the string to be removed from linked set.
	 * @return boolean true or false if s was removed.
	 */
	@Override
	public boolean remove(String s) {
		boolean success = false;
		if(head == null) {
			return success;
		}
		Node n = head;
		while(n.next != null) {
			if(n.data.equals(s)) {
				n = null;
			}
		}
		size--;
		return true;

	}

	/**
	 * Method that checks if String s is contained in the 
	 * linked set.
	 * @param s the string to be checked if in linked set.
	 * @return boolean true or false if s is in linked set.
	 */
	@Override
	public boolean contains(String s) {
		Node current = head;
		int index = 0;
		while (current != null && index < size) {
			if (current.data.equals(s)) {
				return true;
			}
			index++;
			current = current.next;
		}
		return false;
	}

	/**
	 * Method that returns linked set size.
	 * @return size the size of the linked set.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Method that checks if linked set is empty.
	 * @return boolean true or false if linked set is empty.
	 */
	@Override
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Method that clears the linked set.
	 */
	@Override
	public void clear() {
		head = null;
		size = 0;
	}
	
	/**
	 * Finds the node at the given string input returns 
	 * null if it is not found. 
	 * @param s the string to be found.
	 * @return node in the linked set.
	 */
	private Node find(String s) {
		Node result = null;
		Node current = head;
		int index = 0;
		while (current != null && index < size) {
			if (current.data.equals(s)) {
				result = current;
			}
			index++;
			current = current.next;
		}
		return result;

	}

	/**
	 * Method that turns linked set into array.
	 * @return String[] the array to be returned.
	 */
	@Override
	public String[] toArray() {
		String[] newArray = new String[size];
		Node current = head;
		for (int i = 0; i < size; i++) {
			newArray[i] = current.data;
			current = current.next;
		}
		return newArray;
	}

	private class Node {
		private String data;
		private Node next;

		private Node(String data) {
			this.data = data;
			this.next = null;
		}
	}

}
