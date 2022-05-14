package DataStructure.BinaryTree;

/**
 * Created by zhang on 2018/3/27.
 * dfs all the nodes of the tree, each node return two number, int[] num, num[0] is the max value while rob this node, num[1] is max value while not rob this value. Current node return value only depend on its children’s value.
 * Transform function should be very easy to understand.
 * 两种状态 num【0】 抢当前的node num【1】 不抢当前的node
 */
public class _337_HouseRobber3_DFS {
        public int rob(TreeNode root) {
            if(root == null) return 0;
            int[] num = dfs(root);
            return Math.max(num[0],num[1]);
        }
        private int[] dfs(TreeNode root){
            if (root == null)
                return new int[2];
            int[] res = new int[2];
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            res[0] = left[1] + right[1] + root.val;
            res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            return res;
        }
    }
