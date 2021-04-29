package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.Stack;

/**
 * @author Luke Zhang
 * @Date 2021-04-27 16:32
 */
public class _99_RecoverBinarySearchTree_Iterative_Recursion_Morrios {
    // recursion

    TreeNode preNode = null;
    TreeNode firstNode = null;
    TreeNode secondNode = null;

    public void recoverTree_Recursion(TreeNode root) {
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

    // Iterative
    public void recoverTree(TreeNode root) {
        TreeNode low = null, high = null, pred = null;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null && root.val < pred.val){
                high = root;
                if (low == null) {
                    low = pred;
                } else {
                    break;
                }
            }

            pred = root;
            root = root.right;
        }

        int temp = low.val;
        low.val = high.val;
        high.val = temp;
    }
}
