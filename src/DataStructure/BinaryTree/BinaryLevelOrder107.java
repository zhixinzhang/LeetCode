package DataStructure.BinaryTree;

import java.util.*;

/**
 * Created by zhang on 2017/2/9.
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 */
public class BinaryLevelOrder107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        if (root == null) return result;
        current.offer(root);
        while (!current.isEmpty()){
            List<Integer> level = new ArrayList<>();
            while (!current.isEmpty()){
                TreeNode node = current.poll();
                level.add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            result.add(level);
            Queue<TreeNode> tmp = current;
            current = next;
            next = tmp;

        }
        Collections.reverse(result);
        return result;
    }

}
