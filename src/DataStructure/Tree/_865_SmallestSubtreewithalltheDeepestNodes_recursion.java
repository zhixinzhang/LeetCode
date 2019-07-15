package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/31/19
 * Time: 1:14 AM
 * Description:
 */


public class _865_SmallestSubtreewithalltheDeepestNodes_recursion {
    public TreeNode subtreeWithAllDeepest_mysolution(TreeNode root) {
        if (root == null) return root;
        TreeNode[] res = recur(root);
        return res[1];
    }

    private TreeNode[] recur(TreeNode root){
        if (root == null) return new TreeNode[]{new TreeNode(0), new TreeNode(0)};
        TreeNode[] l = recur(root.left);
        TreeNode[] r = recur(root.right);

        int l_level = l[0].val;
        int r_level = r[0].val;
        int level = Math.max(l_level, r_level) + 1;
        if (l_level == r_level)
            return new TreeNode[]{new TreeNode(l_level+1), new TreeNode(Math.max(l[1].val, r[1].val))};
        return l_level > r_level ? new TreeNode[]{new TreeNode(level), l[1]} : new TreeNode[]{new TreeNode(level), r[1]};
    }



    public int depth(TreeNode root,HashMap<TreeNode,Integer> map){
        if(root == null ) return 0;
        if( map.containsKey(root) ) return map.get(root);
        int max = Math.max(depth(root.left,map),depth(root.right,map))+1;
        map.put(root,max);
        return max;
    }
    public TreeNode dfs(TreeNode root, HashMap<TreeNode,Integer> map){
        int left =  depth(root.left,map);
        int right = depth(root.right,map);
        if( left  == right ) return root;
        if( left > right ) return dfs(root.left,map);
        return dfs(root.right,map);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if( root == null ) return null;
        HashMap<TreeNode,Integer> map = new HashMap<>();
        depth(root,map);
        return dfs(root,map);
    }


//    public TreeNode subtreeWithAllDeepest(TreeNode root) {
//        return recur(root).getValue();
//    }
//
//    public Pair<DataStructure.Integer, TreeNode> recur(TreeNode root){
//        if (root == null) return new Pair(0, null);
//        Pair<DataStructure.Integer, TreeNode> l = deep(root.left), r = deep(root.right);
//
//        int d1 = l.getKey(), d2 = r.getKey();
//        return new Pair(Math.max(d1, d2) + 1, d1 == d2 ? root : d1 > d2 ? l.getValue() : r.getValue());
//    }
}
