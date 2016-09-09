import java.util.ArrayList;
import java.util.Collections;

public class Exercise2 {
	public static <T> void swapPairs(ArrayList<T> list) {
		int swapLength = (list.size() / 2 * 2);
		for (int i = 0; i < swapLength; i += 2) {
			Collections.swap(list, i, i + 1);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("to");
		myList.add("be");
		myList.add("or");
		myList.add("not");
		myList.add("to");
		myList.add("be");
		myList.add("hamlet");
		System.out.println(myList);
		swapPairs(myList);
		System.out.println(myList);
	}
}
