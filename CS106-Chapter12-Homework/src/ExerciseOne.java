
public class ExerciseOne {
	
	public static String starString(int n) {
		if(n < 0) {
			throw new IllegalArgumentException();
		}
		if (n == 0)
			return "*";
		else {
			String s = starString(n - 1);
			return s + s;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(starString(1));
		System.out.println(starString(2));
	}
}
