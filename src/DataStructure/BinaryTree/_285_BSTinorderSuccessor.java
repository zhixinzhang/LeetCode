package DataStructure.BinaryTree;

/**
 * Created by zhang on 2017/9/30.
 * given a binary search tree and a node. Find the in-order successor of the node.
 * return null if no successor.
 */
/**根据BST 二叉树的特性 中序遍历 给你一个p（中根） 答案输出p的后继节点  有多种情况 要都分析到
 * 有无右子树。
 * 如果没有右子树  他的后继节点 就是p的父节点
 * 如果有右子树，他的后继节点是 右子树 左面的节点
 * */
public class _285_BSTinorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        if (root == null)
            return null;
        // search right child
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
}
