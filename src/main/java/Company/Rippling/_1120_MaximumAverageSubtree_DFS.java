package Company.Rippling;

import DataStructure.BinaryTree.TreeNode;

public class _1120_MaximumAverageSubtree_DFS {

    private double max;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root, 0);
        return max;
    }

    private int[] dfs(TreeNode node, int prevSum){
        if(node == null) return new int[]{0, 0};

        int curSum = prevSum + node.val, left[] = dfs(node.left, curSum), right[] = dfs(node.right, curSum);

        int totalSum = left[0] + right[0] + node.val, totalCount = left[1] + right[1] + 1;
        max = Math.max(max, (double) totalSum / totalCount);

        return new int[]{totalSum, totalCount};
    }
}
