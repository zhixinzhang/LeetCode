package Company.Amazon;

import DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/19/19
 * Time: 10:58 AM
 * Description:
 https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/discuss/143798/1ms-beat-100-simple-Java-dfs-using-hashmap-with-explanation * Its very classic tree problem, use dfs and bfs together
 *
 * 两次dfs 解决
 */


public class _863_AllNodesDistanceKinBinaryTree_DFS_BFS {
    
    public static void main(String[] args){

    }

    static Map<TreeNode, Integer> path = new HashMap<>();
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        findpath(root, target);
        List<Integer> res = new ArrayList<>();
        dfs(root, target, K, path.get(root), res);
        return res;
    }

    public static int findpath(TreeNode root, TreeNode target){
        if (root == null)
            return -1;
        if (root.val == target.val){
            path.put(root, 0);
            return 0;
        }
        int left = findpath(root.left, target);
        if (left >= 0){
            path.put(root, left+1);
            return left+1;
        }
        int right = findpath(root.right, target);
        if (right >= 0){
            path.put(root, right+1);
            return right+1;
        }
        return -1;
    }

    public static void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res){
        if (root == null) return;
        if (path.containsKey(root))
            length = path.get(root);
        if (length == K){
            res.add(root.val);
        }
        dfs(root.left, target, K,length+1, res);
        dfs(root.right, target, K, length+1, res);

    }
}
