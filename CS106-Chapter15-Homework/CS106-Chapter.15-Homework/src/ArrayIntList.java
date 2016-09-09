import java.util.Arrays;
import java.util.Iterator;

public class ArrayIntList implements IntList{
	private static final int INITIAL_SIZE = 3;
	private int[] elementData;
	private int iSize = 0 ;
	
	  // post: constructs an empty list of default capacity
    public ArrayIntList() {
        this(INITIAL_SIZE);
    }

    // pre : capacity >= 0 (throws IllegalArgumentException if not)
    // post: constructs an empty list with the given capacity
    public ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("invalid capacity: " + capacity);
        }
        elementData = new int[capacity];
    }
    
    // pre : 
    // post: constructs an empty list with the given capacity
    public ArrayIntList(int[] populate) {
        add(populate);
    }
    
    // post: returns the current number of elements in the list
    public int size() {
        return iSize;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the integer at the given index in the list
    public int get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    // post: creates a comma-separated, bracketed version of the list
    @Override
    public String toString() {
        if (iSize == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < iSize; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        for (int i = 0; i < iSize; i++) {
            if (elementData[i] == value) {
                return i ;
            }
        }
        return -1;
    }

    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return iSize == 0;
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }

    // pre : size() < capacity (throws IllegalStateException if not)
    // post: appends the given value to the end of the list
    public void add(int value) {
        ensureCapacity(iSize + 1);
        elementData[iSize] = value;
        iSize++;
    }

    // pre : value is not null
    // post: appends the given value to the end of the list
    public void add(int[] value) {       
        for(int i = 0; i < value.length; i++)
        	add(value[i]);
    }

    // pre : size() < capacity (throws IllegalStateException if not) &&
    //       0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent
    //       values right
    public void add(int index, int value) {
    	if (index == iSize)
    		add(value);
    	else if (index < 0 || index > iSize) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    	else{
	        ensureCapacity(iSize + 1);
	        for (int i = iSize; i > index; i--) {
	            elementData[i] = elementData[i - 1];
	        }
	        elementData[index] = value;
	        iSize++;
    	}
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < iSize - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        iSize--;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the integer at the given index with the given value
    public void set(int index, int value) {
        checkIndex(index);
        elementData[index] = value;
    }

    // post: list is empty
    public void clear() {
    	iSize = 0;
    }

    // pre: size() + other.size() <= capacity (throws IllegalStateException
    //      if not)
    // post: appends all values in the given list to the end of this list
    public void add(IntList other) {
        ensureCapacity(iSize + other.size());
        for (int i = 0; i < other.size(); i++) {
            add(other.get(i));
        }
    }

    // post: returns an iterator for this list
    public Iterator<Integer> iterator() {
        return new IntListIterator(this);
    }

    // length = 1
    // capacity = 1, 2
    // isize = 1
    
    
    
    
    
    // post: ensures that the underlying array has the given capacity; if not,
    //       the size is doubled (or more if given capacity is even larger)
    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= iSize) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    // post: Return a clone of integers
    public IntList clone(){
    	ArrayIntList result = new ArrayIntList();
    	
    	for(int i = 0; i < elementData.length - 1; i++)
    		result.add(elementData[i]);
    	
    	return result;
    }
    
	public int sum() {
	    int total = 0;
	    for (int i = 0; i < iSize; i++) {
	        total += elementData[i];
	    }
	    return total;
	}
	
	public double average() {
	    if (isEmpty()) {
	        return 0.0;
	    } else {
	        return (double) sum() / iSize;
	    }
	}
	
	// Added for homework problem 8.
	public int count(int value) {
		int count = 0;
		for (int i = 0; i < elementData.length; i++) {
			if(elementData[i] == value) {
				count++;
			}
		}
		return count;
	}
	
	// Added for homework problem 9.
	public int maxCount() {
		int count = 0;
		int maxCount = 0;
		int previous = elementData[0];
		for (int i = 1; i < elementData.length; i++) {
			if(elementData[i] == previous) {
				count++;
				if(count > maxCount) {
					maxCount = count;
				}
			} else {
				previous = elementData[i];
				count = 0;
			}
		}
		return maxCount;
	}
	
	// Added for homework problem 10.
	public int longestSortedSequence() {
		int count = 0;
		int maxCount = 0;
		int value = elementData[0];
		for (int i = 1; i < elementData.length; i++) {
			if(elementData[i] > value) {
				count++;
				if(count > maxCount) {
					maxCount = count;
				}
			} else {
				count = 0;
			}
		}
		return count;
	}

	// Added for homework problem 19.
	public void compress() {
		final int size = elementData.length + (elementData.length % 2);
		int[] compressed = new int[size];
		for(int i = 0; i < size; i+=2) {
			compressed[i] = elementData[(i * 2)] + elementData[(i * 2) + 1];
		}
		if((elementData.length % 2) != 0) {
			compressed[compressed.length] = elementData[elementData.length];
		}
		elementData = compressed;
	}

	// Added for homework problem 20.
	public void rotate() {
		for (int index = elementData.length - 1; index > 0; index--) {
			int temp = elementData[index];
			elementData[index] = elementData[index - 1];
			elementData[index - 1] = temp;
		}
	}
}
