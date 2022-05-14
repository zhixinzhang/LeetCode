package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/29/19
 * Time: 12:32 AM
 * Description:
 * 题目一样
 * completeBinarySearchTree_BFS_Recursion
 */


public class _958_CheckCompletenessofaBinaryTree_BFS {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leafNode = false;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curNode = q.poll();
                if((curNode.left != null || curNode.right != null) && leafNode)
                    return false;
                if(curNode.left == null && curNode.right != null)
                    return false;
                if(curNode.left == null || curNode.right == null)
                    leafNode = true;
                if(curNode.left != null) q.add(curNode.left);
                if(curNode.right != null) q.add(curNode.right);
            }
        }
        return true;
    }
}
