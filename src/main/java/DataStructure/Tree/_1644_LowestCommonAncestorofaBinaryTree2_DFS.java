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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        lowestCommonAncestor_1st(root, new TreeNode(5), new TreeNode(1));
    }

    static boolean leftNode, rightNode;
    public static TreeNode lowestCommonAncestor_1st(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = find(root, p, q);
        if (!leftNode || !rightNode)
            return null;
        return ans;
    }

    public static TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);

        if (root.val == p.val) {
            leftNode = true;
            return root;
        }
        if (root.val == q.val) {
            rightNode = true;
            return root;
        }

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

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
