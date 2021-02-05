package DataStructure.BinaryTree;

/**
 * @author Luke(New Man) Zhang
 * @Date 2/3/2021 12:08 AM
 * <p>
 * Description:
 * Key Point:
 */

public class _112_PathSum_DFS {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return sum == root.val;
        }
        boolean res = hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        return res;
    }

    // another
    int target = 0;
    public boolean hasPathSum_(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int targetSum){
        if (root == null) {
            return false;
        }

        target += root.val;
        if (target == targetSum && root.left == null && root.right == null) {
            return true;
        }

        boolean l = dfs(root.left, targetSum);
        boolean r = dfs(root.right, targetSum);
        target -= root.val;

        return l || r;

    }
}
