package Algo_Summary;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/21/19
 * Time: 4:53 PM
 * Description:
 */


public class Recursion_Tree_Template {
    //  based on 1026. Maximum Difference Between Node and Ancestor
    //  回溯法， 带着值 从上到下
    int ans;
    public int maxAncestorDiff(TreeNode root) {
        ans = recursion(root, root.val, root.val);
        return ans;
    }
    public int recursion(TreeNode root, int max, int min){
        if(root == null)
            return max - min;
        max  = Math.max(max, root.val);
        min = Math.min(min, root.val);
        int left = recursion(root.left, max, min);
        int right = recursion(root.right, max, min);
        return Math.max(left, right);
    }
}
