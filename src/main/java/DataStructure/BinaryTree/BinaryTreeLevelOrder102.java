package DataStructure.BinaryTree;

import java.util.*;

/**
 * Created by zhang on 2017/2/8.
 */
//用的是队列  迭代版，还有递归版
public class BinaryTreeLevelOrder102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode>  next = new LinkedList<>();

        if (root == null){
            return  result;
        }else {
            current.offer(root);
        }

        while (!current.isEmpty()){
            List<Integer> level = new ArrayList<>();
            while (!current.isEmpty()){
                TreeNode node = current.poll();
                level.add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            result.add(level);
            //swap
            Queue<TreeNode> tmp = current;
            current = next;
            next = tmp;
        }
        return  result;
    }

}
