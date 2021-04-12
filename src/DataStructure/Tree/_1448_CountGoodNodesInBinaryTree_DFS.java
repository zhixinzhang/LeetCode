package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

/**
 * @author Luke(New Man) Zhang
 * @Date 4/10/2021 1:39 AM
 * <p>
 * Description:
 * Similar task :
 * Key Point:
 */

public class _1448_CountGoodNodesInBinaryTree_DFS {
    int good = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return good;
    }

    private void dfs (TreeNode root, int max){
        if (root == null) return;
        if (root.val >= max) good++;
        max = Math.max(max, root.val);
        dfs(root.left, max);
        dfs(root.right, max);
    }
}
