package company.FaceBook;

import google.TreeNode;

/**
 * @author Luke Zhang
 * @Date 2019-10-28 23:44
 */
public class _1123_LowestCommonAncestorofDeepestLeaves_DFS {
    TreeNode res = null;
    int maxDepth = 0;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        return res;
    }

    public int helper(TreeNode node, int depth) {
        if (node == null) return depth;

        if (node.left == null && node.right == null) {
            if (depth+1 > maxDepth) {
                maxDepth = depth+1;
                res = node;
            }
            return depth+1;
        }
        int lDepth = helper(node.left, depth+1);
        int rDepth = helper(node.right, depth+1);
        if (lDepth == rDepth && lDepth >= maxDepth) res = node;

        return Math.max(lDepth, rDepth);
    }
}
