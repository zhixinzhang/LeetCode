package company.Amazon_Google;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/10/19
 * Time: 2:26 PM
 * Description:
 *
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/solution/
 */


public class _979_DistributeCoinsinBinaryTree_recur {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node){
        if(node == null)    return 0;
        int l = dfs(node.left);
        int r = dfs(node.right);

        ans += Math.abs(l) + Math.abs(r);
        return node.val + l + r -1;
    }
}
