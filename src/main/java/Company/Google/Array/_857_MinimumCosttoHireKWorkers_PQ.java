package Company.Google.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by zhang on 2018/6/27.
 * https://leetcode.com/problems/minimum-cost-to-hire-k-workers/discuss/141768/Detailed-explanation-O(NlogN)
 */
public class _857_MinimumCosttoHireKWorkers_PQ {
    // 我的TLE 但是感觉很厉害哦
    public static double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        // ratio [7 2.5 6] -> [7 6 2.5]
        // quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
        // [1.333   8   0.2 0.2   7] -> [8  7  1.3333   0.2  0.2]
        if(quality == null || wage == null || K == 0) return 0;
        PriorityQueue<Double> pq = new PriorityQueue<Double>((a,b)->((int)(a - b))); // 3 2 1
        for (int i = 0; i<quality.length; i++){
            pq.add((double)(wage[i]) / quality[i]);
        }
        HashMap<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
        for(int i = 0; i<quality.length; i++){
            hm.putIfAbsent(quality[i], new PriorityQueue<>());
            hm.get(quality[i]).add(wage[i]);
        }
        Arrays.sort(quality);
        for (int i = 0; i < quality.length; i++){
            wage[i] = hm.get(quality[i]).poll();
        }
        int count = 0;

        double res = Double.MAX_VALUE;
        for(int i = 0; i<quality.length; i++){
            double curRes = 0;
            double ratio = pq.poll();    // 8
            for(int j = 0; j < quality.length; j++){
                if((double)quality[j] * ratio >= (double)wage[j]){
                    if(count < K){
                        count++;
                        curRes += (double)quality[j] * ratio;
                    }else
                        break;
                }
            }
            if(count == K){
                res = Math.min(res,curRes);
            }
            count = 0;
        }
        return res;
    }

    public static double mincostToHireWorkers__sort(int[] q, int[] w, int K) {
        double[][] workers = new double[q.length][2];
        for (int i = 0; i < q.length; ++i)
            workers[i] = new double[]{(double)(w[i]) / q[i], (double)q[i]};
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        double res = Double.MAX_VALUE, qsum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
//        PriorityQueue<PB> p = new PriorityQueue<>((a,b) -> Double.compare(a.rates , b.rates));
        // ratio [7 2.5 6] -> [7 6 2.5]
        // quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
        //[0.2 0.2 1.333  7  8]

        for (double[] worker: workers) {
            qsum += worker[1];
            pq.add(-worker[1]);
            if (pq.size() > K)
                qsum += pq.poll();          // 重点是 保留k个小的 qualify的人！！！
            if (pq.size() == K)
                res = Math.min(res, qsum * worker[0]);
        }
        return res;
    }

    class PB{
        double rates;
        PB(double rates){
            this.rates = rates;
        }
    }
    //最低cost 雇所有员工
    public static double mincostToHireWorkers__sort_all(int[] q, int[] w, int K) {
        //quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
        // [1.333, 8, 0.2, 0.2, 7]
        // [3      1   10   10  1]
        // [0.2 0.2 1.333  7  8]
        // [10   10   3    1   1]
        int n = q.length;
        double[][] worker = new double[n][2];
        for (int i = 0; i<n; i++){
            worker[i][0] = (double) w[i]/q[i];
            worker[i][1] = (double)q[i];
        }
        Arrays.sort(worker, (a,b)-> Double.compare(a[0],b[0]));
//        for (){
//
//        }
        return 0;
    }


        public static void main(String[] args){
            mincostToHireWorkers__sort(new int[]{10,4,2,1},new int[]{5,4,4,5},2);

//        mincostToHireWorkers__sort(new int[]{10,20,5},new int[]{70,50,30},2);
    }
}
