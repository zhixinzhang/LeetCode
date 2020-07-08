package XianQiao;

import DataStructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Xianqiao
 * @Date: 6/27/20 21:41
 */
public class _199_Binary_Tree_Right_Side_View_BFS {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            list.add(q.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode curRoot = q.poll();
                if (curRoot.right != null) {
                    q.add(curRoot.right);
                }
                if (curRoot.left != null) {
                    q.add(curRoot.left);
                }
            }
        }
        return list;
    }
}
