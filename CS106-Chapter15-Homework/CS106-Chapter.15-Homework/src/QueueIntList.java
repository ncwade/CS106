
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueIntList implements IntList{

	private Queue<Integer> elementData ;
	private int iSize = 0;
	
	  // post: constructs an empty list of default capacity
    public QueueIntList() {
    	  elementData = new LinkedList<Integer>();
    }

    // post: returns the current number of elements in the list
    public int size() {
        return iSize;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the integer at the given index in the Queue
    public int get(int index) {
    	Integer value = 0;
    	
    	if(0 > index || index >= iSize)
    		throw new  IndexOutOfBoundsException();
    		
    	for(int x = 0; x < iSize; x++){
    		if(x == index)
    			value = elementData.peek();
    		
    		elementData.add(elementData.remove());
    	}
    	
    	return value;
    }

    // post: creates a comma-separated, bracketed version of the list
    @Override
    public String toString() {
        if (iSize == 0) {
            return "[]";
        } else {
            String result = "[" + elementData.peek();
            elementData.add(elementData.remove());
            
        	for(int x = 1; x < iSize; x++){
        		result += ", " + elementData.peek();
        		
        		elementData.add(elementData.remove());
        	}
        	
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
    	int index = 0;
    	boolean found = false;
    		
    	for(int x = 0; x < iSize; x++){
    		if(value == elementData.peek() && !found)
    			index = x;
    		
    		elementData.add(elementData.remove());
    	}
    	
    	if(!found)
    		throw new NoSuchElementException();
    	
    	return index;
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
        if (index < 0 || index > iSize) 
            throw new IndexOutOfBoundsException("index: " + index);
        if(index == iSize)
        	elementData.add(value);
        else
	    	for(int x = 0; x < iSize; x++){
	    		if(x == index)
	    			elementData.add(value);
	    	
	    		elementData.add(elementData.remove());
	    	}
        
        iSize++;
    }

	public void add(int[] value) {
        for(int i = 0; i < value.length; i++)
        	add(value[i]);
	}

    // pre: size() + other.size() <= capacity (throws IllegalStateException
    //      if not)
    // post: appends all values in the given list to the end of this list
    public void add(IntList other) {
    	if(other != null) 
	        for (int i = 0; i < other.size(); i++)
	            add(other.get(i));
    }
    
    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {

    	checkIndex(index);
 
    	for(int x = 0; x < iSize; x++){
    		if(x == index)
    			elementData.remove();
    		else
    			elementData.add(elementData.remove());
    	}
    			iSize -= 1;  
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the integer at the given index with the given value
    public void set(int index, int value) {
    	
    	checkIndex(index);
 
    	for(int x = 0; x < iSize; x++){
    		if(x == index){
    			elementData.remove();
    			elementData.add(value);
    		}
    		else
    			elementData.add(elementData.remove());
    	}
    }

    // post: list is empty
    public void clear() {
    	elementData.clear();
    	iSize = 0;
    }


    // post: returns an iterator for this list
    public Iterator<Integer> iterator() {
        return new IntListIterator(this);
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= iSize) 
            throw new IndexOutOfBoundsException("index: " + index);
    }

    public IntList clone(){
    	QueueIntList result = new QueueIntList();
    	
    	for(int value: elementData)
    		result.add(value);
    	
    	return result;
    }
    
	public int sum() {
	    int total = 0;
		for(int x = 0; x < iSize; x++){
			total += elementData.peek();
    		
    		elementData.add(elementData.remove());
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
