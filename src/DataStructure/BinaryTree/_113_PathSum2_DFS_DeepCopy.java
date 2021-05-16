package DataStructure.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luke(New Man) Zhang
 * @Date 2/3/2021 12:25 AM
 * <p>
 * Description: https://leetcode.com/problems/path-sum-ii/solution/
 * Key Point: . All we need to do here is to simply execute the depth first traversal and maintain two things along the way:
 *
 * A running sum of all the nodes traversed till that point in recursion and
 * A list of all those nodes
 *
 * Time Complexity: O(N^2)O(N
 * 2
 *  ) where NN are the number of nodes in a tree. In the worst case, we could have a complete binary tree and if that is the case, then there would be N/2N/2 leafs. For every leaf, we perform a potential O(N)O(N) operation of copying over the pathNodes nodes to a new list to be added to the final pathsList. Hence, the complexity in the worst case could be O(N^2)O(N
 * 2
 *  ).
 *
 * Space Complexity: O(N)O(N). The space complexity, like many other problems is debatable here. I personally choose not to consider the space occupied by the output in the space complexity. So, all the new lists that we create for the paths are actually a part of the output and hence, don't count towards the final space complexity. The only additional space that we use is the pathNodes list to keep track of nodes along a branch.
 */

public class _113_PathSum2_DFS_DeepCopy {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return ans;

        dfs(root, 0, targetSum, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(TreeNode root, int sum, int targetSum, List<Integer> curPath){
        if (root == null)
            return;

        sum += root.val;
        curPath.add(root.val);

        if (sum == targetSum && root.left == null && root.right == null){
            ans.add(new ArrayList<>(curPath));
        } else {
            dfs(root.left, sum, targetSum, curPath);
            dfs(root.right, sum, targetSum, curPath);
        }

        sum -= root.val;
        curPath.remove(curPath.size() - 1);
    }
}
