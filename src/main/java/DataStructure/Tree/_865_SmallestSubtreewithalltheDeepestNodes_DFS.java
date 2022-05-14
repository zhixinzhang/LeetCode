package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-18 16:23
 *
 * Description:
 *
 * Key Point:
 * Note: This question is the same as 1123: https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 */


public class _865_SmallestSubtreewithalltheDeepestNodes_DFS {

    /**
     * Solution 1 : same with Solution 2
     *
     * */
    TreeNode lca;
    int maxDepth;
    public TreeNode subtreeWithAllDeepest_Recursion(TreeNode root) {
        dfs(root, 0);
        return lca;
    }

    private int dfs (TreeNode root, int depth){
        if (root == null) {
            maxDepth = Math.max(depth - 1, maxDepth);
            return depth - 1;
        }

        int left = dfs(root.left, depth + 1);
        int right = dfs(root.right, depth + 1);

        if (left == right && left >= maxDepth) {
            lca = root;
        }

        return Math.max(left, right);
    }



    class  Depth{
        int depth;
        TreeNode node;
        Depth(int depth, TreeNode node){
            this.depth = depth;
            this.node = node;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return recur(root).node;
    }
    public Depth recur(TreeNode root){
        if(root == null)
            return new Depth(0, root);
        Depth l = recur(root.left);
        Depth r = recur(root.right);
        if(l.depth == r.depth)
            return new Depth(l.depth+1, root);
        return l.depth > r.depth ? new Depth(l.depth+1, l.node): new Depth(r.depth+1, r.node);
    }
}
