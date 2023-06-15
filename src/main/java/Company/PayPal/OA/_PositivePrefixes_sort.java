package Company.PayPal.OA;

import java.util.Arrays;

/*
先降序排序，用sum记录前缀和，如果前缀和>0那么res+1， 如果<= 0就可以不用再往后遍历了。
注意sum要用long型，否则过不了hidden test
https://www.1point3acres.com/bbs/thread-939146-1-1.html
**/
public class _PositivePrefixes_sort {
    public static void main(String[] args) {
       int a = maxScore(new int[]{-1, -2, -3, 4, 5, 6, -100});
       System.out.println(a);
    }


    public static int maxScore(int[] nums) {
        long sum = 0;
        int i=nums.length-1;
        Arrays.sort(nums);
        if(nums[nums.length-1] == 0)    
            return 0;
        while(i >= 0){
            sum += nums[i--];
            if(sum <= 0) 
                return nums.length-i-2;
        }

        return nums.length;
    }
}
