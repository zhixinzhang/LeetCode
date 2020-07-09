package XianQiao;

import DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Xianqiao
 * @Date: 7/8/20 23:06
 */
public class _102BinaryTreeLevelOrderTraversal_BFS {
    /** Remember how to use ArrayList */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        if (root == null) {
            return list;
        }
        while (!q.isEmpty()) {
            list.add(new ArrayList<Integer>());
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                list.get(level).add(cur.val);
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            level++;
        }
        return list;
    }
}
