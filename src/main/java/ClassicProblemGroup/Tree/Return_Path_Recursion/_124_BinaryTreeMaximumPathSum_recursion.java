package ClassicProblemGroup.Tree.Return_Path_Recursion;
/**
 * Created by zhang on 2018/1/26.
 * Given a binary tree, find the maximum path sum.
 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 For example:
 Given the below binary tree,
 1
 / \
 2   3
 Return 6.
 *
post order from bottom node to count max result
 // O(n), O(n)
 * 如果只是一个节点,那么当然就是这个节点的值了.
 如果这个作为root,那么最长路应该就是..
 F(left) + F(right) + val...当然如果left,或者right<0就不用加了的= =
 从下往上递归遍历...
 如果不这个不是root,那么就不能把left和right加起来了...因为只是一条路...
 * */
//返回一条path的最大值
//Given a binary tree, find the maximum path sum.
//The path must contain at least one node and does not need to go through the root.


import Company.google.TreeNode;

/**We can find the maximum sum using single traversal of binary tree. The idea is to maintain two values in recursive calls
  1) Maximum root to leaf path sum for the subtree rooted under current node.
  2) The maximum path sum between leaves (desired output).

  For every visited node X, we find the maximum root to leaf sum in left and right subtrees of X. We add the two values with X->data, and compare the sum with maximum path sum found so far.

  Following is the implementation of the above O(n) solution.
  * */
public class _124_BinaryTreeMaximumPathSum_recursion {
        int res;
        public int maxPathSum(TreeNode root) {
            if (root == null) return root.val;
            res = Integer.MIN_VALUE;            //mean the max value of path
            postOrder(root);
            return res;
        }
        private int postOrder(TreeNode root){
            // return case
            if (root == null)
                return 0;
            int left = Math.max(0,postOrder(root.left));
            int right = Math.max(0,postOrder(root.right));
            int curVal = root.val;
            // two variable
            res = Math.max(res,right + left + curVal);
            return Math.max(left,right) + curVal;
        }
    }
