import java.util.LinkedList;
import java.util.Stack;

public class Exercise20 {
	public void interleave(LinkedList<Integer> queue) {
		if(queue.size() % 2 != 0) {
			throw new IllegalArgumentException();
		}

		Stack<Integer> stack = new Stack<Integer>();
		int size = queue.size();

		for(int i = 0; i < size; i += 2) {
			stack.add(queue.remove());
			for(int j = i+1; j < size; j++) {
				if(j == (i + (size / 2))) {
					stack.add(queue.remove());
				} else {
					queue.add(queue.remove());
				}
			}
		}
		
		queue = new LinkedList<Integer>(stack);
	}
}
