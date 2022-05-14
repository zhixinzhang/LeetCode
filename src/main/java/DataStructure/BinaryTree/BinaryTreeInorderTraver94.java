package DataStructure.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhang on 2017/2/7.
 * [1,null,2,3],
 * return [1,3,2].
 */
//中许便利  顺序访问左中右
public class BinaryTreeInorderTraver94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return  result;
        TreeNode p = root;
        while (!stack.isEmpty() || p != null){
            if (p != null){
                stack.push(p);
                p = p.left;
            }else {
                p = stack.pop();
                result.add(p.val);
                p = p.right;
            }
        }
        return result;
    }
}
