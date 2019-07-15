package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/15/19
 * Time: 3:46 PM
 * Description:
 */


public class _1026_MaximumDifferenceBetweenNodeandAncestor_ {
    int ans;
    public int maxAncestorDiff(TreeNode root) {
        ans = recursion(root, root.val, root.val);
        return ans;
    }
    public int recursion(TreeNode root, int mx, int min){
        if(root == null){
            return mx - min;
        }
        mx = Math.max(root.val, mx);
        min = Math.min(root.val, min);

        int left = recursion(root.left, mx, min);
        int right = recursion(root.right, mx, min);
        return Math.max(left, right);
    }

    //我的解决 也是很棒的
//    int ans = 0;
//    public int maxAncestorDiff(TreeNode root) {
//        if(root == null) return ans;
//        recur(root, root.val, root.val);
//        return ans;
//    }
//    public void recur(TreeNode root, int max, int min){
//        if(root == null)
//            return;
//        int ma = Math.max(root.val, max);
//        int mi = Math.min(root.val, min);
//        recur(root.left, ma, mi);
//        recur(root.right, ma, mi);
//        ans = Math.max(ans, Math.max(Math.abs(max - root.val), Math.abs(min - root.val)));
//    }
}
