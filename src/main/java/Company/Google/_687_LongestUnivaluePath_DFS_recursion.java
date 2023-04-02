package Company.Google;

/**
 * Created by zhang on 2018/5/19.
 */
/**             5
 *          4      5
 *      1      1     5
 * */
public class _687_LongestUnivaluePath_DFS_recursion  {
        int max = 0;

        public int longestUnivaluePath(TreeNode root) {
            if (root == null)   return max;
            dfs(root, root.val);
            return max;
        }
        private int dfs(TreeNode root, int val){
            if (root == null)   return 0;
            int left = dfs(root.left,root.val);
            int right = dfs(root.right,root.val);
            int cur = left + right; //  母结点 加上左右子树的长度
            max = Math.max(cur,max);
            if (root.val == val)
                return Math.max(left,right) + 1;
            else
               return 0;
        }
    }
