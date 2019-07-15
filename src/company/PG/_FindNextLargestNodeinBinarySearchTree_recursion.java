package company.PG;

/**
 * Created by zhang on 2018/1/29.
 */
/***                7
 *             4            12
 *          2      5      8     14
 *        1      4.5  6
 *
 * ***/
// _285_BSTinorderSuccessor_Recursion
// 1. curNode no right subTree  ---> return parent (biggern than cueNode)
//  2. curNode have right subTree  ---> return smallest node in right subTree
public class _FindNextLargestNodeinBinarySearchTree_recursion {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode(){

        }
        TreeNode(int value){
            this.val = value;
        }
    }
    public TreeNode findNextLargestNode(TreeNode root,TreeNode  curNode){
            // according the BST attribute
            if (root == null) return new TreeNode();
            if (curNode.right != null){
                return findRight(curNode.right);
            }else{
                return findParent(curNode.left);
            }
    }
    private TreeNode findRight(TreeNode root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
    private TreeNode findParent(TreeNode root){
        while (root.parent != null && root.parent.left != root){
            root = root.parent;
        }
        return root;
    }
}
