package DataStructure.BinaryTree;

/**
 * @Author: Luke(New Man) Zhang
 * @Date: 2021/1/6 20:12
 * Link :
 * Description:
 */
public class _114_FlattenBinaryToLinkedList_Preorder_MorrisTraversal {

    public void flatten(TreeNode root) {
        preorderDfs(root);
    }

    private TreeNode preorderDfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode newLeft = preorderDfs(root.left);
        TreeNode newRight = preorderDfs(root.right);

        if (newLeft != null) {
            // reach to the leaf node
            TreeNode leaf = newLeft;
            while (leaf.right != null) {
                leaf = leaf.right;
            }
            leaf.right = newRight;
            root.right = newLeft;
            root.left = null;
        }
        return root;
    }


    public void flatten_MorrisTraversal(TreeNode root) {
        while(root!=null){
            if(root.left!=null){
                TreeNode pre = root.left;
                while(pre.right!=null)
                    pre = pre.right;
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
