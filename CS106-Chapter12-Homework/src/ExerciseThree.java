
public class ExerciseThree {
	public static void writeSequence(int number) {
		if (number < 1) throw new IllegalArgumentException();
		if (number == 1) {
			System.out.print("1");
		} else if (number == 2) {
			System.out.print("1 1");
		} else {
			int m = (number+1) / 2;
			System.out.print(m + " ");
			writeSequence(number - 2);
			System.out.print(" " + m);
		}
	}

	public static void main(String[] args) {
		writeSequence(10);
		System.out.println();
		writeSequence(5);
		System.out.println();
	}
}
