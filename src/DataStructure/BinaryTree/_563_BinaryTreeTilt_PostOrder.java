package DataStructure.BinaryTree;

public class _563_BinaryTreeTilt_PostOrder{
    int result = 0;
    public int findTilt(TreeNode root) {
        int tilt = 0;
        if(root == null || (root.left == null && root.right == null)) return tilt;
        //recursion  inorder
        postOrder(root);
        return result;
    }
    private int postOrder(TreeNode root){
        if(root == null) return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        result += Math.abs(left - right);
        
        return left + right + root.val;
    }
}