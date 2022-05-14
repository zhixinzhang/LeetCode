package Company.ForUsAll;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/5/19
 * Time: 7:04 PM
 * Description:
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=451024&highlight=forusall
 */


public class Loadbalance {
    public static void main(String[] args){
        lb(new int[]{3,1,7,5,15,16,4,6,3,7,0});
    }
    public static boolean lb(int[] nums){
        if (nums == null || nums.length <= 3)
            return false;
        int l = 0, r = nums.length - 1;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i <= r; i++)
            sum[i] = sum[i-1] + nums[i];
        int lsum = nums[0], rsum = nums[r], msum = sum[r] - lsum - rsum;
        while (l + 2 < r){
            if (lsum < rsum){
                l++;
                lsum += nums[l];
            }else if (lsum > rsum){
                r--;
                rsum += nums[r];
            }
            if (lsum == rsum)
                if (find(l,r,nums,sum))
                    return true;
        }
        return false;
    }
    public static boolean find(int l, int r, int[] nums, int[] sum){
        int val = sum[l];
        int a = sum[r-1] - sum[l+2];
        int b = sum[r-2] - sum[l+1];
        int c = sum[r-3] - sum[l];
        if (a == val || b == val || c == val)
            return true;
        return false;
    }
}
