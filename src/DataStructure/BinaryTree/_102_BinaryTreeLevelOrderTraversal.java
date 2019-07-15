package DataStructure.BinaryTree;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhang on 2017/10/7.
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 For example:
 Given binary tree [3,9,20,null,null,15,7]
 */
/**
 * BFS 循环 用Deque  重点是可以用 q.size  循环每一层的node
 * for q.size
 * */
public class _102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  rs = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        if (root == null){
            return rs;
        }else {
            q.add(root);
        }


        while (!q.isEmpty()){
            List<Integer> rr = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i<size;i++){
                TreeNode cur_node = q.poll();
                rr.add(cur_node.val);
                if (cur_node.left != null)
                    q.add(cur_node.left);

                if (cur_node.right != null)
                    q.add(cur_node.right);
            }
            rs.add(rr);
        }


        return rs;
    }
}
