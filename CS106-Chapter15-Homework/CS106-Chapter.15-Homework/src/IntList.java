
import java.util.Iterator;

public interface IntList {
    public void add(int value);
    public void add(int index, int value);
    public void add(int[] value);
    public void add(IntList other);
    public int get(int index);
    public int indexOf(int value);
    public boolean isEmpty();
    public void remove(int index);
    public void set(int index, int value);
    public int size();
    public boolean contains(int value);
    public int sum();
    public double average();
    public void clear();
    public IntList clone();
    public Iterator<Integer> iterator();
}
