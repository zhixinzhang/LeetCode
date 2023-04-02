package Company.Google;

/**
 * Created by zhang on 2018/5/19.
 */
public class _643_MaximumAverageSubarray1_SlidingWindow {
        public double findMaxAverage(int[] nums, int k) {
            double res = 0.00;
            // sliding window sum s[0] --- s[k-1]
            double sum = res;
            for (int i = 0; i<k; i++){
                sum += nums[i];
            }
            res = Math.max(sum,res);
            for (int i = k; i< nums.length; i++){
                // 0 1 2    1 2 3
                sum += nums[i] - nums[i - k];
                res = Math.max(res, sum);
            }
            return res;
        }
    }
