package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/26/19
 * Time: 3:17 PM
 * Description:
 */


public class _1008_ConstructBinarySearchTreefromPreorderTraversal_Recursion {
    public static void main(String[] args) {
        bstFromPreorder(new int[]{8,5,1,7,10,12});
    }
    static int i = 0;
    public static TreeNode bstFromPreorder(int[] A) {
        TreeNode res = recursion(A, Integer.MAX_VALUE);
        return res;
    }
    public static TreeNode recursion(int[] A, int maxValue){
        if (i >= A.length || A[i] > maxValue)
            return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = recursion(A, root.val);
        root.right = recursion(A, maxValue);
        return root;
    }
}
