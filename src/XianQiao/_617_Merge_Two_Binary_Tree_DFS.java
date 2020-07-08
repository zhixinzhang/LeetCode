package XianQiao;

import DataStructure.BinaryTree.TreeNode;

/**
 * @Author: Xianqiao
 * @Date: 7/7/20 22:53
 */
public class _617_Merge_Two_Binary_Tree_DFS {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return helper(t1, t2);
    }
    private TreeNode helper(TreeNode t1, TreeNode t2) {
        //break condition: two treenodes are both empty
        if (t1 == null && t2 == null) return null;

        //operation
        if (t2 != null) {
            if (t1 == null) {
                t1 = t2;
                return t1;
            }
            t1.val += t2.val;
        } else if (t2 == null) {
            return t1;
        }

        //recursion
        t1.left = helper(t1.left, t2.left);
        t1.right = helper(t1.right, t2.right);
        return t1;
    }
}
