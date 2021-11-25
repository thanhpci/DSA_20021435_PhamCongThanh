import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class BruteCollinearPoints
{
    private LineSegment[] lines;
    private List<LineSegment> list = new ArrayList();
    public BruteCollinearPoints(Point[] points) {
        if(points == null) {
            throw new java.lang.IllegalArgumentException();
        }

        for(Point p : points) {
            if(p == null) {
                throw new java.lang.IllegalArgumentException();
            }
        }

        Arrays.sort(points, Point::compareTo);

        for(int i = 0; i < points.length - 1; i++) {
            if(points[i].compareTo(points[i+1]) == 0) {
                throw new java.lang.IllegalArgumentException();
            }
        }

        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        if (Canformline(points[i], points[j], points[k], points[l])) {
                            list.add(new LineSegment(points[i], points[l]));
                        }
                    }
                }
            }
        }
        lines = list.toArray(new LineSegment[list.size()]);
    }
    public int numberOfSegments() {
        return list.size();
    }

    public LineSegment[] segments() {
        return lines;
    }

    private boolean Canformline(Point i, Point j, Point k, Point l) {
        if (i.slopeTo(j) == i.slopeTo(k)) {
            if (i.slopeTo(j) == i.slopeTo(l)) {
                return true;
            }
        }
        return false;
    }
}
