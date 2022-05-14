package ClassicProblemGroup.Tree.Return_Path_Recursion;
import java.util.*;
/**
 * Created by zhang on 2017/10/17.
 */
/*题意：在二叉树中找一条路径，使得该路径的和最大。该路径可以从二叉树任何结点开始，也可以到任何结点结束。

思路：递归求一条经过root的最大路径，这条路径可能是：
1) 左边某条路径 + root + 右边某条路径
2) 左边某条路径 + root
3) root + 右边某条路径
4) root
 * */
/**
 * 2
 /  \
 1     3
     /      \
     15        16
        17   4
 * */
public class _124_BinaryTreeMaximumPathSum {
   static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int value){
            this.val = value;
        }
    }
    public static void main(String[] args){
    String[] v = new String[]{"2","1","3",null,null,"15","16",null,"17","4",null};
        //build tree
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(v[0]));
        q.add(root);
        int size = q.size();
        int i = 1;
        while (size>0){
            TreeNode curNode = q.poll();
            if (v[i] != null){
                curNode.left = new TreeNode(Integer.valueOf(v[i]));
                q.add(curNode.left);
            }
            i++;
            if (v[i] != null){
                curNode.right = new TreeNode(Integer.valueOf(v[i]));
                q.add(curNode.right);
            }
            i++;
            if (i >= v.length)
                break;
            size = q.size();
        }
    }

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxSum(root);
        return max;
    }
    public int maxSum(TreeNode root) {
        if (root == null) return 0;

        int leftVal = maxSum(root.left);    //递归求左支路的最大路径和
        int rightVal = maxSum(root.right);  //递归求右支路的最大路径和

        //如果当前局部解（root或left+root或root+right或left+root+right）是最有解，更新最终结果
        int curMax = root.val;
        if (leftVal > 0) {
            curMax += leftVal;
        }
        if (rightVal > 0) {
            curMax += rightVal;
        }
        if (curMax > max) {
            max = curMax;
        }

        //返回从叶子结点到root的最大路径和（root或left+root或root+right）
        return Math.max(root.val, Math.max(root.val + leftVal, root.val + rightVal));
    }
}
