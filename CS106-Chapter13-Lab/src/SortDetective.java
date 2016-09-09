import java.util.Scanner;


public class SortDetective {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter number of decks to shuffle: ");
		int numDecks = reader.nextInt();
		System.out.println("Enter number of tests to run: ");
		int numTests = reader.nextInt();
		System.out.println("Select the sorting algorithm to utilize.");
		System.out.println("1) Selection Sort");
		System.out.println("2) Insertion Sort");
		System.out.println("3) Merge Sort");
		System.out.println("4) Quick Sort");
		System.out.println("5) Bubble Sort");
		int shuffleOption = reader.nextInt();
		
		// Run once for each test.
		long start = System.nanoTime();
		for(int i = 0; i < numTests; i++){
			// Shuffle a shoe equal to requested decks.
			Shoe shoe = new Shoe(numDecks);
			switch(shuffleOption) {
				case  1: shoe.sortShoe(new SelectionSort()); break;
				case  2: shoe.sortShoe(new InsertionSort()); break;
				case  3: shoe.sortShoe(new MergeSort()); break;
				case  4: shoe.sortShoe(new QuickSort()); break;
				case  5: shoe.sortShoe(new BubbleSort()); break;
				default: shoe.sortShoe(); break;
			}
		}
		long time = System.nanoTime() - start;
		System.out.printf("Average Time: %.1f ms", ((double) time / numTests)/100000);
		System.out.println();
		reader.close();
	}
}
