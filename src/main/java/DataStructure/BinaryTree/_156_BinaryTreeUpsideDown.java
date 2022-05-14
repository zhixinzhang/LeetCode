package DataStructure.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zhang on 2017/9/28.
 */
/**两种解法  第一种用stack 存储所有左侧的子节点 然后根据每个左节点  改变三角形三个节点的指针方向  O(n)
 * 第二种 用递归recursion的方法  找到subproblem 然后递归  O(n)
 *
 * */
public class _156_BinaryTreeUpsideDown {
    // 1 ues stack
    public static TreeNode upsideDownBinaryTree(TreeNode root){
        if (root == null){
            return root;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null){                               //pull left nodes into stack
            stack.offerLast(root);
            root = root.left;
        }
        TreeNode newRoot = stack.pollLast();
        TreeNode cur = newRoot;

        while (!stack.isEmpty()){                           // change pointers
            TreeNode oriParent = stack.pollLast();
            cur.right = oriParent;
            cur.left = oriParent.right;

            cur = oriParent;
            oriParent.left = null;
            oriParent.right = null;
        }

        return newRoot;
    }

    //2 use recursion
//    public static TreeNode upsideDownBinaryTree(TreeNode root){
//        if (root == null || root.left == null ) {
//            return root;
//        }
//        // assume all lowers are handled
//        TreeNode newRoot = upsideDownBinaryTree(root.left);
//        //handle current level
//        root.left.left = root.right;
//        root.left.right = root;
//
//        root.left = null;
//        root.right = null;
//
//        return newRoot;
//    }

    public static void main(String[] args){
        int[] arr = {2,3,4,5};
        zzx_CBTree zz = new zzx_CBTree();
        TreeNode treeNode = zz.cbTree(arr);
        int a =0;
    }

}
