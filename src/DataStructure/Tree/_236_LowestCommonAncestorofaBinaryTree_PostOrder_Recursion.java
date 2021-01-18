package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/
 * Key Point:
 *
 *  //O(n) recursion postOrder  tree travel from botton to up
 *  // 1. from top go down find p or q in tree
 *  // 2. if current node equal p or q its mean i found node p and q and keep go up  if not p or q and its leaf node
 *  // we return null
 *  // 3. if
 */

public class _236_LowestCommonAncestorofaBinaryTree_PostOrder_Recursion {

    public TreeNode lowestCommonAncestor_PostOrder(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        return left == null ? right : left;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        if(left != null && right != null)
            return root;
        return null;
    }
}
