package google.Tree;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description: https://leetcode.com/problems/binary-search-tree-iterator/solution/
 * Key Point:
 */

public class _173_BinarySearchTreeIterator_Stack_LinkedList {

    // Solution 1 : use stack do inorder travel
    private Stack<TreeNode> stack;
    public _173_BinarySearchTreeIterator_Stack_LinkedList(TreeNode root) {
        stack = new Stack<>();
        while (root!= null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null){
            TreeNode p = node.right;
            while (p!=null){
                stack.push(p);
                p = p.left;
            }
        }
        return  node.val;
    }

    // Solution 2 : use linkedlist do inorder travel
    private LinkedList<TreeNode> queue;
    public void _173_BinarySearchTreeIterator_Stack_LinkedList_2(TreeNode root) {
        queue = new LinkedList<>();
        doInorderTravel(queue, root);
    }

    private void doInorderTravel(LinkedList<TreeNode> queue, TreeNode root){
        if (root != null) {
            doInorderTravel(queue, root.left);
            queue.add(root);
            doInorderTravel(queue, root.right);
        }
    }

    public boolean hasNext_2() {
        return !queue.isEmpty();
    }

    public int next_2() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            return queue.poll().val;
        }
    }

}
