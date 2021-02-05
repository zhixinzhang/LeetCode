package Company.PG;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang on 2018/1/26.
 */
// postOrder from bottom to up
//                10
//            /      \
//            -2        7
//            /   \
//            8     -4
public class _LargestPathSumFromRoottoLeaf_Recursion_postOrder {
//    static int res;
    public static int rootToLeaf(TreeNode root){
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
//        int res = DataStructure.Integer.MIN_VALUE;
        int l = postOrder(root);
        return l;
    }
    private static int postOrder(TreeNode root){
        // return case
        if (root == null)
            return 0;
        int curVal = root.val;
        // go left
        int left = Math.max(0,postOrder(root.left));
        int right = Math.max(0,postOrder(root.right));
        //
        int temp = Math.max(left,right) + curVal;
//        res = Math.max(res,temp);
        return temp;
    }
    public static void main(String[] args){
        int[] arr = new int[]{10,2,7,8,-4};
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        q.add(root);
        int size = q.size();
        int i = 1;
        while (!q.isEmpty()){
            TreeNode curNode = q.poll();
            curNode.left = new TreeNode(arr[i]);
            i++;
            curNode.right = new TreeNode(arr[i]);
            i++;
            q.add(curNode.left);
            q.add(curNode.right);
            if (i >= arr.length-1)
                break;
        }
        rootToLeaf(root);
    }
}
