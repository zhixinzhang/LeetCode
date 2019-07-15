package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/12/19
 * Time: 2:24 PM
 * Description:
 */


public class _938_RangeSumofBST_DFS_Stack {
    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L , R);
        return ans;
    }
    public void dfs(TreeNode root, int L, int R){
        if(root != null){
            if(L <= root.val && root.val <= R)
                ans += root.val;
            if(L < root.val)
                dfs(root.left, L, R);
            if(R > root.val)
                dfs(root.right, L, R);
        }
    }

    public int rangeSumBST_Stack(TreeNode root, int L, int R) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node == null) continue;
            if(L <= node.val && node.val <= R)
                ans += node.val;
            if(L < node.val)
                stack.push(node.left);
            if(node.val < R)
                stack.push(node.right);
        }
        return ans;
    }
}
