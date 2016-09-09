import java.util.ArrayList;


public class SelectionSort implements Sorter<ArrayList<Card>> {
	@Override
	public void sort(ArrayList<Card> list) {
		for(int currentPosition = 0; currentPosition < list.size();currentPosition++) {
			Card smallest = list.get(currentPosition);
			int smallIndex = currentPosition;

			for(int j = currentPosition + 1; j < list.size(); j++) {
				if(smallest.compareTo(list.get(j)) > 0) {
					smallest = list.get(j);
					smallIndex = j;
				}
			}
			
			if(smallIndex != currentPosition) {
				Card temp = list.get(currentPosition);
				list.set(currentPosition, list.get(smallIndex));
				list.set(smallIndex, temp);
			}
		}
	}
}
