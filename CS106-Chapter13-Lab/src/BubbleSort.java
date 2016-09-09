import java.util.ArrayList;


public class BubbleSort implements Sorter<ArrayList<Card>> {
	@Override
	public void sort(ArrayList<Card> list) {
		Card temp;
		for(int i = 0; i < list.size() - 1;i++) {
			for(int j = 0; j < list.size() - i - 1; j++) {
				if (list.get(j).compareTo(list.get(j+1)) > 0) {
					temp = list.get(j);
					list.set(j,list.get(j+1));
					list.set(j+1, temp);
				}
			}
		}
	}
}
