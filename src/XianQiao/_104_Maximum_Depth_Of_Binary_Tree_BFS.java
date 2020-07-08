package XianQiao;

import DataStructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Xianqiao
 * @Date: 6/26/20 15:49
 */
public class _104_Maximum_Depth_Of_Binary_Tree_BFS {
    /** My Solution */
    public int maxDepth_BFS(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        if (root == null) {
            return 0;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur_root = q.poll();
                if (cur_root.left != null) {
                    q.add(cur_root.left);
                }
                if (cur_root.right != null) {
                    q.add(cur_root.right);
                }
            }
            depth += 1;
        }
        return depth;
    }

    /** Given Solution */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }

}
