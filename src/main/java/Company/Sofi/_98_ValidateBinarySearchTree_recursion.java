package Company.Sofi;

import DataStructure.BinaryTree.TreeNode;

// 判断是不是 有效的搜索二叉树  用递归
// 重点 是左右孩子 小于 或者大于父母 并且是所有的父母 
public class _98_ValidateBinarySearchTree_recursion{

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