package company.Amazon.Tree;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/4/19
 * Time: 7:11 PM
 * Description:
 *
 * https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
 */


public class _99_RecoverBinarySearchTree_Inorder {
    TreeNode preNode = null;
    TreeNode firstNode = null;
    TreeNode secondNode = null;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        traverse(root);
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }
    private void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        if (preNode != null) {
            if (firstNode == null && preNode.val >= root.val)
                firstNode = preNode;
            if (firstNode != null && preNode.val >= root.val)
                secondNode = root;
        }
        preNode = root;
        traverse(root.right);
    }
}
