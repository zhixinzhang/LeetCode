package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/26/19
 * Time: 6:05 PM
 * Description:
 */


public class _998_MaximumBinaryTree2_Recursion {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root != null && root.val > val){
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
        TreeNode node = new TreeNode(val);
        node.left = root;
        return node;
    }
}
