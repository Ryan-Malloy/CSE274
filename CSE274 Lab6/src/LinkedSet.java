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

	public LinkedSet() {
		head = null;
		size = 0;
	}

	@Override
	public boolean add(String s) {
		boolean success = false;
        // TO DO
		// Use find() to help with this. You should only add the string if
		// it's not already in the set.  find() will help you figure that out.
		// be sure to keep size up to date or toArray() won't work
		Node n = new Node(s);
		if (head == null) {
		    head = n;
		    size++;
		    return success = true;
		} else if (!contains(s)) {
		    n.next = head;
		    head = n;
		    size++;
		    success = true;
		}
		
		return success;
	}
	
	@Override
	public boolean addAll(String[] strings) {
		boolean success = false;
		// TO DO
		// Once you have implemented add(), you can use it in this method
		// be sure to update size or toArray() won't work
		if (strings.length > 0) {
    		for (int i = 0; i < strings.length; i++) {
    		    if (add(strings[i])) {
    		        add(strings[i]);
    		        success = true;
    		    }
    		}
		}
		return success;
	}

	@Override
	public boolean remove(String s) {
		boolean success = false;
		// TO DO
		// Use the find method to help with this.  Because find will tell
		// you which node you need to remove.
		// be sure to update size or toArray() won't work
		if (find(s) != null) {
		    Node n = head;
		    while(n.next != null) {
		        if(n.next.data.equals(s)) {
		            n.next = n.next.next;
		            size--;
		        }
		    }		    
		    success = true;
		}
		return success;

	}

	@Override
	public boolean contains(String s) {
	    if (find(s) != null) {
	        return true;
	    }
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void clear() {
		// No loop is needed here, because garbage collection will
		// take care of everything as soon as the head is set to null.
		head = null;
		size = 0;
	}

	/*
	 * add() and remove() and contains() all require a search
	 * to see if an item is in the set already.  So, it would make
	 * sense to put that logic in just one place.  If the specified
	 * string is found, this method returns a reference to the NODE that
	 * contains that string.  That node reference is useful for the remove() 
	 * method.  The method should return null if it's not found.
	 */
	private Node find(String s) {
		Node result = null;
		Node n = head;
		for (int i = 0; i < size; i++) {
		    if (n.data.equals(s)) {
		        result = n;
		    }
		    n = n.next;
		}
		return result;
	}

	@Override
	public String[] toArray() {
		String[] newArray = new String[size];
		Node current = head;
		int index = 0;
		while (current != null && index < size)
		{
			newArray[index] = current.data;
			current = current.next;
			index++;
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
