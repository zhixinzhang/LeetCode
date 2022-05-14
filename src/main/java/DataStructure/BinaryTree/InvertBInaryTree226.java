package DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang on 2017/2/10.
 */
//第一次自己写binary 全对   就是左右子树 调换
public class InvertBInaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return  root;
        queue.offer(root);

            while (!queue.isEmpty()){
                    TreeNode curNode = queue.poll();
                    TreeNode tmpLeft = null;
                    tmpLeft = curNode.left;
                    curNode.left = curNode.right;
                    curNode.right = tmpLeft;
                    if (curNode.left != null) queue.offer(curNode.left);
                    if (curNode.right != null) queue.offer(curNode.right);
            }

        return root;
    }
}
