package DataStructure.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhang on 2017/10/13.
 */
/**用 Deque 根据flag判断左右的方向
 * 重点是1.  要知道deque poll和add的时候 for循环里 deque的size 直接变化 所以最好先 int size = deque.size
 * 2. 创建 List<DataStructure.Integer>的时候 只是clear 要想到神复制 潜复制的问题
 * */
public class _103_ZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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

    public static void main(String[] args){
        int[] arr = {3,9,20,15,7};
        List<String> node = new ArrayList<>();
        node.add("3");
        node.add("9");
        node.add("20");
        node.add(null);
        node.add(null);
        node.add("15");
        node.add("7");

        zzx_createBTree zz = new zzx_createBTree();
        TreeNode treeNode = zz.createTree(node);
        List<List<Integer>> res = zigzagLevelOrder(treeNode);
        int a = 0;
    }
}
