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
		    throw new IllegalArgumentException();
		}
		size = 0;
		set = new String[capacity];
	}

	/**
	 * Constructs a set with the underlying array having an initial capacity of 10.
	 */
	public ResizableArraySet() {
		this(10);
	}

	//  It's important to include helpful comments in header comments if they
	// are specific to the implementation:
	
	// If an item is to be added, and the array is full, create a new array,
	// doubling its current size, and then add.
	@Override
	public boolean add(String s) {
		boolean success = false;

		if (find(s) == -1) {
		    ensureCapacity();
		    
		    set[size] = s;
		    size++;
		    success = true;
		}
		return success;

	}

	private void ensureCapacity() {
        if (size == set.length) {
            String[] oldSet = set;
            String[] tempSet = new String[size * 2];
            set = tempSet;
            
            for (int i = 0; i < size; i ++) {
                tempSet[i] = oldSet[(0 + i) % oldSet.length];
            }
        }
    }

	/*
	 * add() and remove() and contains() all require a search
	 * to see if an item is in the set already.  So, it would make
	 * sense to put that logic in just one place
	 */
	private int find(String s) {
		int location = -1;
		
		for (int i = 0; i < set.length; i++) {
		    if (set[i].equals(s)) {
		        return i;
		    }
		}

		return location;
	}

	@Override
	public boolean remove(String s) {
		boolean success = false;

		// TODO: Write this on your own.  Use the find() method
		// to help you, because if it is found, then find will tell you which index in the
		// array.  This index is useful to the remove() method.
        if (find(s) != -1) {
            set[find(s)] = null;
            size--;
            success = true;
        }
		return success;
	}
	
	@Override
	public boolean addAll(String[] strings) {
		boolean success = false;
		
		for (int i = 0; i < strings.length; i++) {
		    if (find(strings[i]) == -1) {
		        add(strings[i]);
		        success = true;
		    }
		}
		// TODO: Write this on your own
		
		return success;
	}

	@Override
	public boolean contains(String s) {
		// TODO:   It's one line, and uses the find() method.
	    return (find(s) != -1);

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		// TODO: Write this on your own
		// each reference in the array should be set to null
	    for (int i = 0; i < size; i++) {
	        set[i] = null;
	    }
	    size = 0;
	}

	@Override
	public String[] toArray() {
		String[] newArray = new String[size];
		newArray = Arrays.copyOf(set, size);
		return newArray;
	}

}
