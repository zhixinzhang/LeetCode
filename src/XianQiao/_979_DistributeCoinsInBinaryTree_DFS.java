package XianQiao;

import DataStructure.BinaryTree.TreeNode;

/**
 * @Author: Xianqiao
 * @Date: 7/10/20 00:19
 */
public class _979_DistributeCoinsInBinaryTree_DFS {
    /** My Solution */
    int move = 0;
    int addon = 0;
    public int distributeCoinsMyanswer(TreeNode root) {
        return helper(root);
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return move;
        }
        helper(root.left);
        root.val += addon;
        addon = 0;
        helper(root.right);
        root.val += addon;
        addon = 0;
        if (root.val != 1) {
            addon += root.val - 1;
            move += Math.abs(addon);
        }
        return move;
    }

    /** Answer */
    int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        ans += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }
}
