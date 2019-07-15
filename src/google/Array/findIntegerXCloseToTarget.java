package google.Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by zhang on 2018/6/17.
 */
public class findIntegerXCloseToTarget {
    public static int solution(int[] nums, int target){
        int res = 0;
        if (target == 0) return 0;
        Arrays.sort(nums);
        HashMap<Integer, Integer> hm = new HashMap<>();
        //1 3 5 7 8 9
        int[] sumBucket = new int[nums.length];
        int maxVal = nums[nums.length-1];
        //1 4 9 16 24 33
        for (int i = 0; i<sumBucket.length; i++){
            if (hm.containsKey(nums[i]))
                continue;
            else
                hm.put(nums[i],i);
            if (i == 0)
                sumBucket[0] = nums[0];
            else
                sumBucket[i] = sumBucket[i-1] + nums[i];
        }
        if (sumBucket[sumBucket.length - 1] <= target)
            return maxVal;

        int maxSum = sumBucket[sumBucket.length - 1];
        int minSum = -1;
        // binary search
        int left = 0;
        int right = maxVal - 1; // 8
        while (left < right){
            int mid = left + (right - left) / 2;
            int j = 0;
            for (; j<nums.length; j++){
                if (nums[j] >= mid){
                    break;
                }
            }
            int sum = sumBucket[j-1] + mid * (sumBucket.length -j);
            if (sum == target)
                return mid;
            if (sum < target){
                minSum = sum > minSum ? sum : minSum;
                left = mid+1;
            }else {
                maxSum = sum;
                right = mid;
            }
        }
        return res;

//        for (int i = maxVal - 1; i>= 0 ; i--){
//            int j = 0;
//            for (; j < nums.length; j++){
//                if (nums[j] >= i)
//                    break;
//            }
//            int sum = sumBucket[j-1] + i*(sumBucket.length -j);
//            if (sum == target) return i;
//            if (sum < target){
//                res = target - sum < maxSum - target ? i : i+1;
//                return res;
//            }else {
//                maxSum = sum;
//            }
//        }
//        return res;
    }
    public static void main(String[] args){
        solution(new int[]{1,3,5,7,8,9}, 22);
    }
}
