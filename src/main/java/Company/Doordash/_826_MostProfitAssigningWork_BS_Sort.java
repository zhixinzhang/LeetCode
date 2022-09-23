package Company.Doordash;

import java.util.Arrays;

public class _826_MostProfitAssigningWork_BS_Sort {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int res = 0;

        // jobs[i][0] is the difficulty of i job and jobs[i][1] is the profit of i job
        int N = difficulty.length;
        int[][] jobs = new int[N][2];
        for (int i = 0; i < N; ++i) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // Sort the array into the non-decreasing order of difficulty
        Arrays.sort(jobs, (x, y) -> x[0] - y[0]);

        // Update the profit to max profit of corresponding difficulty
        for (int i = 1; i < N; ++i)
            jobs[i][1] = Math.max(jobs[i][1], jobs[i - 1][1]);


        // For worker i, the ablity is worker[i]
        // We need to find the biggest difficult job j, difficulty[j] <= worker[i]
        for (int i = 0; i < worker.length; ++i) {
            int target = worker[i];

            int left = 0, right = N;
            while (left < right) {
                int mid = left + (right - left) / 2;

                if (jobs[mid][0] > target)
                    right = mid;
                else
                    left = mid + 1;
            }

            left -= 1;
            if (left < 0)
                continue;

            res += jobs[left][1];
        }

        return res;
    }
}
