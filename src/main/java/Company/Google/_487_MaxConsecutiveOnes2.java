package Company.Google;

/**
 * Created by zhang on 2018/5/30.
 * 从左到右面扫描 如果遇到一个0假设他是1 然后继续扫描 记住这个0的位置
 * 如果又遇见一个0 计算最大的连续1长度 和之前0到现在的长度
 * 继续又扫
 * follow up 如果是允许你改变k个0的话
 * 就用sliding window 算法 O（n）时间 O(1)空间
 * https://leetcode.com/problems/max-consecutive-ones-ii/discuss/96920/Java-clean-solution-easily-extensible-to-flipping-k-zero-and-follow-up-handled
 */
//2974059788
public class _487_MaxConsecutiveOnes2 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int max = 0;
        // 1 0 1 1 1 0 0
        int startIndex = 0;
        for(int i = 0; i<nums.length; ){
            while(i < nums.length && nums[i] == 1){
                res++;
                i++;
            }
            if(i < nums.length){
                startIndex = i+1;
                res++;
                i++;
            }
            while(i < nums.length && nums[i] == 1){
                res++;
                i++;
            }
            max = Math.max(res,max);
            res = i - startIndex;
        }
        return max;
    }
    public static void main(String[] args){
        findMaxConsecutiveOnes(new int[]{1});
    }

    public static int fidnMax_followUp_K(int[] nums){
        int max = 0, zero = 0, k = 1; // flip at most k zero
        //[1....n] k element
        for (int l = 0, h = 0; h<nums.length; h++){
            if (nums[h] == 0){
                zero++;
            }
            while (zero > k){
                if (nums[l++] == 0)
                    zero--;
            }
            max = Math.max(h-l+1,max);
        }
        return max;
    }
}
