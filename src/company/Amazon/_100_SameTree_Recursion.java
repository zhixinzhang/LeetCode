package company.Amazon;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/21/19
 * Time: 4:01 PM
 * Description:
 */


public class _100_SameTree_Recursion {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null && q != null || p != null && q==null) return false;
        if(p.val !=  q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
