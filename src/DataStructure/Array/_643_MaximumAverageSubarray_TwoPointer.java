package DataStructure.Array;


public class _643_MaximumAverageSubarray_TwoPointer{
        public static void main(String[] args){
            findMaxAverage(new int[]{1,12,-5,-6,50,3},4);
        }
    public static double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        long max = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }

        return max / 1.0 / k;
    }
}