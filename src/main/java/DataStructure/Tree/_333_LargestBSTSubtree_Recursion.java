package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/21/19
 * Time: 9:10 PM
 * Description:
 */


public class _333_LargestBSTSubtree_Recursion {
    int max=0;
    public int largestBSTSubtree(TreeNode root) {
        if(root!=null) max=1;
        int[] t=helper(root);
        return max;
    }
    public int[] helper(TreeNode root){
        if(root==null) return new int[]{0,Integer.MAX_VALUE,Integer.MIN_VALUE};
        if(root.left==null && root.right==null) return new int[]{1,root.val,root.val};
        int[] left=helper(root.left);
        int[] right=helper(root.right);
        if(left[0]==-1 || right[0]==-1 || left[2]>=root.val || right[1]<=root.val) return new int[]{-1,0,0};
        max=Math.max(max,1+left[0]+right[0]);
        return new int[]{1+left[0]+right[0],Math.min(left[1],root.val),Math.max(right[2],root.val)};
    }
}
