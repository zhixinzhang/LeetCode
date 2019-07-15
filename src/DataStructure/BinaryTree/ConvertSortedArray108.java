package DataStructure.BinaryTree;

/**
 * Created by zhang on 2017/3/14.
 */
public class ConvertSortedArray108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length);
    }
    private static TreeNode sortedArrayToBST(int[] nums,int begin,int end){
        int length = end - begin;
        if(length <1) return null;

        int mid = begin + length/2;
        TreeNode  root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,begin,mid);
        root.right = sortedArrayToBST(nums,mid+1,end);
        return root;
    }
}
