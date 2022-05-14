package Company.Houzz;
/**
 * Created by zhang on 2018/1/19.
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 */
//O(nlogn). n is looping through give array. logn is binary search
//DataStructure.DP O(n^2)
//binary nlogn
//10, 9, 2, 5, 3, 7, 101, 18
// 1.find the mid point (0,nums.length)
/**1. If A[i] is smallest among all end
 candidates of active lists, we will start
 new active list of length 1.
 2. If A[i] is largest among all end candidates of
 active lists, we will clone the largest active
 list, and extend it by A[i].

 3. If A[i] is in between, we will find a list with
 largest end element that is smaller than A[i].
 Clone and extend this list by A[i]. We will discard all
 other lists of same length as that of this modified list.
 * */
public class _300_LongestIncreasingSubsequence_DP_BinarySearch {
    public int lengthOfLIS(int[] nums) {
        int[] increaseArr = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {                // binary search
                int mid = (i + j) / 2;
                if (increaseArr[mid] < x)
                    i = mid + 1;
                else
                    j = mid;
            }
            increaseArr[i] = x;
            if (i == size) ++size;
        }
        return size;
    }






        // 10, 9, 2, 5, 3, 7, 101, 18
    //dp[i]  represent fromx nums[0] to nums[i] longest substring
    //10, 9, 2    dp[2] = 1  longest substring 2
        public int lengthOfLIS_DP(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            int maxRes = 0;
            int[] dp = new int[nums.length];
            //dp[i]  represent fron nums[0] to nums[i] longest substring
            //10, 9, 2    dp[2] = 1  longest substring 2
            for (int i = 0;i <nums.length;i++){
                dp[i] = 1;
                for (int j = 0;j<i;j++){
                    if (nums[i]>nums[j] && dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1;
                    }
                }
                maxRes = Math.max(maxRes,dp[i]);
            }
            return maxRes;
        }
    }
