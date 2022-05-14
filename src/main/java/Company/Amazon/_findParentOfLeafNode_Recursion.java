package Company.Amazon;

import DataStructure.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/19/19
 * Time: 10:39 PM
 * Description:
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=517876
 *
 *  find out all leafnode parent
 *  find out all n th leafnode parent
 */


public class _findParentOfLeafNode_Recursion {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        findParent(root);
    }
    static List<TreeNode> ans = new ArrayList<>();
    public static void findParent(TreeNode root){
        if(root == null)
            return;
        recur(root, root.left);
        recur(root, root.right);
        System.out.print(ans);
    }
    public static void recur(TreeNode parent, TreeNode cur){
        if (cur == null) return;
        if(cur.left == null && cur.right == null){
            if (ans.size() == 0)
                ans.add(parent);
            else if (ans.get(ans.size() - 1).val != parent.val)
                ans.add(parent);
        }
        recur(cur, cur.left);
        recur(cur, cur.right);
    }

    public static void findParent_N(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        recur_n(root, root.left, dq, 3);
        recur_n(root, root.right, dq, 3);
    }

    public static void recur_n(TreeNode nParent, TreeNode cur, Deque<TreeNode> dq, int n){
        if (cur == null)
            return;
        if (dq.size() < n)
            dq.add(cur);
        else if (dq.size() == n){
            dq.pollFirst();
            dq.add(cur);
        }
        if (cur.left == null && cur.right == null && ans.get(ans.size() - 1).val != nParent.val)
            ans.add(nParent);
        recur_n(dq.peekFirst(), cur.left, dq, 3);
        recur_n(dq.peekFirst(), cur.right, dq, 3);
        dq.pollLast();
    }
}
