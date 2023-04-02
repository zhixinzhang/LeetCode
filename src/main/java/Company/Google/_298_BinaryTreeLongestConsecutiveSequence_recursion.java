package Company.Google;

/**
 * Created by zhang on 2018/5/23.
 */
public class _298_BinaryTreeLongestConsecutiveSequence_recursion {
    int res;
    public int longestConsecutive(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    public int helper(TreeNode root){
        int cur = 0;
        if(root == null) return cur;
        int left = helper(root.left);
        int right = helper(root.right);
        if(root.left != null && root.left.val != root.val + 1) left = 0;
        if(root.right != null && root.right.val != root.val + 1) right = 0;
        cur = Math.max(left, right) + 1;
        res = Math.max(cur, res);
        return cur;
    }
}
