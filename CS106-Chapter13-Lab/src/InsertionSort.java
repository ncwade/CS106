import java.util.ArrayList;

public class InsertionSort implements Sorter<ArrayList<Card>> {

	@Override
	public void sort(ArrayList<Card> list) {
		   int i,j;

		    for (i = 1; i < list.size(); i++) {
		        Card key = list.get(i);
		        j = i;
		        while((j > 0) && (list.get(j - 1).compareTo(key) > 0)) {
		        	list.set(j,list.get(j - 1));
		            j--;
		        }
		        list.set(j,key);
		    }
	}
}
