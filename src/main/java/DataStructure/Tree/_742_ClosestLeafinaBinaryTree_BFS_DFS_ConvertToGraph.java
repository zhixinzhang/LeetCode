package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Luke(New Man)
 * Date: 1/3/19
 * Time: 10:31 PM
 * Description:  https://leetcode.com/problems/closest-leaf-in-a-binary-tree/
 * 兩種解法
 * 1. 把binary tree 轉成 graph Instead of a binary tree, if we converted the tree to a general graph, we could find the shortest path to a leaf using breadth-first search.
 *
 * Time Complexity: O(N)O(N) where NN is the number of nodes in the given input tree. We visit every node a constant number of times.
 *
 * Space Complexity: O(N)O(N), the size of the graph.
 *
 * 2.  第二种解法 ： 还没测试， 创建一个新的node点， 然后有各种属性，用postorder遍历
 * 最后计算所有leaf node点到 k node点的距离
 */


public class _742_ClosestLeafinaBinaryTree_BFS_DFS_ConvertToGraph {
    // Solution 1 : convert to graph and use BFS
    public int findClosestLeaf_ConvertToGraph(TreeNode root, int k) {
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



    // Solution 2: build new Class and use postorder dfs
    List<TreeNode> path;
    Map<TreeNode, LeafResult> annotation;

    public int findClosestLeaf(TreeNode root, int k) {
        path = new ArrayList();
        annotation = new HashMap();

        dfs(root, k);

        int distanceFromTarget = path.size() - 1;
        int dist = Integer.MAX_VALUE;
        TreeNode leaf = null;
        for (TreeNode node: path) {
            LeafResult lr = closestLeaf(node);
            if (lr.dist + distanceFromTarget < dist) {
                dist = lr.dist + distanceFromTarget;
                leaf = lr.node;
            }
            distanceFromTarget--;
        }
        return leaf.val;
    }

    public boolean dfs(TreeNode node, int k) {
        if (node == null) {
            return false;
        } else if (node.val == k) {
            path.add(node);
            return true;
        } else {
            path.add(node);
            boolean ans = dfs(node.left, k);
            if (ans) return true;
            ans = dfs(node.right, k);
            if (ans) return true;
            path.remove(path.size() - 1);
            return false;
        }
    }

    public LeafResult closestLeaf(TreeNode root) {
        if (root == null) {
            return new LeafResult(null, Integer.MAX_VALUE);
        } else if (root.left == null && root.right == null) {
            return new LeafResult(root, 0);
        } else if (annotation.containsKey(root)) {
            return annotation.get(root);
        } else {
            LeafResult r1 = closestLeaf(root.left);
            LeafResult r2 = closestLeaf(root.right);
            LeafResult ans = new LeafResult(r1.dist < r2.dist ? r1.node : r2.node,
                    Math.min(r1.dist, r2.dist) + 1);
            annotation.put(root, ans);
            return ans;
        }
    }
}
class LeafResult {
    TreeNode node;
    int dist;
    LeafResult(TreeNode n, int d) {
        node = n;
        dist = d;
    }

}
