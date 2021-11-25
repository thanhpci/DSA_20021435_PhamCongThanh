import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
public class FastCollinearPoints {
    private List<LineSegment> list = new ArrayList<>();
    private LineSegment[] lines;
    public FastCollinearPoints(Point[] points) {  // finds all line segments containing 4 or more points
        if(points == null) {
            throw new java.lang.IllegalArgumentException();
        }
        for(Point p : points) {
            if(p == null) {
                throw new java.lang.IllegalArgumentException();
            }
        }

        Arrays.sort(points);

        for(int i = 0; i < points.length - 1; i++) {
            if(points[i].compareTo(points[i+1]) == 0) {
                throw new java.lang.IllegalArgumentException();
            }
        }

        for (int i = 0; i < points.length; i++) {
            Point origin = points[i];
            Point[] aux = Arrays.copyOf(points, points.length);
            Double[] slope = new Double[aux.length];
            int k = 1;
            Arrays.sort(aux);
            Arrays.sort(aux, origin.slopeOrder());
            for (int j = 0; j < aux.length - 2; j++) {
                while (j + k < aux.length && origin.slopeTo(aux[j]) == origin.slopeTo(aux[j + k])) {
                    k++;
                }
                if (k > 2) {
                    if (origin.compareTo(aux[j]) < 0) {
                        list.add(new LineSegment(origin, aux[j + k - 1]));
                    }
                }
                j = j + k - 1;
                k = 1;
            }
        }
        lines = list.toArray(new LineSegment[list.size()]);
    }
    public int numberOfSegments() {       // the number of line segments
        return list.size();
    }

    public LineSegment[] segments() {
        return lines;
    }
}
