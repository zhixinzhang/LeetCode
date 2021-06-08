package DataStructure.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Luke Zhang
 * @Date 2021-06-06 17:37
 */
public class _356_LineReflection_Set {

    public boolean isReflected(int[][] points) {
        if (points == null || points[0].length == 0)
            return true;

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        HashSet<String> set = new HashSet<>();
        for (int[] point : points){
            left = Math.min(left, point[0]);
            right = Math.max(right, point[0]);
            String str = point[0] + "#" + point[1];
            set.add(str);
        }

        int sum = left + right;
        for (int[] point : points){
            String s = (sum - point[0]) + "#" + point[1];
            if (!set.contains(s)){
                return false;
            }
        }

        return true;
    }


    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point reverseX(int sum) {
            int reverseX = sum - x;
            return new Point(reverseX, y);
        }

        @Override
        public boolean equals(Object o) {
            Point that = (Point)o;
            return this.x == that.x && this.y == that.y;
        }

        @Override
        public int hashCode() {
            return 17 * x + 31 * y;
        }
    }

    public boolean isReflected_Set(int[][] points) {
        Set<Point> set = new HashSet();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; ++i) {
            set.add(new Point(points[i][0], points[i][1]));
            min = Math.min(min, points[i][0]);
            max = Math.max(max, points[i][0]);
        }
        int sum = max + min;
        for (Point p : set) {
            Point reverse = p.reverseX(sum);
            if (!set.contains(reverse)) {
                return false;
            }
        }
        return true;
    }

}
