package DataStructure.BinaryTree;

import java.util.Stack;

/**
 * Created by zhang on 2017/2/10.
 */
//不太会
public class BinaryTreeIteraor173 {
    private Stack<TreeNode> stack;
//    public BSTIterator(TreeNode root) {
//        stack = new Stack<>();
//        while (root!= null){
//            stack.push(root);
//            root = root.left;
//        }
//    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        final TreeNode node = stack.pop();
        if (node.right != null){
            TreeNode p = node.right;
            while (p!=null){
                stack.push(p);
                p = p.left;
            }
        }
        return  node.val;
    }
}
