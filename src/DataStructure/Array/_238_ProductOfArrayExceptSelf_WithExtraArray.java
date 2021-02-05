package DataStructure.Array;


/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description: https://leetcode.com/problems/product-of-array-except-self/solution/
 * Key Point:
 *
 * Initialize two empty arrays, L and R where for a given index i, L[i] would contain the product of all the numbers to the left of i and R[i] would contain the product of all the numbers to the right of i.
 * We would need two different loops to fill in values for the two arrays. For the array L, L[0]L[0] would be 1 since there are no elements to the left of the first element. For the rest of the elements, we simply use L[i] = L[i - 1] * nums[i - 1]L[i]=L[i−1]∗nums[i−1]. Remember that L[i] represents product of all the elements to the left of element at index i.
 * For the other array, we do the same thing but in reverse i.e. we start with the initial value of 1 in R[length - 1]R[length−1] where lengthlength is the number of elements in the array, and keep updating R[i] in reverse. Essentially, R[i] = R[i + 1] * nums[i + 1]R[i]=R[i+1]∗nums[i+1]. Remember that R[i] represents product of all the elements to the right of element at index i.
 * Once we have the two arrays set up properly, we simply iterate over the input array one element at a time, and for each element at index i, we find the product except self as L[i] * R[i]L[i]∗R[i].
 */

// 不能用 two pointer 可能存在 [1,1,0,1,1,1]
public class _238_ProductOfArrayExceptSelf_WithExtraArray {
    // Solution 1 : use two extra array
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int len = nums.length;
        int[] leftProduct = new int[len];
        leftProduct[0] = 1;
        int[] rightProduct = new int[len];
        rightProduct[len - 1] = 1;
        int[] ans = new int[len];

        for (int i = 1, j = len - 2; i < len && j >= 0; i++, j--){
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
            rightProduct[j] = rightProduct[j + 1] * nums[j + 1];
        }

        for (int i = 0; i < len; i++){
            ans[i] = leftProduct[i] * rightProduct[i];
        }

        return ans;
    }


    // solution 2 : time complexity is O (1) better
    public int[] productExceptSelf_Space1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        for (int i = 1; i < len; i++){
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int r = 1;
        for (int i = len - 1; i >= 0; i-- ){
            ans[i] = ans[i] * r;
            r *= nums[i];
        }

        return ans;
    }
}
