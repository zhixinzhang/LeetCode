package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/25/19
 * Time: 2:46 PM
 * Description:
 *          1
 *       2      5
 *     3    4
 *
 *  3 2 4 1 5
 *
 */



public class _Inorder_Compare {
    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.right = new TreeNode(4);
        boolean a = compare2(root1, root2);
        int c  =0 ;
    }
    static List<Integer> ans = new ArrayList<>();
    static int index = 0;
    public void inorder(TreeNode root){
        if (root == null)
            return;
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }
    public static boolean compare2(TreeNode root, TreeNode root2){
        if (root == null && root2 == null)  return true;
        if (root == null && root2 != null)  return false;
        if (root != null && root2 == null)  return false;
        boolean left = compare2(root.left, root2.left);
        if (root.val != root2.val)  return false;
        boolean right = compare2(root.right, root2.right);
        return left && right;
    }
    public static boolean compare(TreeNode root){
        if (root == null)
            return true;
        boolean left = compare(root.left);
//        ans.remove(0);
        if(index >= ans.size() || root.val != ans.get(index))
            return false;
        index++;
        boolean right = compare(root.right);
        return left && right;
    }
}
