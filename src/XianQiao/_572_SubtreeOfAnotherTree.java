package XianQiao;

import DataStructure.BinaryTree.TreeNode;

/**
 * @Author: Xianqiao
 * @Date: 7/26/20 17:19
 */
public class _572_SubtreeOfAnotherTree {
    public boolean isSubTree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }
    public boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }
    public boolean equals(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
    }
}
