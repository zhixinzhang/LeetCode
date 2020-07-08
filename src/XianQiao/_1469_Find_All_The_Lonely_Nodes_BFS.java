package XianQiao;

import DataStructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Xianqiao
 * @Date: 7/7/20 17:07
 */
public class _1469_Find_All_The_Lonely_Nodes_BFS {
    public List<Integer> getLonelyNodes(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur_node = q.remove();
                if (cur_node.left != null) {
                    q.add(cur_node.left);
                    if (cur_node.right == null) {
                        output.add(cur_node.left.val);
                    }
                }
                if (cur_node.right != null) {
                    q.add(cur_node.right);
                    if (cur_node.left == null) {
                        output.add(cur_node.right.val);
                    }
                }
            }
        }
        return output;
    }
}
