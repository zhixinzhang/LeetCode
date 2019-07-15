package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/21/19
 * Time: 7:40 PM
 * Description:
 */


public class _865_SmallestSubtreewithalltheDeepestNodes_ {
    class  Depth{
        int depth;
        TreeNode node;
        Depth(int depth, TreeNode node){
            this.depth = depth;
            this.node = node;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return recur(root).node;
    }
    public Depth recur(TreeNode root){
        if(root == null)
            return new Depth(0, root);
        Depth l = recur(root.left);
        Depth r = recur(root.right);
        if(l.depth == r.depth)
            return new Depth(l.depth+1, root);
        return l.depth > r.depth ? new Depth(l.depth+1, l.node): new Depth(r.depth+1, r.node);
    }
}
