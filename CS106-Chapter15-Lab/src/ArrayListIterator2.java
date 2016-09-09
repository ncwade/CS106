import java.util.*;

public class ArrayListIterator2<E> implements ListIterator<E> {
    ArrayList<E> mList;
    int mPosition = -1;

    ArrayListIterator2(ArrayList<E> list){
    	this.mList = list;
    }
    
	@Override
	public boolean hasNext() {
		return mPosition < mList.size();
	}

	@Override
	public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        mPosition++;
        E result = mList.get(mPosition);
        return result;
	}

	@Override
	public boolean hasPrevious() {
		return mPosition > 0;
	}

	@Override
	public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        mPosition--;
        E result = mList.get(mPosition);
		return result;
	}

	@Override
	public int nextIndex() {
		return mPosition + 1;
	}

	@Override
	public int previousIndex() {
		return mPosition - 1;
	}

	@Override
	public void remove() {
        if (mPosition >= 0 && mPosition < mList.size()) {
            throw new IllegalStateException("Unable to remove");
        }
        mList.remove(mPosition);
	}

	@Override
	public void set(E e) {
		mList.set(mPosition, e);
	}

	@Override
	public void add(E e) {
		mList.add(e);
	}

}
