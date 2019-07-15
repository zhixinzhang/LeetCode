package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/30/19
 * Time: 9:13 PM
 * Description:
 */


public class _872_LeafSimilarTrees_DFS {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return dfs(root1).equals( dfs(root2));
    }
    public String dfs(TreeNode root){
        if (root == null) return "";
        if(root.left == null && root.right == null) return root.val + "-";
        return dfs(root.left) + dfs(root.right);
    }
}
