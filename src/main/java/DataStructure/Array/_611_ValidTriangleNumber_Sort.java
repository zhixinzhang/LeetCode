package DataStructure.Array;
import java.util.*;

//greedy
//找出满足组成三角形的三条边的个数

//组成三角形条件是两条较短的边的和大于第三条边
//https://www.youtube.com/watch?v=bojX9bdra-w
public class _611_ValidTriangleNumber_Sort{
    public int triangleNumber(int[] nums) {

        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    cnt += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return cnt;
    }
}