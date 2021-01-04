package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/1/19
 * Time: 10:31 PM
 * Description:  https://leetcode.com/problems/closest-leaf-in-a-binary-tree/
 * 兩種解法
 * 1. 把binary tree 轉成 graph Instead of a binary tree, if we converted the tree to a general graph, we could find the shortest path to a leaf using breadth-first search.
 *
 * Time Complexity: O(N)O(N) where NN is the number of nodes in the given input tree. We visit every node a constant number of times.
 *
 * Space Complexity: O(N)O(N), the size of the graph.
 *
 */


public class _742_ClosestLeafinaBinaryTree_BFS_DFS {
    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        // build graph
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        buildGraphDfs(root, k, graph, queue);
        visited.add(k);

        while (!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if (currentNode.left == null && currentNode.right == null) {
                return currentNode.val;
            }

            for (TreeNode nei: graph.get(currentNode)) {
                if (!visited.contains(nei.val)) {
                    visited.add(nei.val);
                    queue.add(nei);
                }
            }
        }
        throw  null;
    }

    private void buildGraphDfs(TreeNode root, int target, Map<TreeNode,  List<TreeNode>> graph, Queue<TreeNode> queue){
        if (root.val == target) {
            queue.add(root);
        }

        if (root.left != null) {
            graph.putIfAbsent(root.left, new ArrayList<>());
            graph.get(root.left).add(root);
            buildGraphDfs(root.left, target, graph, queue);
        }

        if (root.right != null) {
            graph.putIfAbsent(root.right, new ArrayList<>());
            graph.get(root.right).add(root);
            buildGraphDfs(root.right, target, graph, queue);
        }
    }

}
