package Company.uber.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/9/17.
 */
public class _230_KthSmallestElementinaBST_ {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        kthBiggest(root,4);
    }
    // O(n) time O(n) space
    static List<Integer> order = new ArrayList<>();
    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        inorder(root,k);
        return order.get(k-1);
    }
    public static  void inorder(TreeNode root,int k){
        if (order.size() > k)
            return;
        if (root == null)
            return;
        inorder(root.left,k);
        order.add(root.val);
        inorder(root.right,k);
    }

    // O(n) time O(1)space
    static int count;
    static int res;
    public int kthSmallest_(TreeNode root, int k) {
        count = 0;
        res = -1;
        if(root == null) return 0;
        recur_(root, k);
        return res;
    }
    public void recur_(TreeNode root, int k){
        if(root == null) return;
        recur(root.left, k);
        count++;
        if(count == k){
            res = root.val;
            return;
        }
        recur(root.right, k);
    }


    public static int kthBiggest(TreeNode root, int k){
        if (root == null)
            return -1;
        int a =  recur(root, k);
        return a;
    }
    public static int recur(TreeNode root, int k){
        if (root.right != null && count < k)
            recur(root.right, k);
        count++;
        if (count == k)
            res = root.val;
        if (root.left != null && count < k)
            recur(root.left,k);
        return res;
    }
}
