package DataStructure.Array;

/**
 * Created by zhang on 2018/5/7.
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 3 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 */
// for loop the arry from left to right
// use curSum mean from [left to right] value
// if curSum > max we update index start and end
// point we have negative so we should update the left point
public class _53_MaximumSubarray_followUp {
    public static int[] maxSub(int[] nums){
        int[] res = new int[2];
        int max = Integer.MIN_VALUE, left = 0;
        int curSum = nums[0];
        for (int right = 0; right <= nums.length-1; right++){
            if (curSum <= 0)
                left = right;
            curSum = Math.max(curSum,0) + nums[right];
            if (curSum > max){
                max = curSum;
                res[0] = left;
                res[1] = right;
            }
        }
        return res;
    }
    public static void main(String[] args){
//        maxSub(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        maxSub(new int[]{-2,-1,-1,-5});
    }
}
