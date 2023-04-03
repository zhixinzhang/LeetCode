package DataStructure.Tree;

import java.util.*;
import Company.Google.TreeNode;

// https://leetcode.com/problems/balance-a-binary-search-tree/solutions/3315556/easiest-solution-full-beginner-level-code/?languageTags=java
/**
 * Intuition
InOrder Sequence
Conversion of ArrayList into Balanced BST.
return BST
 * 
 * 
*/

public class _1382_BalanceABinarySearchTree_Inorder {
    public static void getInOrder(TreeNode root, ArrayList<Integer> inorder){
        if(root==null){
            return;
        }
        getInOrder(root.left,inorder);
        inorder.add(root.val);
        getInOrder(root.right,inorder);
    }
    public static TreeNode CreateBST(ArrayList<Integer> inorder, int left, int right) {
        if (left > right) return null;
        int m = (right + left) / 2;
        TreeNode root = new TreeNode(inorder.get(m));
        root.left = CreateBST(inorder, left, m - 1);
        root.right = CreateBST(inorder, m+ 1, right);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInOrder(root,inorder);
        root = CreateBST(inorder,0,inorder.size()-1);
        return root;
    }
}
