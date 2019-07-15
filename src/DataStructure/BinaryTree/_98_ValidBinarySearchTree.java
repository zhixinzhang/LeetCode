package DataStructure.BinaryTree;

/**
 * Created by zhang on 2017/10/7.
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 */
/** i have two solutions
 * 1. deque to traversal each level node
 * 2. use recursion. split BST to a smaller BST  我选择的第二种
 * */
public class _98_ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isValidBST(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }
    private boolean isValidBST(TreeNode root, long max, long min) {
        if (root == null){
            return true;
        }

        // check current level root.val
        if (root.val >= max || root.val <= min){
            return false;
        }
        //recurse down
        return isValidBST(root.left,root.val,min) && isValidBST(root.right,max,root.val);
    }
}
