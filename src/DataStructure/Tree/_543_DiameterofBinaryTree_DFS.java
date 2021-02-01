package DataStructure.Tree;

/**
 * @author Luke(New Man) Zhang
 * @Date 1/31/2021 11:43 PM
 * <p>
 * Description:
 * Key Point:
 *
 * 二叉树的直径：二叉树中从一个结点到另一个节点最长的路径，叫做二叉树的直径
 * 采用分治和递归的思想：根节点为root的二叉树的直径 = Max(左子树直径，右子树直径，左子树的最大深度（不包括根节点）+右子树的最大深度（不包括根节点）+1)
 */

public class _543_DiameterofBinaryTree_DFS {

    int maxResult = 0;
    public int diameterOfBinaryTree_recur(DataStructure.BinaryTree.TreeNode root) {
        if(root == null)
            return maxResult;
        recur(root);
        return maxResult;
    }
    public int recur(DataStructure.BinaryTree.TreeNode root){
        if(root == null)
            return 0;
        int l = recur(root.left);
        int r = recur(root.right);
        maxResult = Math.max(l + r, maxResult);
        return Math.max(l,r) + 1;
    }
}
