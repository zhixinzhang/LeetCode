package google;

/**
 * Created by zhang on 2018/5/19.
 */
public class _644_MaximumAverageSubarray2_BinarySearch {
        public double findMaxAverage(int[] nums, int k) {
            double low = Integer.MIN_VALUE, high = Integer.MAX_VALUE;
            while (low < high){
                double mid = (low + high) / 2;
                if (check(nums,k,mid)){
                    mid = low;
                }else {
                    mid = high;
                }
            }
            return high;
        }
        private boolean check(int[] nums, int k, double average){
            int n = nums.length;
            double[] a = new double[n]; // 对应的每个nums 值 减去当前的average 是大于0 还是小于0
            for (int i = 0; i< n; i++){
                a[i] = average - nums[i];
            }
            double sum = 0;
            double now = 0, last = 0;
            for (int j = 0; j<k; j++){
                sum += a[j];
            }
            if (sum > 0) return true;
            for (int i = k; i<n; i++){  // 遍历 k。。。 N个average 只要大于 average 就可以返回true
                now += a[i];
                last += a[i-1];
                if (last < 0){
                    now -= last;
                    last = 0;
                }
                if (now > 0)
                    return true;
            }
            return false;
        }
    }
