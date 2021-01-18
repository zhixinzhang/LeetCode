package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description:
 * Key Point:
 *
 */

public class _235_LowestCommonAncestorofaBinarySearchTree_Recursion_Iterative {

    /**
     * Solution 1 :
     * Start traversing the tree from the root node.
     * If both the nodes p and q are in the right subtree, then continue the search with right subtree starting step 1.
     * If both the nodes p and q are in the left subtree, then continue the search with left subtree starting step 1.
     * If both step 2 and step 3 are not true, this means we have found the node which is common to node p's and q's subtrees. and hence we return this common node as the LCA.
     *
     * Time Complexity: O(N)O(N), where NN is the number of nodes in the BST. In the worst case we might be visiting all the nodes of the BST.
     *
     * Space Complexity: O(N)O(N). This is because the maximum amount of space utilized by the recursion stack would be NN since the height of a skewed BST could be NN.
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return root;
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }


    /**
     * Algorithm
     *
     * The steps taken are also similar to approach 1. The only difference is instead of recursively calling the function,
     * we traverse down the tree iteratively. This is possible without using a stack or recursion since we don't need to backtrace to find the LCA node.
     * In essence of it the problem is iterative, it just wants us to find the split point. The point from where p and q won't be part of the same subtree or when one is the parent of the other.
     *
     * Time Complexity : O(N)O(N), where NN is the number of nodes in the BST. In the worst case we might be visiting all the nodes of the BST.
     *
     * Space Complexity : O(1)O(1).
     * */
    public TreeNode lowestCommonAncestor_Iterative (TreeNode root, TreeNode p, TreeNode q) {
        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        // Start from the root node of the tree
        TreeNode node = root;
        // Traverse the tree
        while (node != null) {

            // Value of ancestor/parent node.
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }
        return null;
    }
}
