package DataStructure.BinaryTree;
import java.util.*;

public class _623_AddOneRowtoTree_DFS_BFS{
	 public TreeNode addOneRow_BFS(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newroot = new TreeNode(v);
            newroot.left = root;
            return newroot;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 0; i < d-2; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode t = queue.poll();
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
        }
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            TreeNode tmp = t.left;
            t.left = new TreeNode(v);
            t.left.left = tmp;
            tmp = t.right;
            t.right = new TreeNode(v);
            t.right.right = tmp;
        }
        return root;
    }


        public TreeNode addOneRow_DFS(TreeNode root, int v, int d) {
        if (d < 2) {
            TreeNode newroot = new TreeNode(v);
            if (d == 0) newroot.right = root;
            else newroot.left = root;
            return newroot;
        }
        if (root == null) return null;
        root.left = addOneRow_DFS(root.left, v, d == 2 ? 1 : d-1);
        root.right = addOneRow_DFS(root.right, v, d == 2 ? 0 : d-1);
        return root;
    }
}