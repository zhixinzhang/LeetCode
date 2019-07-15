package DataStructure.BinaryTree;


/**
 * Created by zhang on 2017/10/16.
 */
/*以下是AC解
* 非非常经典的 递归 以及dfs
* */
public class _437_PathSum3_classic {
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return dfs(root, sum)+pathSum(root.left, sum)+pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum){
        int res = 0;
        if(root == null)
            return res;
        if(sum == root.val)
            res++;
        res+=dfs(root.left,sum - root.val);
        res+=dfs(root.right,sum - root.val);
        return res;
    }
}
