package XianQiao;

import DataStructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Xianqiao
 * @Date: 7/5/20 22:50
 */
public class _700_Search_in_Binary_Tree_BFS {
    public TreeNode searchBST(TreeNode root, int val) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                TreeNode cur_root = q.remove();
                if (cur_root.val == val) {
                    return cur_root;
                }
                if (cur_root.left != null) {
                    q.add(cur_root.left);
                }
                if (cur_root.right != null) {
                    q.add(cur_root.right);
                }
            }
        }
        return null;
    }
}
