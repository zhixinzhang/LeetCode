package XianQiao;

import DataStructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Xianqiao
 * @Date: 7/8/20 22:21
 */
public class _1315_SumOfNodesWithEvenValuedGrandparents_BFS {
    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int sum = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();
                if (cur.left != null) {
                    q.add(cur.left);
                    if (cur.val % 2 == 0) {
                        if (cur.left.left != null) {
                            sum += cur.left.left.val;
                        }
                        if (cur.left.right != null) {
                            sum += cur.left.right.val;
                        }
                    }
                }
                if (cur.right != null) {
                    q.add(cur.right);
                    if (cur.val % 2 == 0) {
                        if (cur.right.left != null) {
                            sum += cur.right.left.val;
                        }
                        if (cur.right.right != null) {
                            sum += cur.right.right.val;
                        }
                    }
                }
            }
        }
        return sum;
    }
}
