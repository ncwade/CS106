/*
CSS 342, Winter 2005 (Stepp)
Homework 2: Linked List
*/

import java.util.Iterator;
import java.util.ListIterator;

/*
Models a doubly-linked list with dummy header and tail.
You should extend this class with your MyLinkedList to complete
the implementation.
*/
public abstract class AbstractLinkedList {
  protected final Node myFront, myBack;  // dummy headers
  protected int mySize;                  // # of elements in list
  protected long myVersion;              // incremented when list is changed

  /* Constructs a new empty list. */  
  public AbstractLinkedList() {
    myFront = new Node("dummyHead");  // they can have any value I want
    myBack  = new Node("dummyTail");
    myBack.prev = myFront;
    myFront.next = myBack;
    
    mySize = 0;
    myVersion = 0;
  }

  /* Inserts the given element at the given index. */
  public void add(int index, Object element) {
    checkIndex(index, size());

    Node curr = getNodeAt(index);

    // create the new node to hold the new element
    Node newNode = new Node(element, curr.prev, curr);
    newNode.next.prev = newNode;
    newNode.prev.next = newNode;
    
    mySize++;
    myVersion++;
  }

  /* Appends the given element to the end of this list.  Returns true. */  
  public void add(Object element) {
    add(size(), element);
  }
  
  /* Removes all elements from this list. */  
  public void clear() {
    myFront.next = myBack;
    myBack.prev = myFront;
    mySize = 0;
    myVersion++;
  }
  
  /* Returns true if this list contains the given element. */  
  public boolean contains(Object element) {
    return indexOf(element) != -1;
  }
  
  /*
  Returns the element of this list at the given index.
  Throws IndexOutOfBoundsException if index is out of range.
  */
  public Object get(int index) {
    checkIndex(index, size() - 1);

    return getNodeAt(index).element;
  }
  
  /*
  Returns the first index where the given element occurs in this list, 
  or -1 if the element is not in this list.
  */
  public int indexOf(Object element) {
    if (!isEmpty()) {
      Node node = getNodeAt(0);
      for (int i = 0; i < size(); i++) {
        Object currentElement = node.element;

        // if element is null, list's current element must be also.
        // if not, then they must be .equals to each other
        if (currentElement == null ? (element == null) : 
            currentElement.equals(element))
          return i;
        
        node = node.next;
      }
    }
    
    return -1;
  }
    
  /* Returns true if this list contains no elements. */
  public boolean isEmpty() {
    return mySize == 0;
  }
  
  /*
  Returns an iterator over the elements in this list (in proper sequence).
  This implementation merely returns a list iterator over the list. 
  */
  public abstract Iterator iterator();
  
  /*
  Returns the last index where the given element occurs in this list, 
  or -1 if the element is not in this list.
  */
  public int lastIndexOf(Object element) {
    int result = -1;

    if (!isEmpty()) {
      Node node = getNodeAt(size() - 1);
      for (int i = size() - 1; i >= 0; i--) {
        Object currentElement = node.element;

        // if element is null, list's current element must be also.
        // if not, then they must be .equals to each other
        if (currentElement == null ? (element == null) : 
            currentElement.equals(element))
          return i;
        
        node = node.prev;
      }
    }
    
    return result;
  }
    
  /* Returns an iterator of the elements in this list (in proper sequence). */
  public abstract ListIterator listIterator();

  /*
  Returns a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list. The specified index indicates the first element that would be returned by an initial call to the next method.
  */
  public abstract ListIterator listIterator(int index);
  
  /*
  Removes the element of this list at the given index and returns it.
  Throws IndexOutOfBoundsException if index is out of range.
  */
  public void remove(int index) {
    checkIndex(index, size() - 1);

    // get the node to remove, and update the references
    Node nodeToRemove = getNodeAt(index);
    nodeToRemove.prev.next = nodeToRemove.next;
    nodeToRemove.next.prev = nodeToRemove.prev;

    mySize--;
    myVersion++;
  }
  
