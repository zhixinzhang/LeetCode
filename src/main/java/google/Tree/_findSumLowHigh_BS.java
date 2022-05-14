package google.Tree;


/**
 * Created by zhang on 2018/7/2.
 * 给一个BST 和区间（low < x <= high） 求区间里node店的合
 * https://www.geeksforgeeks.org/count-bst-nodes-that-are-in-a-given-range/
 */
public class _findSumLowHigh_BS {
    static int res = 0;
    public static int solution(TreeNode root){
        if (root == null)
            return 0;
        //inorder
        recur(root,5,10);
        bs(root,5,10);
        return res;
    }
    public static int recur(TreeNode root,int low, int high){
        if (root == null)
            return 0;
        recur(root.left,low,high);
        if (root.val > low && root.val <= high)
            res += root.val;
        recur(root.right,low,high);
        return res;
    }

    public static void bs(TreeNode root,int low, int high){
        if (root == null)
            return;
        if (root.val > low && root.val <= high){
            res +=  root.val;
            bs(root.left,low,high);
            bs(root.right,low,high);
        }else if (root.val < low){
            bs(root.right,low,high);
        }else
            bs(root.left,low,high);
    }







    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(1);

        root.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        int a = solution(root);
    }
}
