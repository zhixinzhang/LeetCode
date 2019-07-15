package google.Array;

import java.util.Random;
import java.util.TreeMap;

/**
 * Created by zhang on 2018/8/1.
 */
public class _882_RandomPointinNonoverlappingRectangles {
    static int[] sum = null;
    static int[][] rect;
    static Random r = new Random();
    public static  void Solution(int[][] rects) {
        sum = new int[rects.length];
        rect = rects;
        sum[0] = 0;
        for (int i = 0; i < rects.length; i++){
            int[] rec = rects[i];
            int v = Math.abs(rec[2] - rec[0] + 1) * Math.abs(rec[3] - rec[1] + 1);
            if (i == 0)
                sum[i] = v;
            else
                sum[i] = sum[i-1] + v;
        }
    }

    public static  int[] pick() {
        int maxSum = sum[sum.length-1];
        int ran = r.nextInt(maxSum+1);
        int select = 0;
        int i = 0;
        for (;i<sum.length; i++){
            if (ran <= sum[i]){
                if (i == 0)
                    select = ran;
                else
                    select = ran - sum[i-1];
                break;
            }
        }
        int len = (Math.abs(rect[i][2] - rect[i][0])+1);
        select = 3;
        int col = select / len;
        int row = select - col * len;
        int[] res = new int[]{row+ rect[i][0],col + rect[i][1]};
        return res;
    }

    public static void main(String[] args){
//        Solution(new int[][]{{-3,-3,0,0},{1,1,5,5}});
//        pick();
        Solution_Map(new int[][]{{-3,-3,0,0},{1,1,5,5}});
        pick_map();
    }



    static TreeMap<Integer, Integer> map;
    static int[][] arrays;
    static int mapSum;
    static Random rnd = new Random();

    public static void Solution_Map(int[][] rects) {
        arrays = rects;
        map = new TreeMap<>();
        mapSum = 0;

        for(int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];

            // the right part means the number of points of this rectangle, rather than its area
            // coz ractangles gonna get picked by the num of points
            mapSum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            map.put(mapSum, i);
        }
    }

    public static int[] pick_map() {
        // nextInt(sum) returns a num in [0, sum -1]. After added by 1, it becomes [1, sum]
        int a = rnd.nextInt(mapSum) + 1;
        int c = map.ceilingKey(a);

        return pickInRect(arrays[map.get(c)]);
    }

    private static int[] pickInRect(int[] rect) {
        int left = rect[0], right = rect[2], bot = rect[1], top = rect[3];

        return new int[]{left + rnd.nextInt(right - left + 1), bot + rnd.nextInt(top - bot + 1) };
    }
}
