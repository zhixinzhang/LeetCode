package XianQiao;

import DataStructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Xianqiao
 * @Date: 6/25/20 18:59
 */

/** My Solution */
public class _1302_Deepest_Leaves_Sum {
    public int deepestLeavesSum_BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            sum = 0;
            int size = queue.size(); /** Remember to make size a fix value for each round! False: for loop: i < queue.size()*/
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
                sum += root.val;
            }
        }
        return sum;
    }

    /** DFS */
    int sum = 0;
    int deepest = 0;
    public int deepestLeavesSum_DFS(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    private void helper(TreeNode root, int level) {
        //break condition
        if (root == null) return;

        //recursion
        helper(root.left, level+1);
        helper(root.right, level+1);

        //operation
        if (level > deepest) {
            deepest = level;
            sum = root.val;
        } else if (level == deepest) {
            sum += root.val;
        }
    }
}
