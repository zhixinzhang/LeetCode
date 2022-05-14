package DataStructure.Tree;

import google.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/27/19
 * Time: 4:26 PM
 * Description:
 *
 * https://www.1point3acres.com/bbs/thread-527722-1-1.html
 *
 * 5. BST给你个node，返回小于这个node的最大的node。。还一个题忘了。。印象中LC原题。。不难
 * 考虑各种情况
 */


public class findGreaterNodeThanTarget_recur {
    public int find(TreeNode root, int target){
        return recur(root, root.val, target);
    }
    public int recur(TreeNode root, int prev_small, int target){
        if(root == null)
            return -1;
        if (root.val < target)
            return recur(root.right, root.val, target);
        else if (root.val > target)
            return recur(root.left, prev_small, target);
        if (root.left != null){
            root = root.left;
            while (root.right != null){
                root = root.right;
            }
            return root.val;
        }
        return prev_small > root.val ? -1 : prev_small;
    }
}
