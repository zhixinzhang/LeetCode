package DataStructure.BinaryTree;

import java.util.*;

/**
 * Created by zhang on 2017/2/10.
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 */
public class BinaryTreeZigTra103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        if (root == null) return  result;
        current.offer(root);
        boolean lefttoright = true;

        while (!current.isEmpty()){
            List<Integer> level = new ArrayList<>();
            while (!current.isEmpty()){
                TreeNode curNode = current.poll();
                level.add(curNode.val);

                if (curNode.left != null) next.offer(curNode.left);
                if (curNode.right != null) next.offer(curNode.right);

            }
            if(!lefttoright) Collections.reverse(level);    //超级重点的地方  直接反转当前层
            result.add(level);
            lefttoright = !lefttoright;
            Queue<TreeNode> tmp = new LinkedList<>();
            current = next;
            next = tmp;
        }
        return  result;
    }
}
