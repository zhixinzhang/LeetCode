package DataStructure.BinaryTree;

import java.util.HashMap;

/**
 * @author Luke(New Man) Zhang
 * @Date 2/4/2021 8:55 PM
 * <p>
 * Description:
 * Similar task : 560
 * Key Point:
 */

public class _437_PathSum3_Map_PreSum {
    int count = 0;
    int k;
    HashMap<Integer, Integer> h = new HashMap();

    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0);
        return count;
    }

    public void preorder(TreeNode node, int currSum) {
        if (node == null)
            return;

        // current prefix sum
        currSum += node.val;

        // here is the sum we're looking for
        if (currSum == k)
            count++;

        // number of times the curr_sum − k has occured already,
        // determines the number of times a path with sum k
        // has occured upto the current node
        count += h.getOrDefault(currSum - k, 0);

        // add the current sum into hashmap
        // to use it during the child nodes processing
        h.put(currSum, h.getOrDefault(currSum, 0) + 1);

        // process left subtree
        preorder(node.left, currSum);
        // process right subtree
        preorder(node.right, currSum);

        // remove the current sum from the hashmap
        // in order not to use it during
        // the parallel subtree processing
        h.put(currSum, h.get(currSum) - 1);
    }
}
