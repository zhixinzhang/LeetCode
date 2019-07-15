package ClassicProblemGroup.Tree.CompareTree;

import DataStructure.BinaryTree.TreeNode;

import java.util.Stack;

/**
 * Created by zhang on 2017/2/10.
 */
public class SameBinary {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);

        while (!stack.isEmpty()){
            p = stack.pop();
            q = stack.pop();

            if (p == null && q == null) continue;
            if(p ==null || q==null) return false;
            if (p.val !=q.val) return false;

            stack.push(p.left);
            stack.push(q.left);

            stack.push(p.right);
            stack.push(q.right);

        }
        return true;

    }
}
