package DataStructure.BinaryTree;

/**
 * Created by zhang on 2017/10/13.
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22
 */
/*
* 典型的二叉树递归
* */
public class _112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return sum == root.val;
        }
        boolean res = hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        return res;
    }
}
