package Company.Google.Tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang on 2018/6/14.
 */
// 查看二分树是不是正确的， 主要看是不是有环
public class ValidBinaryTree_BFS {
    public static boolean solution(TreeNode root){
        if (root == null)   return true;
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        visited.add(root);
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if (visited.contains(cur.left)){
                cur.left = null;
                return false;
            }
            if (cur.left != null){
                q.add(cur.left);
                visited.add(cur.left);
            }
            if (visited.contains(cur.right)){
                cur.right = null;
                return false;
            }
            if (cur.right != null){
                q.add(cur.right);
                visited.add(cur.right);
            }
        }
        return true;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = root;
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        solution(root);
        int i = 0;
    }
}
