package google.Tree;

import java.util.Stack;

/**
 * Created by zhang on 2018/8/9.
 */
public class _173_BinarySearchTreeIterator_Stack {
    Stack<TreeNode> stack;
    public _173_BinarySearchTreeIterator_Stack(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node;
        if (cur.right != null){
            cur = cur.right;
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
        }
        return cur.val;
    }
}
