package DataStructure.Tree;

import Company.Google.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 6/2/19
 * Time: 4:47 PM
 * Description:
 */


public class _104_MaximumDepthofBinaryTree_Recursion {
    int ans = 0;
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        recur(root, 1);
        return ans;
    }
    public void recur(TreeNode root, int idx){
        if(root == null){
            ans = Math.max(idx - 1, ans);
            return;
        }
        recur(root.left, idx + 1);
        recur(root.right, idx + 1);
    }


    //   更简洁
    public int maxDepth_recur(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth_recur(root.left) , maxDepth_recur(root.right)) + 1;
    }
}
