import java.awt.Point;
import java.util.Comparator;

public class PointComparator implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
		double sum1 = Math.abs(o1.getX() + o1.getY());
		double sum2 = Math.abs(o2.getX() + o2.getY());
		return (int) (sum1-sum2);
	}

}