  /*
  Removes the given element from this list, if it is present in the list.
  Returns true if the element was in the list and was removed.
  */
  public boolean remove(Object element) {
    int index = indexOf(element);
    if (index == -1)
      return false;
    
    remove(index);
    return true;
  }
  
  /*
  Sets the element of this list at the given index to have the given value.
  Throws IndexOutOfBoundsException if index is out of range.
  */
  public void set(int index, Object value) {
    checkIndex(index, size() - 1);

    myVersion++;
    getNodeAt(index).element = value;
  }
  
  /* Returns the number of elements in this list. */
  public int size() {
    return mySize;
  }
  
  /* Returns an array containing all of the elements in this list in the correct order. */
  public Object[] toArray() {
    Object[] array = new Object[size()];
    
    if (!isEmpty()) {
      Node node = getNodeAt(0);
      for (int i = 0; i < size(); i++) {
        array[i] = node.element;
        node = node.next;
      }
    }
    
    return array;
  }

  /* Returns a String representation of this list. */  
  public String toString() {
    String result = "[";

    if (!isEmpty()) {
      Node node = getNodeAt(0);
      result += node.element;
      for (int i = 1; i < size(); i++) {
        node = node.next;
        result += ", " + node.element;
      }
    }

    result += "]";

    return result;
  }

  
  /*
  Helper method: Throws an IndexOutOfBoundsException
  if 0 <= index <= max is not true.
  */
  protected void checkIndex(int index, int max) {
    if (index < 0 || index > max)
      throw new IndexOutOfBoundsException();
  }
  
  /*
  Helper method: returns the node at the given index.
  -1 returns dummy header, and size() returns the dummy tail.
  */
  protected Node getNodeAt(int index) {
    if (index < -1 || index > size())
      throw new IndexOutOfBoundsException();

    // optimization; start at closest end and go from there
    Node currentNode = null;
    if (index <= size() / 2) {
      currentNode = myFront;
      for (int i = 0; i <= index; i++)
        currentNode = currentNode.next;
    } else {
      currentNode = myBack;
      for (int i = size(); i > index; i--)
        currentNode = currentNode.prev;
    }
    
    return currentNode;
  }
  
  /* Prints a String representation of the nodes in this list, for debugging. */
  protected void printDebugInfo() {
    // infinite loop detector; change this if you want a bigger max list
    final int MAX_LOOPS = 100;
    int count = 0;
    
    System.out.println("Forwards: ");
    
    System.out.print("myFront -> ");
    int i = -1;
    for (Node curr = myFront;
         curr != null;
         curr = curr.next, i++, count++) {
      if (i >= 0 && i < size())
        System.out.print(i + ":");

      System.out.print(curr + " <-> ");

      if (count >= MAX_LOOPS || (count > 0 && curr == myFront))
        throw new RuntimeException("Probable infinite list chain detected.");
    }
    
    System.out.println("myBack");    
    System.out.println();

    System.out.println("Backwards: ");
    System.out.print("myBack  -> ");

    count = 0;
    i = size();
    for (Node curr = myBack;
         curr != null;
         curr = curr.prev, i--, count++) {
      if (i >= 0 && i < size())
        System.out.print(i + ":");

      System.out.print(curr + " <-> ");

      if (count >= MAX_LOOPS || (count > 0 && curr == myBack))
        throw new RuntimeException("Probable infinite list chain detected.");
    }
    
    System.out.println("myFront");
  }
  
  
  /* Represents one node in the list. */
  protected class Node {
    public Object element;  /* The data element */
    public Node next;  /* Reference to the next node in the list */
    public Node prev;  /* Reference to the previous node in the list */
    
    /* Constructs a new node to store the given element, with no next node. */
    public Node(Object element) {
      this(element, null, null);
    }
    
    /* Constructs a new node to store the given element and the given next node. */
    public Node(Object element, Node prev, Node next) {
      this.element = element;
      this.prev = prev;
      this.next = next;
    }
    
    /* Returns a string representation of this node.  For debugging. */
    public String toString() {
      return "(" + element + ")";
    }
  }
}