import java.util.ArrayList;


public class QuickSort implements Sorter<ArrayList<Card>> {
	@Override
	public void sort(ArrayList<Card> list) {
		ArrayList<Card> temp = _sort(list);
		list.clear();
		list.addAll(temp);
	}
	
	public ArrayList<Card> _sort(ArrayList<Card> list) {
		if(list.size() <= 1) {
			return list;
		}
		
		int middle = (int)Math.ceil(list.size()/2);
		Card pivot = list.get(middle);
		
		ArrayList<Card> left = new ArrayList<Card>();
		ArrayList<Card> right = new ArrayList<Card>();
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).compareTo(pivot) <= 0){
				if(i == middle){
					continue;
				}
				left.add(list.get(i));
			}
			else{
				right.add(list.get(i));
			}
		}
		
		ArrayList<Card> retList = new ArrayList<Card>();
		retList.addAll(_sort(left));
		retList.add(pivot);
		retList.addAll(_sort(right));
		return retList;
	}
}
