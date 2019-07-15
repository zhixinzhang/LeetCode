package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/12/19
 * Time: 3:34 PM
 * Description:
 */


public class _1022_SumofRootToLeafBinaryNumbers_DFS {
    List<Integer> dq = new ArrayList<>();
    int ans;
    public int sumRootToLeaf(TreeNode root) {
        ans = 0;
        if(root == null) return ans;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if(root == null)
            return;
        dq.add(root.val);
        if(root.left == null && root.right == null){
            ans += calculate();
            dq.remove(dq.size()-1);
        }

        if(root.left != null){
            dfs(root.left);
        }
        if(root.right != null){
            dfs(root.right);
        }
    }
    public int calculate(){
        int res = 0;
        for(int i = dq.size(); i >=0 ;i--){
            if (dq.get(i) != 0)
                res += Math.pow(2, i);
        }
        return ans += res;
    }
}
