package Company.uber;

import DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhang on 2018/9/9.
 */
// follow up zigzag bfs 遍历树
public class _102_103_BinaryTreeLevelOrderTraversal_BFS_follow {
    public static void main(String[] args){
        TreeNode root = new TreeNode(-1);
        levelOrder(root);

    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> dq = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        dq.add(root);
        while (!dq.isEmpty()){
            int size = dq.size();
            List<Integer> curRes = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode temp = dq.pollLast();
                curRes.add(temp.val);
                if (temp.left != null)
                    dq.addLast(temp.left);
                if (temp.right != null)
                    dq.addLast(temp.right);
            }
            res.add(curRes);
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        //Method: Using a deque to maintain the current nodes in the same level with the same order from left to right
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        boolean lefttoRight = true;//The order to put into result
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                if(lefttoRight) {//Case 1
                    TreeNode cur = deque.pollFirst();
                    list.add(cur.val);
                    if (cur.left != null)
                        deque.addLast(cur.left);
                    if (cur.right != null)
                        deque.addLast(cur.right);
                } else {//Case 2
                    TreeNode cur = deque.pollLast();
                    list.add(cur.val);
                    if (cur.right != null)
                        deque.addFirst(cur.right);
                    if (cur.left != null)
                        deque.addFirst(cur.left);
                }
            }
            lefttoRight = lefttoRight ? false: true;
            res.add(list);
        }
        return res;
    }
}
