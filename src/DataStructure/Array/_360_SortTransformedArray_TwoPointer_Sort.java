package DataStructure.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/20/19
 * Time: 1:32 PM
 * Description:
 */


public class _360_SortTransformedArray_TwoPointer_Sort {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int len = nums.length;
        int[] sorted = new int[len];
        int index = a >= 0 ? len - 1 : 0;
        int i = 0, j = len - 1;
        int ri = cal(nums[i], a, b, c);
        int rj = cal(nums[j], a, b, c);
        while (i <= j) {
            if (a >= 0) {
                if (ri > rj) {
                    sorted[index--] = ri;
                    i++;
                    if (i <= j)
                        ri = cal(nums[i], a, b, c);
                } else {
                    sorted[index--] = rj;
                    j--;
                    if (i <= j)
                        rj = cal(nums[j], a, b, c);
                }
            } else {
                if (ri < rj) {
                    sorted[index++] = ri;
                    i++;
                    if (i <= j)
                        ri = cal(nums[i], a, b, c);
                } else {
                    sorted[index++] = rj;
                    j--;
                    if (i <= j)
                        rj = cal(nums[j], a, b, c);
                }
            }
        }

        return sorted;
    }

    public int cal(int x, int a, int b, int c) {
        return (a * x * x + b * x + c);
    }
}
