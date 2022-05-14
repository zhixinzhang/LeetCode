package ClassicProblemGroup.Tree.LowestTree;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/14/19
 * Time: 1:22 AM
 * Description:
 */


public class _235_LowestCommonAncestorofaBinarySearchTree_ {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(root.val > p.val && root.val > q.val)
                root = root.left;
            else if ( root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
        return root;
    }
}
