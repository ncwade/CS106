
public class Main {
	// Added for homework problem 8
	public void descending(int[] numbers) {
		HeapPriorityQueue<Integer> sorted = new HeapPriorityQueue<Integer>();
		
		for(int num : numbers) {
			sorted.add(num);
		}
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = sorted.remove();
		}
	}
}
