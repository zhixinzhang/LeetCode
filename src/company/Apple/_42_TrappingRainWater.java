package company.Apple;
/**
 * Created by zhang on 2018/2/12.
 * Given n non-negative integers representing an elevation map where
 * the width of each bar is 1, compute how much water it is able to trap after raining.
 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
//https://segmentfault.com/a/1190000004594606
// 用两个pointer  分别从左和右开始  向中间集合
/**先找到左右两边的第一个峰值作为参照位，然后分别向后（向前）每一步增加该位与参照位在这一位的差值，加入sum，直到下一个峰值，再更新为新的参照位。这里有一个需要注意的地方，
 * 为什么要先计算左右两个峰值中较小的那个呢？因为在两个指针逼近中间组成最后一个积水区间时，要用较短边计算
 * */
//还可以用stack O(n) O(n)
public class _42_TrappingRainWater {
    public static int trap(int[] height) {
        int res = 0;
        if (height.length < 3)
            return res;
        int[] A = height;
        if (A.length < 3) return 0;
        int ans = 0;
        int l = 0, r = A.length - 1;
        // find the left and right edge which can hold water
        while (l < r && A[l] <= A[l + 1]) l++;
        while (l < r && A[r] <= A[r - 1]) r--;
        while (l < r) {
            int left = A[l];
            int right = A[r];
            if (left <= right) {
                // add volum until an edge larger than the left edge
                while (l < r && left >= A[++l]) {
                    ans += left - A[l];
                }
            } else {
                // add volum until an edge larger than the right volum
                while (l < r && A[--r] <= right) {
                    ans += right - A[r];
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
