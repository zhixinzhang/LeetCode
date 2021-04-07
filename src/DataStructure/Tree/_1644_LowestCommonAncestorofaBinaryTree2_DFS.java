package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

/**
 * @author Luke(New Man) Zhang
 * @Date 4/7/2021 1:24 AM
 * <p>
 * Description:
 * Similar task :
 * Key Point:  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/discuss/933835/Java.-Difference-from-236-is-you-need-to-search-the-entire-tree.
 */

public class _1644_LowestCommonAncestorofaBinaryTree2_DFS {

    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }


    private boolean[] dfs (TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return new boolean[] {false, false};

        boolean hasP = false;
        boolean hasQ = false;

        if (root.val == p.val) hasP = true;
        if (root.val == q.val) hasQ = true;

        boolean[] resLeft = dfs(root.left, p, q);
        boolean[] resRigth = dfs(root.right, p, q);

        hasP = (hasP || resLeft[0]) || resRigth[0];
        hasQ = (hasQ || resLeft[1]) || resRigth[1];

        if (hasP && hasQ && res == null) {
            res = root;
        }

        return new boolean[] { hasP, hasQ };
    }
}
