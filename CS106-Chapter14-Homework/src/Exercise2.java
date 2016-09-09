import java.util.LinkedList;
import java.util.Stack;

public class Exercise2 {
	public <T> void stutter(Stack<T> stack) {
		LinkedList<T> queue = new LinkedList<T>(stack);
		stack.clear();
		for(T value : queue) {
			stack.add(value);
			stack.add(value);
		}
	}
}
