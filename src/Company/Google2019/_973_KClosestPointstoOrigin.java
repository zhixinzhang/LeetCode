package Company.Google2019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/8/19
 * Time: 3:24 PM
 * Description:
 *
 * https://leetcode.com/problems/k-closest-points-to-origin/solution/
 */


public class _973_KClosestPointstoOrigin {
    public static void main(String[] args){
        kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2);
    }

    //classic sort pq question O(n*logk)
    public static int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        int index = 0;
        for (int[] p : points){
            int dis = p[0]*p[0] + p[1]*p[1];
            if (pq.size() < K)
                pq.add(new int[]{dis, index});
            else if (pq.peek()[0] > dis){
                pq.poll();
                pq.add(new int[]{dis, index});
            }
            index++;
        }
        int r = 0;
        for (int[] i : pq){
            res[r] = points[i[1]];
            r++;
        }
        return res;
    }

    public static int[][] kClosest_divideConquer(int[][] points, int K) {
        return quickSort(points, 0, points.length - 1, K);
    }

    public static int[][] quickSort(int[][] nums, int start, int end, int k) {
        int low = start;
        int pivot = dis(nums[end]);

        for (int i = start; i < end; i++) {
            if (dis(nums[i]) <= pivot) {
                exchange(nums, low++, i);
            }
        }
        exchange(nums, low, end);

        if (low == nums.length - k) {
            return Arrays.copyOfRange(nums,0,k);
        }
        else if (low > nums.length - k) {
            return quickSort(nums, start, low - 1, k);
        }
        else {
            return quickSort(nums, low + 1, end, k);
        }

    }

    private static int dis(int[] nums){
        return nums[0]*nums[0] + nums[1]*nums[1];
    }
    private static void exchange(int[][] nums, int i, int j){
        int[] temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    public int[][] kClosest_PQ(int[][] points, int K) {
        if(points == null || points.length == 0)
            return null;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                int d1 = a[0] * a[0] + a[1] * a[1];
                int d2 = b[0] * b[0] + b[1] * b[1];
                return d2 - d1;
            }
        });
        for(int[] p : points){
            maxHeap.add(p);
            if(maxHeap.size() > K)
                maxHeap.poll();
        }

        int[][] res = Arrays.copyOf(points, K);
        int[][] ans = new int[K][2];
        int i = 0;
        for(int[] p : maxHeap){
            ans[i] = p;
            i++;
        }
        return ans;
    }
}
