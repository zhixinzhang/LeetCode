package google;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//
public class _94_BinaryTreeInorderTraversal{
	 static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int value){
			this.val = value;
		}
	}
	//stack O(n)
	/**				1                 inorder      null 2 4 1 5 3 null
	 * 			2      3
	 *      null  4   5  null
	 * */
	public static List<Integer> inorderTraversal_stack(TreeNode root) {
			List<Integer> nodeList = new ArrayList<>();
			Stack<TreeNode> stack = new Stack<>();
			while (root != null || !stack.empty()) {
				while (root != null) {
					stack.push(root);
					root = root.left;
				}
				root = stack.pop();
				nodeList.add(root.val);
				root = root.right;
			}
			return nodeList;
    }
	// recursion
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inOrder(root, list);
		return list;
	}
	public void inOrder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		inorderTraversal_stack(root);
	}

}