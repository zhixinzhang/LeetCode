package DataStructure.BinaryTree;

/**
 * Created by zhang on 2017/10/9.
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
/*完成高度最小的BST  左子树小于root点  root 小于右子树
把他分为很多个小bst  用递归 和 二分法  高度最小
key point  O(n) 每个节点 常数操作
* */
public class _108_ConvertSortedArraytoBinarySearchTree_recursion_BS_google {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0 || nums == null){
            return null;
        }
        return buildtree(nums,0,nums.length-1);
    }
    private TreeNode buildtree(int[] nums,int start, int end ){
        if (start > end){
            return  null;
        }
        int mid = start + (end - start)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildtree(nums,start,mid-1);
        root.right = buildtree(nums,mid+1,end);
        return root;
    }
}
