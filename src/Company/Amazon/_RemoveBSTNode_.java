package Company.Amazon;

import DataStructure.BinaryTree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/11/19
 * Time: 11:33 PM
 * Description:
 */


public class _RemoveBSTNode_ {
    public static TreeNode cut(TreeNode root){
        int min = 6;
        int max = 16;
        root = cutL(root, min);
//        cutR(temp, max);
        return root;
    }
    public static TreeNode cutL(TreeNode temp, int min){
        TreeNode root = temp;
        if (root.val == min)
            root = null;
        while (root != null){
            if (root.left != null && root.left.val == min){
                root.left = null; break;
            }
            if (root.right != null && root.right.val == min){
                root.left = null;
                root.right = null;
                root.val = -1;
                break;
            }
            if (root.val > min)
                root = root.left;
            else if (root.val < min)
                root = root.right;
        }
        return temp;
    }

    public static TreeNode cutR(TreeNode temp, int max){
        TreeNode root = temp;
        if (root.val == max)
            root = null;
        while (root != null){
            if (root.right != null && root.right.val == max){
                root.left = null; break;
            }
            if (root.right != null && root.right.val == max){
                root.left = null;
                root.right = null;
                root.val = -1;
                break;
            }
            if (root.val > max)
                root = root.left;
            else if (root.val < max)
                root = root.right;
        }
        return temp;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.left.left.right = new TreeNode(6);
        cut(root);
    }

}
