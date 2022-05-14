package DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang on 2017/9/28.
 */
public class zzx_CBTree {
    public TreeNode cbTree(int[] arr){
        TreeNode treeNode = new TreeNode(1);
        Queue<TreeNode> q = new LinkedList();
        q.add(treeNode);
        for(int i = 0; i<arr.length;i++){
            while (!q.isEmpty()){
                TreeNode curTreeNode = q.poll();
                int left = i;
                curTreeNode.left = new TreeNode(arr[left]);
                int right = ++i;
                curTreeNode.right = new TreeNode(arr[right]);
                q.add(curTreeNode.left);
                q.add(curTreeNode.right);
                if (!q.isEmpty()){
                    i++;
                }
                if (i >= arr.length)
                    break;
            }
        }
        return treeNode;
    }
}
