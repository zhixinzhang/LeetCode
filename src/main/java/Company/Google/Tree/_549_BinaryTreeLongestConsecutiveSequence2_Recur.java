package Company.Google.Tree;

/**
 * Created by zhang on 2018/6/24.
 */
public class _549_BinaryTreeLongestConsecutiveSequence2_Recur {
    int res;
    public int longestConsecutive(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    public int[] helper(TreeNode root){
        int[] cur = new int[2];
        if(root == null) return cur;
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        // 1 2 3   5   6 7 8

        if(root.left != null){
            if(root.left.val != root.val - 1) left[0] = 0;
            if(root.left.val != root.val + 1) left[1] = 0;
        }
        if(root.right != null){
            if(root.right.val != root.val - 1) right[0] = 0;
            if(root.right.val != root.val + 1) right[1] = 0;
        }

        cur[0] = Math.max(left[0], right[0]) + 1;
        cur[1] = Math.max(left[1], right[1]) + 1;

        res = Math.max(res, cur[0] + cur[1] - 1);
        return cur;
    }
}
