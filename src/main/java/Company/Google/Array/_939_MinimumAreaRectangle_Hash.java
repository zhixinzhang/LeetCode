package Company.Google.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 11/20/18
 * Time: 10:55 AM
 * Description:
 */

//我的放啊 TLE 但是思路对 重点是我创建了Point类 里面重写了 equals and hashcode 很好
// 正确方法是第一个

public class _939_MinimumAreaRectangle_Hash {

    public int minAreaRect_hash(int[][] points) {
        Set<Integer> pointSet = new HashSet();
        for (int[] point: points)
            pointSet.add(40001 * point[0] + point[1]);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; ++i)
            for (int j = i+1; j < points.length; ++j) {
                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                    if (pointSet.contains(40001 * points[i][0] + points[j][1]) &&
                            pointSet.contains(40001 * points[j][0] + points[i][1])) {
                        ans = Math.min(ans, Math.abs(points[j][0] - points[i][0]) *
                                Math.abs(points[j][1] - points[i][1]));
                    }
                }
            }

        return ans < Integer.MAX_VALUE ? ans : 0;
    }

    //
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj){

            if (obj == null) return false;
            if (!(obj instanceof Point))
                return false;
            if (obj == this)
                return true;
            return this.x == ((Point) obj).x && this.y == ((Point)obj).y;
        }

        @Override
        public int hashCode() {
            return this.x;
        }

    }
    public static int minAreaRect(int[][] points) {
        int min = Integer.MAX_VALUE;
        if(points == null || points[0].length == 0)
            return 0;
        HashSet<Point> cache = new HashSet<>();
        for(int[] p : points){
            cache.add(new Point(p[0],p[1]));
        }

        for(int i = 0; i < cache.size(); i++){
            for (int j = 1; j < cache.size(); j++){         //[1 , 2]   [5 , 5]   -> [1,5] [2,5]
                int[] x = points[i];
                int[] y = points[j];
                Point p1 = new Point(x[0],y[1]);
                Point p2 = new Point(y[0],x[1]);
                if (cache.contains(p1) && cache.contains(p2)){
                    if (x[0] == y[0] || x[1] == y[1])
                        continue;
                    int curArea = Math.abs((x[0] - y[0]) * (x[1] - y[1]));
                    min = Math.min(min, curArea);
                }
            }
        }
        if (min == Integer.MAX_VALUE)
            return 0;
        else
            return min;
    }
    public static void main(String[] args){
        int[][] points = new int[][]{{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
        System.out.println(minAreaRect(points));
    }
}
