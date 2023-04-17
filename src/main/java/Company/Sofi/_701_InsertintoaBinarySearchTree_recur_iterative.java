package Company.Sofi;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/1/19
 * Time: 3:16 PM
 * Description:
 */


public class _701_InsertintoaBinarySearchTree_recur_iterative {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) 
            return new TreeNode(val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        return root;
    }

    public TreeNode inserIntoBST_iter(TreeNode root, int val){
        if (root == null) 
            return new TreeNode(val);
        TreeNode cur = root;
        while(true) {
            if(cur.val <= val) {
                if(cur.right != null) cur = cur.right;
                else {
                    cur.right = new TreeNode(val);
                    break;
                }
            } else {
                if(cur.left != null) cur = cur.left;
                else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

}
