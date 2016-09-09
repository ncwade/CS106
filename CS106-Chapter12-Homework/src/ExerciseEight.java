
public class ExerciseEight {
	private static int multiplyEvens(int number) {
		if(number < 1) {
			throw new IllegalArgumentException("Value less than 1 not supported");
		} else if(number == 1) {
			return 2;
		} else {
			return multiplyEvens(number-1) * (number*2);
		}
	}
	
	public static void main(String[] args) {
	    System.out.println(multiplyEvens(4));
	}
}
