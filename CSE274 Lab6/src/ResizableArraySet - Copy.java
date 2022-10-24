import java.util.Arrays;
/**
 * A resizable array implementation of a set.  The underlying array
 * doubles in length whenever an add is performed and the array is full.
 * February 18, 2020
 * @author Norm Krumpe
 * @version 1.0
 *
 */

public class ResizableArraySet implements Set {
	private int size;
	private String[] set;

	/**
	 * Constructs a set with the underlying array having the specified
	 * initial capacity. Note that a large capacity means the array
	 * won't need to be resized as frequently, but it also means the
	 * array will take up more memory.
	 * @param capacity the initial capacity of the array
	 * @throws IllegalArgumentException if the capacity is less than 2
	 */
	public ResizableArraySet(int capacity) {
		if (capacity < 2) {
			throw new IllegalArgumentException("Capacity has to be over 2.");
		}
		set = new String[capacity];
		size = 0;
		
	}

	/**
	 * Constructs a set with the underlying array having an initial capacity of 10.
	 */
	public ResizableArraySet() {
		this(10);
	}

	/**
	 * Adds a string to the set, if the size is the same as the length
	 * then resize the array. If the size is less than 2, resize the array.
	 * @param s the string to be added
	 * @return boolean success true or false if s was removed.
	 */
	@Override
	public boolean add(String s) {
		boolean success = false;

		if(size == set.length) {
			resize();
		} else if(size < 2) {
			resize();
		}
			set[size] = s;
			success = true;
			size++;
		return success;

	}
	
	/**
	 * Resizes the current set if the it is full. 
	 */
	public void resize() {
		String[] temp = null;
		if(size >= (set.length/2)) {
			temp = (String[])new Object[set.length*2];
			for(int i = 0; i < set.length; i++) {
				temp[i] = set[i];
			}
			set = temp;
	
		} else if(size < (set.length/2) && set.length > 2) {
			temp = (String[])new Object[set.length/2];
			for(int i = 0; i < temp.length; i++) {
				temp[i] = set[i];
			}
			set = temp;
		}
	}


	/**
	 * Finds the index at the given string input. 
	 * @param s the string to be found.
	 * @return location the index of the string in the set.
	 */
	private int find(String s) {
		int location = -1;
		for(int i = 0; i < size; i++) {
			if(set[i].equals(s)) {
				location = i;
			}
		}
		return location;
	}

	/**
	 * Removes a string from the set and returns true when 
	 * removed.
	 * @param s string to be removed from set.
	 * @return boolean success true or false if s was removed.
	 */
	@Override
	public boolean remove(String s) {
		boolean success = false;

		if (find(s) != -1) {
			set[find(s)] = null;
			success = true;
			size--;
			resize();
		} 
		
		return success;
	}
	
	/**
	 * Adds an array of strings to the set.
	 * @param strings the array of strings to be added.
	 * @return boolean success true or false if strings was added.
	 */
	@Override
	public boolean addAll(String[] strings) {
		boolean success = false;
		
		
		
		
		
		
		
		
		return success;
	}

	/**
	 * Checks to see if string s is in the set.
	 * @return boolean true or false if s is in the set.
	 */
	@Override
	public boolean contains(String s) {
		return (find(s) != -1 ? false : true);
		
	}

	/**
	 * Method that returns the size.
	 * @return size size of the set.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Method that returns true or false if set is empty.
	 * @return boolean true or false if set is empty.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Method that clears the set.
	 */
	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			set[i] = null;
		}
		size = 0;
	}

	/**
	 * Method that returns the set to an array.
	 * @return String[] the array to be returned.
	 */
	@Override
	public String[] toArray() {
		String[] newArray = new String[size];
		newArray = Arrays.copyOf(set, size);
		return newArray;
	}

}
