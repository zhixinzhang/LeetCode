package Company.uber.Tree;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created by zhang on 2018/9/17.va
 *
 *
 * https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
 */
public class _98_ValidateBinarySearchTree_Recur {
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(11);
       boolean a = isValidBST(root);
       int c = 0;
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return recur(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    /**                 10
     *              3
     *           2    11
     *         1
     *         key point is remember grandfather value
     *
     * **/

    public static boolean recur(TreeNode root, int max, int min){
        if (root == null)   return true;
        // compare left
        if (root.val >= max || root.val <= min)
            return false;
        return recur(root.left,root.val,min) && recur(root.right,max,root.val);
    }
}
