package Company.Ebay;

import Company.Google.TreeNode;

/**
 * Here, we will be using Array for better optimization. We will create a array 
 * of given maxSize and we will keep 
 * a Ptr to update our values in array. Based on two conditon of k 
 * we will update the values in array.
 * 
*/
public class _310_MinimumHeightTrees_sortedArray {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}