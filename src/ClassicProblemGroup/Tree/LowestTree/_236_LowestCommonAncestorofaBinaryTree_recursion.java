package ClassicProblemGroup.Tree.LowestTree;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created by zhang on 2018/8/18.
 * 	//O(n) recursion postOrder  tree travel from botton to up
 // 1. from top go down find p or q in tree
 // 2. if current node equal p or q its mean i found node p and q and keep go up  if not p or q and its leaf node
 // we return null
 // 3. if
 */
public class _236_LowestCommonAncestorofaBinaryTree_recursion {

    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return null;
        TreeNode l = lca(root.left, p, q);
        TreeNode r = lca(root.right, p, q);
        if(l != null && r != null)
            return root;
        if(root.val == p.val || root.val == q.val)
            return root;
        return l == null ? r : l;
    }
}
