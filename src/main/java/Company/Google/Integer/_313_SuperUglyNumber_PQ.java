package Company.Google.Integer;

import java.util.PriorityQueue;

/**
 * Created by zhang on 2018/6/22.
 */
public class _313_SuperUglyNumber_PQ {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<int[]> queue=new PriorityQueue<>((a, b)->(a[0]-b[0]));
        for (int i=0;i<primes.length;i++)
            queue.offer(new int[]{primes[i], primes[i], 0});

        int[] nums = new int[n+1];
        nums[0] = 1;

        int i = 1;
        /** prime [2 3 7]
         *  [2 2 0] [3 3 0] [7 7 0]
         * **/
        while (i<n){
            int[] entry=queue.poll();
            int num = entry[0], prime = entry[1], index = entry[2];
            if (num != nums[i-1]){
                nums[i] = num;
                i++;
            }
            queue.offer(new int[]{prime * nums[index+1], prime, index+1});
        }
        return nums[n-1];
    }
}
