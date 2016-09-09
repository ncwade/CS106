import java.util.LinkedList;
import java.util.Stack;

public class Exercise4 {
	public void collapse(Stack<Integer> stack) {
		LinkedList<Integer> queue = new LinkedList<Integer>(stack);
		stack.clear();
		for(int i = 0; i < queue.size(); i += 2) {
			stack.add(new Integer(queue.get(i).intValue() + queue.get(i+1).intValue()));
		}
	}
}
