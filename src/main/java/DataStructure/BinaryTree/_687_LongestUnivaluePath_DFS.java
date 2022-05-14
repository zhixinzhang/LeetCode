package DataStructure.BinaryTree;

public class _687_LongestUnivaluePath_DFS{

	private int max = 0;

	public int longestUnivaluePath(TreeNode root) {
	    if (root == null) {
	        return 0;
	    }
	    dfs(root, root.val);
	    return max;
	}

	private int dfs(TreeNode root, int val) {
	    if (root == null) {
	        return 0;
	    }
	    int left = dfs(root.left, root.val);
	    int right = dfs(root.right, root.val);
	    max = Math.max(max, left + right);
	    if (root.val == val) {
	        return Math.max(left, right) + 1;
	    } else {
	        return 0;
	    }
	}
}