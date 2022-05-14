package google;

/**
 * Created by zhang on 2018/5/16.
 */
public class _783_MinimumDistanceBetweenBSTNodes_Inorder {
    int prev;
    int res;
    public int minDiffInBST(TreeNode root) {
        res = Integer.MAX_VALUE;
        prev = -1;
         inorder(root);
         return res;
    }
    private void inorder(TreeNode root){
        if (root == null)
            return;
        inorder(root.left);
        if (prev != -1){
            res = Math.min(res,root.val - prev);
        }
        prev = root.val;
        inorder(root.right);
    }
}
