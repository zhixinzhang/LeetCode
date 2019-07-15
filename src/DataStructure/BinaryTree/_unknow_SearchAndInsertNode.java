package DataStructure.BinaryTree;

/**
 * Created by zhang on 2017/9/30.
 */


/**BST  binary search tree  每个节点的左节点 小于 根节点 小于右节点
 * */
public class _unknow_SearchAndInsertNode {
    // iterative method
    public TreeNode search(TreeNode root, int val){
        if (root == null || root.val == val)
            return root;
        TreeNode cur = root;
        while (cur != null){
            if (cur.val == val)
                return cur;
            else if (cur.val < val){
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }
    // recursion method
    public TreeNode searchRecursion(TreeNode root, int val){
        if (root == null || root.val == val)
            return root;
        else if (root.val < val){
            return searchRecursion(root.right,val);
        }else{
            return searchRecursion(root.left,val);
        }
    }
    // resursion for insert
    public TreeNode insertRecursion(TreeNode root, int val){
        if (root == null){
            return new TreeNode(val);
        }
        if (root.val > val){
            root.left = insertRecursion(root.left,val);
        }else if (root.val < val){
            root.right = insertRecursion(root.right,val);
        }
        return root;
    }

}
