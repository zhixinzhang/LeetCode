package DataStructure.BinaryTree;

public class _654_MaximumBinaryTree_recursion{
	  public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    //max_index denotes the index of the maximum number in range [left, right]
    public TreeNode helper(int[] nums, int left, int right){
        if(left>right)return null;
        
        int max_index = left;
        for(int i = left; i <= right; i++){
            if(nums[i] > nums[max_index])max_index = i; 
        }
        
        TreeNode root = new TreeNode(nums[max_index]);
        root.left = helper(nums, left, max_index - 1);
        root.right = helper(nums, max_index + 1, right);
        return root;
    }
}