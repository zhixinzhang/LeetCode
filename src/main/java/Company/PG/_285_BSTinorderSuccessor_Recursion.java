package Company.PG;
/**
 * Created by zhang on 2018/1/26.
 *  * given a binary search tree and a node. Find the in-order successor of the node.
 * return null if no successor.
 */
/**根据BST 二叉树的特性 中序遍历 给你一个p（中根） 答案输出p的后继节点  有多种情况 要都分析到
 * 有无右子树。
 * 如果没有右子树  他的后继节点 就是p的父节点
 * 如果有右子树，他的后继节点是 右子树 左面的节点
 * */
public class _285_BSTinorderSuccessor_Recursion {
    // fist case  target treeNode have right subtree  ---- > return leftmost node in right subtree
    // second case  target treeNode not have right subtree --> return father node
    //because its bst according bst attribute left < root < right
    //find target
    // search right child

    public TreeNode inorderSuccessor_noParent(TreeNode root, TreeNode p){
        if (root == null || root.left == null && root.right == null)
            return root;
        if (p.right != null){
            return searchLeftMost(p.right);
        }else{
            return searchPar(root,p);
        }
    }
    public TreeNode searchLeftMost(TreeNode root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
    public TreeNode searchPar(TreeNode root, TreeNode p){
        TreeNode par = null;
        while (root != p){
            if (p.val < root.val ){
                par = root;
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return par;
    }

    class TreeNodeWithParent{
        int val;
        TreeNodeWithParent left,right,parent;
        public TreeNodeWithParent(int value){
            this.val = value;
            left = right = parent = null;
        }
    }
    public TreeNodeWithParent inorderSuccessor_haveParent(TreeNodeWithParent root, TreeNodeWithParent n){
        // step 1 of the above algorithm
            if (n.right != null) {
                return minValue(n.right);
            }
            // step 2 of the above algorithm
            TreeNodeWithParent p = n.parent;
            while (p != null && n == p.right) {
                n = p;
                p = p.parent;
            }
            return p;
    }
    TreeNodeWithParent minValue(TreeNodeWithParent node) {
        TreeNodeWithParent current = node;
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
