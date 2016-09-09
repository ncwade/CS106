import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList extends AbstractLinkedList {
	Node currentNode = null;
	Node lastNode = null;
	int mIndex = -1;

	@Override
	public Iterator iterator() {
		return listIterator();
	}

	@Override
	public ListIterator listIterator() {
		currentNode = myFront;
		return new MyListIterator();
	}

	@Override
	public ListIterator listIterator(int index) {
		if(index - 1 >= 0) {
			currentNode = getNodeAt(index-1);
			mIndex = index-1;
		} else {
			currentNode = myFront;
		}
		return new MyListIterator();
	}
	
	private class MyListIterator implements ListIterator<Object> {

		@Override
		public boolean hasNext() {
			return !isEmpty() && currentNode != myBack;
		}

		@Override
		public Object next() {
			if(currentNode == myBack) {
				throw new NoSuchElementException();
			}
			currentNode = currentNode.next;
			mIndex++;
			return currentNode;
		}

		@Override
		public boolean hasPrevious() {
			return !isEmpty() && currentNode != myFront;
		}

		@Override
		public Object previous() {
			if(currentNode == myFront) {
				throw new NoSuchElementException();
			}
			currentNode = currentNode.prev;
			mIndex--;
			return currentNode;
		}

		@Override
		public int nextIndex() {
			return mIndex+1;
		}

		@Override
		public int previousIndex() {
			return mIndex - 1;
		}

		@Override
		public void remove() {
			if(!hasPrevious()) {
				throw new IllegalStateException();
			}
			currentNode.prev.next = currentNode.next;
			currentNode = currentNode.prev;
		}

		@Override
		public void set(Object e) {
			currentNode.element = e;
		}

		@Override
		public void add(Object e) {
			if(currentNode == myFront) {
				Node newNode = new Node(e,currentNode,currentNode.next);
				currentNode.next = newNode;
			} else if (currentNode == myBack) {
				Node newNode = new Node(e,currentNode.prev,currentNode);
				currentNode.prev = newNode;
			} else {
				Node newNode = new Node(e,currentNode.prev,currentNode);
				currentNode.prev.next = newNode;
			}
		}

	}

}
