package DataStructure.Array;


import java.util.HashMap;
import java.util.Map;
/**
 *
 * Time complexity : \mathcal{O}(N^2)O(N
 * 2
 *  ) since one draws not more than N - 1 lines passing through the point 0, not more than N - 2 lines for the point 1, and the only one line for the point N - 2. That results in (N - 1) + (N - 2) + .. + 1 = N(N - 1)/2 operations, i.e. \mathcal{O}(N^2)O(N
 * 2
 *  ) time complexity.
 *
 * Space complexity : \mathcal{O}(N)O(N) to track down not more than N - 1 lines.
 * */

public class _149_MaxPointsonaLine{
    public int maxPoints(int[][] points) {
        int n = points.length;
        int out = 0;
        if(n==1)
            return n;
        Map<Double, Integer> map = new HashMap<>(); // count pairs of points having same slops
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                // if(i==j)
                //     continue;
                Double m = null; // null values as key is for vertical lines having slop = 90degree
                if(points[i][1]==points[j][1]){ // straight horizontal line
                    m = 0.0;
                } else if(points[i][0]!=points[j][0]){
                    m = ((points[i][1]-points[j][1])*1.0)/(points[i][0]-points[j][0]);
                }


                int val = map.getOrDefault(m,1);
                val++;
                map.put(m, val);
                out = Math.max(out, val);
            }

            map = new HashMap<>();
        }
        return out;
    }
}