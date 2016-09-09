
public class ExerciseNineteen {
	// I don't know how to do this one without passing a string.
	public static void countBinary(String s, int n){
	    if(n < 0) {
	    	throw new IllegalArgumentException();
	    }
	    if(n == 0) {
	        System.out.println(s);
	        return;
	    }
	    countBinary(s + "0", n-1);
	    countBinary(s + "1", n-1);
	}
	
	public static void main(String[] args) {
		countBinary("",1);
		countBinary("",5);
	}
}
