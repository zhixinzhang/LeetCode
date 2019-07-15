package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/9/19
 * Time: 5:35 PM
 * Description:
 */


public class _951_FlipEquivalentBinaryTrees_BFS_Recur {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == root2)
            return true;
        if(root1 == null || root2 == null || root1.val != root2.val)
            return false;

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }


    public boolean flipEquiv_DFS(TreeNode root1, TreeNode root2) {
        List<Integer> vals1 = new ArrayList<>();
        List<Integer> vals2 = new ArrayList<>();
        dfs(root1, vals1);
        dfs(root2, vals2);
        return vals1.equals(vals2);
    }

    public void dfs(TreeNode node, List<Integer> vals) {
        if (node != null) {
            vals.add(node.val);
            int L = node.left != null ? node.left.val : -1;
            int R = node.right != null ? node.right.val : -1;

            if (L < R) {
                dfs(node.left, vals);
                dfs(node.right, vals);
            } else {
                dfs(node.right, vals);
                dfs(node.left, vals);
            }

            vals.add(null);
        }
    }
}
