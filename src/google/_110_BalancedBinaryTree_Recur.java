package google;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created by zhang on 2017/12/5.
 */
public class _110_BalancedBinaryTree_Recur {
    public boolean isBalanced(TreeNode root) {
        if (judgeDepth(root) == -1){
            return true;
        }else{
            return false;
        }
    }
    public int judgeDepth(TreeNode root){
        if (root == null)
            return 0;
        int leftDep = 0;
        int rightDep = 0;
//        int leftDep = judgeDepth(root.left);
//        int rightDep = judgeDepth(root.right);
        // judge depth
        if (leftDep == -1 || rightDep == -1 || Math.abs(leftDep - rightDep) > 1) {
            return -1;
        }
        else {
            return 1 + Math.max(leftDep, rightDep);
        }
    }
}
