package google;

import java.util.*;

/**
 * Created by zhang on 2018/8/4.
 * https://leetcode.com/problems/rectangle-area-ii/solution/
 */
public class _850_RectangleArea2_sort {
    public static int rectangleArea(int[][] rectangles) {
        int OPEN = 0, CLOSE = 1;
        int[][] events = new int[rectangles.length * 2][];
        int t = 0;
        for (int[] rec: rectangles) {
            events[t++] = new int[]{rec[1], OPEN, rec[0], rec[2]};
            events[t++] = new int[]{rec[3], CLOSE, rec[0], rec[2]};
        }

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> active = new ArrayList<>();
        int cur_y = events[0][0];
        long ans = 0;
        for (int[] event: events) {
            int y = event[0], typ = event[1], x1 = event[2], x2 = event[3];

            // Calculate query
            long query = 0;
            int cur = -1;
            for (int[] xs: active) {
                cur = Math.max(cur, xs[0]);
                query += Math.max(xs[1] - cur, 0);
                cur = Math.max(cur, xs[1]);
            }

            ans += query * (y - cur_y);

            if (typ == OPEN) {
                active.add(new int[]{x1, x2});
                Collections.sort(active, (a, b) -> Integer.compare(a[0], b[0]));
            } else {
                for (int i = 0; i < active.size(); ++i)
                    if (active.get(i)[0] == x1 && active.get(i)[1] == x2) {
                        active.remove(i);
                        break;
                    }
            }

            cur_y = y;
        }

        ans %= 1_000_000_007;
        return (int) ans;
    }

    public static void main(String[] args){

//        rectangleArea(new int[][]{{1,1,3,2},{2,1,5,5},{4,2,5,5}});
        recArea_MySolu(new int[][]{{0,0,3,4},{5,5,10,10}});// 1 2 7 8
    }

    public static int recArea_MySolu(int[][] rectangles){
        int open = 0, close = 1;
        int n = rectangles.length;
        int[][] events = new int[n*2][];
        int t = 0;
        for (int[] rect : rectangles){
            events[t++] = new int[]{rect[0],open,rect[1],rect[3]};
            events[t++] = new int[]{rect[2],close,rect[1],rect[3]};
        }
//        Arrays.sort(events,(a,b)->(a[0] - b[0]));
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        int sweepLine = -1;
        HashSet<String> vis = new HashSet<>();
        for (int i = 0; i < events.length; i++){
            int[] event = events[i];
            String s = String.valueOf(event[2]) + "*" + String.valueOf(event[3] - event[2]);
            if (sweepLine == -1){
                sweepLine = event[3] - event[2];
                if (event[1] == 0){
                    vis.add(s);
                }else {
                    vis.remove(s);
                }
            }else {

            }

        }
        return 0;
    }
}
