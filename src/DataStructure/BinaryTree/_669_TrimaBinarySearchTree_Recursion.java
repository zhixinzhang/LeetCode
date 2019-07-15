package DataStructure.BinaryTree;


/**
如果当前 root 正好在范围之内，那么把问题递归到它的左结点和右结点。
如果当前 root 不在范围内，比 L 小，那么 它和它的左子树 可以被抛弃了。
如果当前 root 不在范围内，比 R 大，那么 它和它的右子树 可以被抛弃了。
*/
public class _669_TrimaBinarySearchTree_Recursion{
	    public TreeNode trimBST(TreeNode root, int L, int R) {
             while (root != null && (root.val < L || root.val > R)) {
            if (root != null && root.val < L) 
                root = root.right;
            if (root != null && root.val > R)
                root = root.left;
        }
        
        if (root != null) {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        }
        return root;
    }
}