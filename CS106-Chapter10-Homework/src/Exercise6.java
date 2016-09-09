import java.util.ArrayList;
import java.util.Collections;

public class Exercise6 {

	public static void minToFront(ArrayList<Integer> inList) {
		int minIndex = inList.indexOf(Collections.min(inList));
		Integer itemToMove = inList.get(minIndex);
		inList.remove(minIndex);
		inList.add(0, itemToMove);
	}

	public static void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		myList.add(new Integer(3));
		myList.add(new Integer(8));
		myList.add(new Integer(92));
		myList.add(new Integer(4));
		myList.add(new Integer(2));
		myList.add(new Integer(17));
		myList.add(new Integer(9));
		System.out.println(myList);
		minToFront(myList);
		System.out.println(myList);
	}
}
