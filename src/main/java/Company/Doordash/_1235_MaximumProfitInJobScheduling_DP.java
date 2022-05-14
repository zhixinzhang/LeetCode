package Company.Doordash;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Luke Zhang
 * @Date 2021-08-11 14:59
 *
 * dp[i] = max(dp[i-1],dp[j]+profit_i) where j is the first nonoverlapping interval to i
 */
public class _1235_MaximumProfitInJobScheduling_DP {
    private class Job {
        int start, finish, profit;
        Job(int start, int finish, int profit) {
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for(int i=0;i<n;i++) {
            jobs[i] = new Job(startTime[i],endTime[i],profit[i]);
        }
        return scheduleApt(jobs);
    }

    private int scheduleApt(Job[] jobs) {
        // Sort jobs according to finish time
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.finish));
//        Arrays.sort(jobs, (a, b) -> a.finish - b.finish);
        // dp[i] stores the profit for jobs till jobs[i]
        // (including jobs[i])
        int n = jobs.length;
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        for (int i=1; i<n; i++) {
            // Profit including the current job
            int profit = jobs[i].profit;
            int l = search(jobs, i);
            if (l != -1)
                profit += dp[l];
            // Store maximum of including and excluding
            dp[i] = Math.max(profit, dp[i-1]);
        }

        return dp[n-1];
    }

    private int search(Job[] jobs, int index) {
        int start = 0, end = index - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (jobs[mid].finish <= jobs[index].start) {
                if (jobs[mid + 1].finish <= jobs[index].start)
                    start = mid + 1;
                else
                    return mid;
            }
            else
                end = mid - 1;
        }
        return -1;
    }
}
