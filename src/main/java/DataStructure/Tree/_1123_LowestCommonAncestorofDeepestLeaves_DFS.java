package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-18 16:23
 * <p>
 * Description: https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 *
 * Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.
 *
 * Recall that:
 *
 * The node of a binary tree is a leaf if and only if it has no children
 * The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
 * The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is in the subtree with root A.
 * Note: This question is the same as 865: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 * Key Point:
 */

public class _1123_LowestCommonAncestorofDeepestLeaves_DFS {

    TreeNode ans = null;
    int deepest = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return ans;
        }

        dfs(root, deepest);

        return ans;
    }

    private int dfs (TreeNode root, int depth){
        if (root == null) {
            return depth;
        }

        if (root.left == null && root.right == null) {
            // we found out leaf node
            if (depth + 1 > deepest) {
                deepest = depth + 1;
                ans = root;
            }
        }

        int leftDepth = dfs(root.left, depth + 1);
        int rightDepth = dfs(root.right, depth + 1);

        if (leftDepth == rightDepth && leftDepth >= deepest) {
            ans = root;
        }

        return Math.max(leftDepth, rightDepth);
    }
}
