package XianQiao;

import DataStructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Xianqiao
 * @Date: 7/5/20 22:38
 */
public class _938_Range_Sum_of_BST_BFS {
    public int rangeSumBST(TreeNode root, int L, int R) {
        Queue<TreeNode> q = new LinkedList<>();
        int sum = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur_root = q.remove();
                if (cur_root.val <= R && cur_root.val >= L) {
                    sum += cur_root.val;
                    if (cur_root.left != null) {
                        q.add(cur_root.left);
                    }
                    if (cur_root.right != null) {
                        q.add(cur_root.right);
                    }
                } else if (cur_root.val > R) {
                    if (cur_root.left != null) {
                        q.add(cur_root.left);
                    }
                } else if (cur_root.val < L) {
                    if (cur_root.right != null) {
                        q.add(cur_root.right);
                    }
                }
            }
        }
        return sum;
    }
}
