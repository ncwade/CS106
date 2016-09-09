
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedIntList implements IntList{
	private LinkedList<Integer> elementData ;
	private int iSize = 0;
	
	  // post: constructs an empty list of default capacity
    public LinkedIntList() {
    	  elementData = new LinkedList<Integer>();
    }

    // post: returns the current number of elements in the list
    public int size() {
        return iSize;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the integer at the given index in the list
    public int get(int index) {
        checkIndex(index);
        return elementData.get(index);
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (iSize == 0) {
            return "[]";
        } else {
            String result = "[" + elementData.get(0);
            for (int i = 1; i < iSize; i++) {
                result += ", " + elementData.get(i);
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
    	return elementData.indexOf(value);
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
        elementData.add(value);
        iSize++;
    }

    // pre : size() < capacity (throws IllegalStateException if not) &&
    //       0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent
    //       values right
    public void add(int index, int value) {
        elementData.add(index, value);
        iSize++;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
    	elementData.remove(index);
    	iSize--;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the integer at the given index with the given value
    public void set(int index, int value) {
        checkIndex(index);
        elementData.set(index, value);
    }

    // post: list is empty
    public void clear() {
    	elementData.clear();
    	iSize = 0;
    }

    // pre: size() + other.size() <= capacity (throws IllegalStateException
    //      if not)
    // post: appends all values in the given list to the end of this list
    public void add(IntList other) {
        for (int i = 0; i < other.size(); i++)
            add(other.get(i));
    }

	public void add(int[] value) {
        for(int i = 0; i < value.length; i++)
        	add(value[i]);
	}

    // post: returns an iterator for this list
    public Iterator<Integer> iterator() {
        return new IntListIterator(this);
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= iSize) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    public IntList clone(){
    	ArrayIntList result = new ArrayIntList();
    	
    	for(int i = 0; i < elementData.size() - 1; i++)
    		result.add(elementData.get(i));
    	
    	return result;
    }
    
	public int sum() {
	    int total = 0;
	    for (int i = 0; i < iSize; i++) {
	        total += elementData.get(i);
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
}
