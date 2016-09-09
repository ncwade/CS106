import java.util.ArrayList;

public class Exercise15 {
	public static void filterRange(ArrayList<Integer> inList, int min, int max) {
		ArrayList<Integer> outList = new ArrayList<Integer>();
		for(Integer value : inList) {
			if(value.intValue() < min || value.intValue() > max) {
				outList.add(value);
			}
		}
		inList.clear();
		for(Integer value : outList) {
			inList.add(value);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		myList.add(new Integer(4));
		myList.add(new Integer(7));
		myList.add(new Integer(9));
		myList.add(new Integer(2));
		myList.add(new Integer(7));
		myList.add(new Integer(7));
		myList.add(new Integer(5));
		myList.add(new Integer(3));
		myList.add(new Integer(5));
		myList.add(new Integer(1));
		myList.add(new Integer(7));
		myList.add(new Integer(8));
		myList.add(new Integer(6));
		myList.add(new Integer(7));
		System.out.println(myList);
		filterRange(myList,5,7);
		System.out.println(myList);
	}
}
