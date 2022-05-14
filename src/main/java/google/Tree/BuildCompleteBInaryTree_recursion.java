package google.Tree;



/**
 * Created by zhang on 2018/6/13.
 */
public class BuildCompleteBInaryTree_recursion {

    public static void main(String[] args){
        buildCompleteTree(new int[]{1,2,3,4,5,6,7,8});
    }

    static TreeNode root;
    public static void buildCompleteTree(int[] nums){
        root = helper(nums, root, 0);
    }
    public static TreeNode helper(int[] nums, TreeNode root, int i){
        if (i < nums.length){
            TreeNode curNode = new TreeNode(nums[i]);
            root = curNode;
            root.left = helper(nums, root, i*2+1);
            root.right = helper(nums, root, i*2 +2);
        }
        return root;
    }
}
