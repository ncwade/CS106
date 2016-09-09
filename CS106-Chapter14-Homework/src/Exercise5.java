import java.util.Stack;

public class Exercise5 {
	public <T> boolean equals(Stack<T> s1, Stack<T> s2) {
		if (s1.isEmpty() != s2.isEmpty()) {return false;}
		if (s1.isEmpty() && s2.isEmpty()) {return true;}
		T a = s1.pop();
		T b = s2.pop();
		try {
			if (!a.equals(b)) {
				return false;
			} else {
				return equals(s1,s2);
			}
		} finally {
			s1.push(a);
			s2.push(b);
		}
	}
}
