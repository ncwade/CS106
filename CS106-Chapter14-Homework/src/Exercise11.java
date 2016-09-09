import java.util.Queue;

public class Exercise11 {
	public void reorder(Queue<Integer> queue) {
		int size = queue.size();
		for(int i = 0; i < size;i++) {
			Integer one = queue.remove();
			int size2 = queue.size();
			for(int a = 0; a <size2;a++) {
				Integer two = queue.remove();
				if(one.intValue() < two.intValue()) {
					queue.add(two);
				} else {
					queue.add(one);
					one = two;
				}
			}
			queue.add(one);
		}
	}
}
