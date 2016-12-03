package Medium;

/**
 * Created by achaurasia on 12/2/16.
 */
import java.util.*;

public class KNN {
    List<Point> points = new ArrayList<>();
    public static void main(String args[]) {
        KNN t =  new KNN();
        t.populatePoints();
        List<Point> result = t.getNearestNeighbors(5);
        for(Point p : result) {
            System.out.println(p.toString());
        }
    }

    public void populatePoints() {
        Point origin = new Point(0, 0);
        points.add(new Point(1, 1, origin));
        points.add(new Point(1, 3, origin));
        points.add(new Point(-1, 1, origin));
        points.add(new Point(-1, 3, origin));
        points.add(new Point(1, -1, origin));
        points.add(new Point(3, -1, origin));
        points.add(new Point(-1, -1, origin));
        points.add(new Point(-1, 3, origin));
        points.add(new Point(2, 2, origin));
    }

    public List getNearestNeighbors(int k) {
        Collections.sort(points, Collections.reverseOrder());
        return points.subList(0, k);
    }

    class Point implements Comparable<Point> {
        int x;
        int y;
        double dist;
        public Point(int x, int y, Point origin) {
            this.x = x;
            this.y = y;
            this.dist = Math.sqrt(Math.pow(origin.x - x, 2) + Math.pow(origin.y - y, 2));
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = 0;
        }

        @Override
        public int compareTo(Point point) {
            return Double.valueOf(point.dist).compareTo(dist);
        }

        @Override
        public String toString() {
            return "x : " + x + ", y : " + y + ", dist : " + dist;
        }
    }
}