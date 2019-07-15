package google.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/29/19
 * Time: 7:08 PM
 * Description:
 *
 * 假设给你一个有序数组，，那么如果二分搜索其中的每个数，必定都能找到。
 * 如果给你同样的数组，但是却是打乱的，然后使用同样的二分搜索来搜索其中的每个数，会有些数找不到。
 * 请你用 O(N)，返回哪些数找不到。
 */


public class missingNumber_unorder_BS {
    static List<Integer> ans = new ArrayList<>();
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args){
        find(new int[]{2, 7, 4, 6, 10, 1, 3, 8, 12, 11});
        //             0  1  2  3  4   5  6  7   8   9
    }
    public static void find(int[] nums){
        if (nums == null || nums.length <= 1)   return;
        int l = 0, r = nums.length-1, mid = 0;
//        for (int i : nums) set.add(i);
        mid = l + (r - l) / 2;
        set.add(nums[mid]);
        recur(mid,l,mid-1,nums);
        recur(mid,mid+1,r,nums);
        ans = new ArrayList<>(set);
    }

    public static void recur(int preMid, int l, int r, int[] nums){
        int preVal = nums[preMid];
        int mid = l + (r - l) / 2;
        if (l > preMid){
            if (preVal < nums[mid])
                set.add(nums[mid]);
        }
        if (l < preMid){
            if (preVal > nums[mid])
                set.add(nums[mid]);
        }
        recur(Math.max(preVal, nums[mid]),l,mid-1,nums);
        recur(Math.max(preVal, nums[mid]),mid+1,r,nums);
    }
}
