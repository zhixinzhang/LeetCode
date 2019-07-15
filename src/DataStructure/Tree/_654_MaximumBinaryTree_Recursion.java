package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/26/19
 * Time: 4:36 PM
 * Description:
 */


public class _654_MaximumBinaryTree_Recursion {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0)
            return new TreeNode(0);
        Deque<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++){
            TreeNode cur = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peek().val < nums[i]){
                cur.left = stack.poll();
            }
            if(!stack.isEmpty()) {
                stack.peek().right = cur;
            }
            stack.push(cur);
        }
        return stack.isEmpty() ? null : stack.removeLast();

    }
}
