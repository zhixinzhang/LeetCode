package google.Tree;

import java.util.*;
/**
 * Created by zhang on 2018/6/5.
 * 找到一个树里的重复树
 * 先找到底层 从底层往后找 用string 记录路径
 * 用postorder
 * https://leetcode.com/problems/find-duplicate-subtrees/discuss/106011/Java-Concise-Postorder-Traversal-Solution
 * map 查重复
 */
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
public class _652_FindDuplicateSubtrees_Recursion_Map {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> res = new ArrayList<>();
            if (root == null)   return res;
            HashMap<String, Integer> hm = new HashMap<>();
            recur(root,hm,res);
            return res;
        }
    private String recur(TreeNode root, HashMap<String, Integer> hm, List<TreeNode> res){
        if (root == null) return "";
        String curS = root.val + " " + recur(root.left, hm, res) + " " + recur(root.right, hm, res);
        // 记住有几个 只有一个才加入算重复的  细节啊
        if (hm.containsKey(curS) && hm.get(curS) == 1)
            res.add(root);
        hm.put(curS, hm.getOrDefault(curS,0)+1);
        return curS;
    }
}
