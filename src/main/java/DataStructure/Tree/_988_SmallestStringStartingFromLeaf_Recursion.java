package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/28/19
 * Time: 4:50 PM
 * Description:
 */


public class _988_SmallestStringStartingFromLeaf_Recursion {
    public String smallestFromLeaf(TreeNode root) {
        if (root == null)
            return "";
        return recursion(root);
    }

    private String recursion(TreeNode root){
        char c = (char)(root.val + 'a');
        if(root.left == null && root.right == null)
            return String.valueOf(c);
        String l = null, r = null;
        if (root.left != null)
            l = recursion(root.left);
        if (root.right != null)
            r = recursion(root.right);

        if (l == null)  return r + c;
        if (r == null)  return l + c;
        return c + (l.compareTo(r) > 0 ? r : l);
    }
}
