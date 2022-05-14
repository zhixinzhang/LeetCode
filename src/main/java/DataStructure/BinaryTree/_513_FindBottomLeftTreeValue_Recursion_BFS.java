package DataStructure.BinaryTree;
import java.util.*;


//BFS from right to left 
//这道题其实有可以拆解成两个问题：
//找到二叉树的最下面一行；
//在最下面一行找到最左边的节点值。
public class _513_FindBottomLeftTreeValue_Recursion_BFS {

	public int findBottomLeftValue(TreeNode root) {
		int [] ans = new int [2];// ans[0] is the node and ans[1] is the level
		Arrays.fill(ans,-1);
		traverse(root, 0, ans);
		return ans[0];
	}

	public void traverse(TreeNode root, int level, int[] ans){
		if(root.left == null && root.right == null)
		{
			if(ans[1]<level)
			{
				ans[0] = root.val;
				ans[1] = level;
			}
			return;
		}
		if(root.left != null)
			traverse(root.left,level+1,ans);
		if(root.right != null)
			traverse(root.right,level+1,ans);
	}


	public int findLeftMostNode(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(root);
	    while (!queue.isEmpty()) {
	        root = queue.poll();
	        if (root.right != null)
	            queue.add(root.right);
	        if (root.left != null)
	            queue.add(root.left);
	    }
	    return root.val;
	}
}