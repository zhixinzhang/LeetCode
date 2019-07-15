package DataStructure.BinaryTree;


// 34568  inorder 排序 两两比较
//O(logn) space  time O(n)

public class _530_MinimumAbsoluteDifferenceinBST_Inorder{

    int minDiff = Integer.MAX_VALUE;
    TreeNode prev;
    
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        inorder(root.right);
    }
}