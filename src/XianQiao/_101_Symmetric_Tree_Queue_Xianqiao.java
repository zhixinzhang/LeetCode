package XianQiao;

import DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Xianqiao
 * @Date: 3/28/20 21:01
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        /* cases like [1,2,null] or [1,null,2] */


        LinkedList<TreeNode> queue = new LinkedList<>();
        int size;
        TreeNode root1, root2;

        queue.add(root.left); queue.add(root.right);
        while (queue.size() != 0) {
            size = queue.size();
            for (int i=0; i<size/2; i++) {
                /* iterate for size/2 because we look at two nodes at a time */
                root1 = queue.poll();
                root2 = queue.poll();
                if (root1.val != root2.val) return false;
                /* basic symmetry condition */
                if (root1.left != null && root2.right == null ||
                        root1.right != null && root2.left == null ||
                        root2.left != null && root1.right == null ||
                        root2.right != null && root1.left == null) return false;
					/*
					example cases for all 4 conditions that should return false
					1. [2, 3, 3, 4, 5, 5, null]
					2. [2, 3, 3, 4, 5, null, 4]
					3. [2, 3 ,3 ,5 ,null ,4 ,5]
					4. [2, 3, 3, null, 4, 4, 5]
					*/
                if (root1.left != null) {
                    /* if root1.left exists then root2.right will exist because of checks */
                    queue.add(root1.left); queue.add(root2.right);
                }
                if (root1.right != null) {
                    /* same for this */
                    queue.add(root1.right); queue.add(root2.left);
                }
            }
        }
        return true;
    }
}
