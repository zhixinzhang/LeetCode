package DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.*;

/**
 * BFS traversal to get next level sum, and keep a copy of current level of nodes;
For each node, use next level sum minus its kids' value sum to get the required value.
 * 
*/
public class _2641_CousinsinBinaryTree_BFS {
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<TreeNode> parents = new ArrayList<>(q);
            int nextLevelSum = 0;
            for (int sz = q.size(); sz > 0; --sz) {
                TreeNode n = q.poll();
                for (TreeNode kid : new TreeNode[]{n.left, n.right}) {
                    if (kid != null) {
                        q.offer(kid);
                        nextLevelSum += kid.val;
                    }
                }
            }
            for (TreeNode n : parents) {
                int replacedVal = nextLevelSum;
                for (TreeNode kid : new TreeNode[]{n.left, n.right}) {
                    if (kid != null) {
                        replacedVal -= kid.val;
                    }
                }
                for (TreeNode kid : new TreeNode[]{n.left, n.right}) {
                    if (kid != null) {
                        kid.val = replacedVal;
                    }
                }
            }
        }
        return root;
    }
}
