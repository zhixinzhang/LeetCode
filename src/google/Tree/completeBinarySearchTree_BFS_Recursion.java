package google.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang on 2018/6/12.
 * https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/
 * https://github.com/awangdev/LintCode/blob/master/Java/Complete%20Binary%20Tree.java
 * - 当出现了第一次有 null children的node的时候, 说明到了leaf level, mark flag = true;
 - 自此以后，queue再不该有node再有child; queue后面出现的node的left/right child应该都是null
 - 否则就是有问题, return false;

 https://www.geeksforgeeks.org/check-whether-binary-tree-complete-not-set-2-recursive-solution/
 */
// geekforgeek 的解法跟我想的一样 level travel by level
public class completeBinarySearchTree_BFS_Recursion {
    public boolean solution(TreeNode root){
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (flag && (node.left != null || node.right != null)) {
                return false;
            }
            if (node.left == null && node.right != null) {
                return false;
            } else if (node.left == null || node.right == null) {
                flag = true;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return true;
    }


    public boolean isComplete(TreeNode root){
        int nodeNums = countNode(root);
        return isComplete(root,0,nodeNums);
    }
    public int countNode(TreeNode root){
        if (root == null)
            return 0;
        return (countNode(root.left) + countNode(root.right)+1);
    }
    public boolean isComplete(TreeNode root, int index, int nodeNums){
        if(root == null)
            return true;
        if (index >= nodeNums)
            return false;
        return(isComplete(root.left, index*2+1,nodeNums) &&
                isComplete(root.right, index*2+2,nodeNums));
    }

}
