package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/1/19
 * Time: 3:48 PM
 * Description:
 */


public class _814_BinaryTreePruning_recur {
    public TreeNode pruneTree_moreeffec(TreeNode root) {
        if(root==null) return null;
        if( pruneTree(root.left)==null) root.left=null;
        if( pruneTree(root.right)==null) root.right=null;
        return (root.right==null && root.left==null && root.val==0) ? null : root;
    }


    public TreeNode pruneTree(TreeNode root) {
        recursion(root);
        return root;
    }
    private boolean recursion(TreeNode root){
        if (root == null) return false;
        boolean l = recursion(root.left);
        boolean r = recursion(root.right);
        if (l)
            root.left = null;
        if (r)
            root.right = null;
        if (root.val == 1)
            return true;
        else
            return (l || r);
    }

    public TreeNode pruneTree_antoher(TreeNode root) {
        pruneTreeHelper(root);
        return root;
    }

    int pruneTreeHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lSum = pruneTreeHelper(node.left);
        int rSum = pruneTreeHelper(node.right);

        if (lSum == 0) node.left = null;
        if (rSum == 0) node.right = null;

        return lSum + rSum + node.val;
    }

}
