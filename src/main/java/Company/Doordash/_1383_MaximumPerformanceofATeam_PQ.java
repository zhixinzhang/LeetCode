package Company.Doordash;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Luke Zhang
 * @Date 2021-08-12 00:01
 */
public class _1383_MaximumPerformanceofATeam_PQ {
    private class Engineer{
        int s;
        int e;

        public Engineer(int s, int e){
            this.s = s;
            this.e = e;
        }
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = (int) (1e9 + 7);
        // int[][] engineers = new int[n][2];
        Engineer[] engineers = new Engineer[n];
        for (int i = 0; i < n; ++i)
            engineers[i] = new Engineer(speed[i], efficiency[i]) ;

        Arrays.sort(engineers, (a, b) -> b.e - a.e);

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long res = Long.MIN_VALUE, totalSpeed = 0;

        for (Engineer engineer : engineers) {
            if (pq.size() == k) totalSpeed -= pq.poll();  // layoff the one with min speed
            pq.add(engineer.s);
            totalSpeed = (totalSpeed + engineer.s);
            res = Math.max(res, (totalSpeed * engineer.e));  // min efficiency is the efficiency of new engineer
        }

        return (int) (res % MOD);
    }
}

