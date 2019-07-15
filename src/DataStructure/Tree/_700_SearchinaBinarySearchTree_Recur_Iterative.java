package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/1/19
 * Time: 9:27 PM
 * Description:
 */


public class _700_SearchinaBinarySearchTree_Recur_Iterative {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val)
            return root;
        else if(root.val > val){
            return searchBST(root.left, val);
        }
        else{
            return searchBST(root.right, val);
        }
    }

    public TreeNode searchBST_iter(TreeNode root, int val) {
        if(root == null) return root;
        while(true){
            if (root == null)
                break;
            if(root.val == val)
                return root;
            if(root.val < val){
                root = root.right;
            }else if(root.val > val)
                root = root.left;
        }
        return null;
    }
}
