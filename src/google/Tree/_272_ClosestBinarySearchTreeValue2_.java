package google.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhang on 2018/6/29.
 */
public class _272_ClosestBinarySearchTreeValue2_ {
        public static List<Integer> closestKValues(TreeNode root, double target, int k) {
            LinkedList<Integer> res = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curt = root;
            while (curt != null){
                stack.push(curt);
                curt = curt.left;
            }
            while (!stack.isEmpty()){
                curt = stack.pop();
                if (res.size() == k){
                    if (Math.abs(curt.val - target) >= Math.abs(res.getFirst() - target)){
                        break;
                    } else {
                        res.removeFirst();
                    }
                }
                res.add(curt.val);
                if (curt.right != null){
                    curt = curt.right;
                    while (curt != null){
                        stack.push(curt);
                        curt = curt.left;
                    }
                }
            }
            return res;
        }
        public static void main(String[] args){
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);
            root.right = new TreeNode(8);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(11);

            closestKValues(root, 7.1,3);
        }
}
