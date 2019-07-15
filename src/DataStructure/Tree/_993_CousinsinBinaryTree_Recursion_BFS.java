package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/26/19
 * Time: 9:44 PM
 * Description:
 */


public class _993_CousinsinBinaryTree_Recursion_BFS {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        isCousins(root, 4, 5);
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        int[] cache = new int[4];
        Arrays.fill(cache, -1);
        int[] p = dfs(root, x, y, 0, cache);

        if(p[0] == p[1] && p[2] != p[3])
            return true;
        else
            return false;
    }

    public static int[] dfs(TreeNode root, int x, int y, int level, int[] cache){
        if(root == null) return cache;
        if(root.left != null && (root.left.val == x || root.left.val == y)){
            if (cache[0] == -1){
                cache[0] = level;
                cache[2] = root.val;
            }
            else{
                cache[1] = level;
                cache[3] = root.val;
            }
            return cache;
        }
        if (root.right != null && (root.right.val == y || root.right.val == x)){
            if (cache[0] == -1){
                cache[0] = level;
                cache[2] = root.val;
            }
            else{
                cache[1] = level;
                cache[3] = root.val;
            }
            return cache;
        }
        cache = dfs(root.left, x,  y, level+1, cache);
        cache = dfs(root.right, x, y, level+1, cache);
        return cache;
    }

    public static boolean bfs(TreeNode root, int A, int B){
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isAexist = false;
            boolean isBexist = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == A) isAexist = true;
                if (cur.val == B) isBexist = true;
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == A && cur.right.val == B) {
                        return false;
                    }
                    if (cur.left.val == B && cur.right.val == A) {
                        return false;
                    }
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (isAexist && isBexist)  return true;
        }
        return false;
    }
}
