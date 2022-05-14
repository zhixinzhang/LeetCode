package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/28/19
 * Time: 6:19 PM
 * Description:
 */


public class _965_UnivaluedBinaryTree_Recur {
    static HashSet<Integer> cache = new HashSet<>();
    public static void main(String[] args){
        TreeNode r = new TreeNode(2);
        r.left = new TreeNode(2);
        r.left.right = new TreeNode(2);
        r.left.left = new TreeNode(5);
        r.right = new TreeNode(2);
        r.right.left = new TreeNode(2);
        isUnivalTree(r);
    }
    public static boolean isUnivalTree(TreeNode root) {
        recur(root, cache);
        if(cache.size() <= 1)
            return true;
        else
            return false;
    }

    public static void recur(TreeNode root, HashSet<Integer> cache){
        if(root == null) return;
        cache.add(root.val);
        recur(root.left, cache);
        recur(root.right, cache);
    }


    public boolean isUnivalTree_(TreeNode root) {
        HashSet<Integer> cache = new HashSet<>();
        return recur_(root, cache);
    }

    public boolean recur_(TreeNode root, HashSet<Integer> cache){
        if(root == null)
            return cache.size() <= 1 ? true : false;
        cache.add(root.val);
        boolean r1 = recur_(root.left, cache);
        boolean r2 = recur_(root.right, cache);
        return  r1 && r2;
    }
}
