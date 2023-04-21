package Company.Ebay;

import DataStructure.BinaryTree.TreeNode;

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
    int recordedDepth = -1;
    boolean isCousin = false;

    public boolean isCousins(TreeNode root, int x, int y) {
     /**
      *Start traversing the tree from the root node. Look for Node x and Node y.

Record the depth when the first node i.e. either of x or y is found and return true.

Once one of the nodes is discovered, for every other recursive call after this discovery, we return false if the current depth is more than the recorded depth. This basically means we didn't find the other node at the same depth and there is no point going beyond. This step of pruning helps to speed up the recursion by reducing the number of recursive calls.

Return true when the other node is discovered and has the same depth as the recorded depth. 

     */
        dfs(root, 0, x, y);
        return this.isCousin;
    }

    private boolean dfs(TreeNode node, int depth, int x, int y) {

        if (node == null) {
            return false;
        }

        // Don't go beyond the depth restricted by the first node found.
        if (this.recordedDepth != -1 && depth > this.recordedDepth) {
            return false;
        }

        if (node.val == x || node.val == y) {
            if (this.recordedDepth == -1) {
                // Save depth for the first node found.
                this.recordedDepth = depth;
            }
            // Return true, if the second node is found at the same depth.
            return this.recordedDepth == depth;
        }

        boolean left = dfs(node.left, depth + 1, x, y);
        boolean right = dfs(node.right, depth + 1, x, y);

        // this.recordedDepth != depth + 1 would ensure node x and y are not
        // immediate child nodes, otherwise they would become siblings.
        if (left && right && this.recordedDepth != depth + 1) {
            this.isCousin = true;
        }
        return left || right;
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
