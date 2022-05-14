package DataStructure.BinaryTree;

import java.util.Stack;

/**
 * @author Luke(New Man) Zhang
 * @Date 1/30/2021 6:30 PM
 * <p>
 * Description:
 * Key Point:
 *
 *
 */

public class _129_SumRoottoLeafNumbers_DFS_Stack {

    /**solution 1 :
     * Time complexity: \mathcal{O}(N)O(N) since one has to visit each node.
     *
     * Space complexity: up to \mathcal{O}(H)O(H) to keep the recursion stack, where HH is a tree height.
     *
     * */
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int curVal){
        if (root == null) {
            return;
        }

        curVal = curVal * 10 + root.val;

        if (root.left == null && root.right == null) {
            ans += curVal;
            return;
        }
        dfs(root.left, curVal);
        dfs(root.right, curVal);
    }

    // Solution 2 : use stack

    /**
     * Time complexity: \mathcal{O}(N)O(N) since one has to visit each node.
     *
     * Space complexity: up to \mathcal{O}(H)O(H) to keep the stack, where HH is a tree height.
     *
     * */

    public int sumNumbers_stack(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();

            if (node.left != null) {
                node.left.val = node.val * 10 + node.left.val;
                stack.push(node.left);
            }

            if (node.right != null) {
                node.right.val = node.val * 10 + node.right.val;
                stack.push(node.right);
            }

            if (node.left == null && node.right == null) {
                ans += node.val;
            }
        }
        return ans;
    }
}
