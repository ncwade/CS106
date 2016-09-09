import java.util.ArrayList;


public class MergeSort implements Sorter<ArrayList<Card>> {
	@Override
	public void sort(ArrayList<Card> list) {
		ArrayList<Card> temp = _sort(list);
		list.clear();
		list.addAll(temp);
	}
	
	public ArrayList<Card> _sort(ArrayList<Card> list) {
		ArrayList<Card> left = new ArrayList<Card>();
	    ArrayList<Card> right = new ArrayList<Card>();
	    if (list.size() > 1) {
	        int middle = list.size()/2;
	        for (int i=0; i<middle; i++) {
	                left.add(list.get(i));
	        }

	        for (int i=middle; i<list.size(); i++) {
	                right.add(list.get(i));
	        }

	        left  = _sort(left);
	        right = _sort(right);
	        return merge(left, right);
	    }
		return list;
	}
	
	private ArrayList<Card> merge(ArrayList<Card> left, ArrayList<Card> right) {
		ArrayList<Card> list = new ArrayList<Card>();

	    while (left.size() > 0 && right.size() > 0) {
	        if ( (left.get(0).compareTo(right.get(0))) < 0) {
	            list.add(left.remove(0));
	        } else {
	            list.add(right.remove(0));
	        }
	    }

	    if (left.size() > 0) {
	    	list.addAll(left);
	    } else {
	    	list.addAll(right);
	    }
	    return list;
	}
}
