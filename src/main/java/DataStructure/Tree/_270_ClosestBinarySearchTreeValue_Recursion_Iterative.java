package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/25/2021 11:38 PM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class _270_ClosestBinarySearchTreeValue_Recursion_Iterative {
    public int closestValue(TreeNode root, double target) {
        return closet(root, target, root.val);
    }

    // recursion
    private int closet(TreeNode root, double target, int preValue){
        if (root == null) {
            return preValue;
        }

        if (Math.abs(root.val - target) < Math.abs(preValue - target)) {
            preValue = root.val;
        }

        if (root.val < target) {
            preValue = closet (root.right, target, preValue);
        } else if (root.val == target){
            return preValue;
        } else if (root.val > target){
            preValue = closet(root.left, target, preValue);
        }

        return preValue;
    }

    // iterative
    public int closestValue_iter(TreeNode root, double target) {
        int prevVal = root.val;
        while (root != null){
            prevVal = Math.abs(prevVal - target) < Math.abs(root.val - target) ? prevVal : root.val;
            if (root.val == target) {
                return root.val;
            }

            root = root.val < target ? root.right : root.left;
        }

        return prevVal;
    }
}
