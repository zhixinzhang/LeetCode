package google.Tree;

/**
 * Created by zhang on 2018/8/1.
 */
public class _124_BinaryTreeMaximumPathSum_recur {
    static int res = Integer.MIN_VALUE;
    public static void main(String[] args){


    }
    public static int solu(TreeNode root){
        if (root == null)
            return 0;
        recur(root);
        return res;
    }
    public static int recur(TreeNode root){
        if(root == null)
            return 0;
        int leftMax = recur(root.left);
        int rightMax = recur(root.right);
        int cur = root.val;

        if (leftMax >= 0)
            cur += leftMax;
        if (rightMax >= 0)
            cur += rightMax;
        res = Math.max(cur,res);
        return Math.max(root.val, Math.max(root.val + leftMax, root.val + rightMax));

    }
}
