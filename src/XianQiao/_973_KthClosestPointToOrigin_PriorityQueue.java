package XianQiao;

import java.util.PriorityQueue;

/**
 * @Author: Xianqiao
 * @Date: 7/20/20 00:07
 */
public class _973 {
    public static int[][] kClosest(int[][] points, int K) {
        if (K <= 0 || points == null || points.length == 0 || points[0].length == 0) {
            return null;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> (n2-n1));
        int[][] ans = new int[K][2];
        int[] sum = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int[] cur = points[i];
            int cur_sum = cur[0] * cur[0] + cur[1] * cur[1];
            sum[i] = cur_sum;
            heap.add(cur_sum);
            if (heap.size() > K) {
                heap.remove();
            }
        }
        int max_sum = heap.peek();
        int k = 0;
        for (int j = 0; j < sum.length; j++) {
            if (sum[j] <= max_sum) {
                ans[k] = points[j];
                k++;
            }
        }
        return ans;
    }
    public static void main (String[] args) {
        int[][] test = new int[][] {{-5,4},{-6,-5},{4,6}};
        kClosest(test, 2);
    }
}
