package Company.Doordash;
import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 9/23/2022 2:26 PM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class _124_BinaryTreeMaximumPathSum_Recrusion_FollowUp_leaf_anynode_alive_print {
    // any node to any node
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        rec(root);
        return max;
    }

    public int rec(TreeNode root){
        if(root==null)return 0;
        int ls=Math.max(0,rec(root.left));
        int rs=Math.max(0,rec(root.right));
        max = Math.max(root.val+ls+rs, max);
        return root.val+Math.max(ls,rs);
    }

    // leaf to leaf no need root

    public int maxPathSum_leaf_to_leaf(TreeNode root) {
        max = -1 * Integer.MIN_VALUE;
        rec2(root);
        return max;
    }

    public int rec2(TreeNode root){
        if(root == null)
            return 0;
        int ls = rec(root.left);
        int rs = rec(root.right);
        int curMax = Math.max(ls, rs);

        max = Math.max(root.val+ ls + rs, max);
        return root.val + curMax;
    }

    // 定义 nodel 为alive 所有leaf都alive 还可以非leaf 为alive， path只能从一个alive 到 另一个alive 不能有非alive node

    public int maxPathSum_leaf_to_leaf_alive(TreeNode root) {
        max = -1 * Integer.MIN_VALUE;
        rec3(root);
        return max;
    }

    public int rec3(TreeNode root){
        if(root == null)
            return 0;

        int ls = rec(root.left);
        int rs = rec(root.right);
        int curMax = Math.max(ls, rs);

        if (!root.alive) {

            max = Math.max(curMax, max);
            return 0;
        }

        max = Math.max(root.val + ls + rs, max);
        return root.val + curMax;
    }



    class TreeNode{
        int val;
        boolean alive;
        List<TreeNode> path = new ArrayList<>();
        TreeNode left;
        TreeNode right;
        TreeNode(int value, boolean alive){

            this.val = value;
            this.alive = alive;
        }
    }
}
