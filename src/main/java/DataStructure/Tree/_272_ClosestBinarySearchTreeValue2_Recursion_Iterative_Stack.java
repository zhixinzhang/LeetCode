package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/26/2021 12:06 AM
 * <p>
 * Source Link: https://leetcode.com/problems/closest-binary-search-tree-value-ii/discuss/70511/AC-clean-Java-solution-using-two-stacks/72757
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class _272_ClosestBinarySearchTreeValue2_Recursion_Iterative_Stack {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(11);

        closestKValues(root, 7.1,3);
    }

    // O(k + log N)

    public List<Integer> closestKValuesBest(TreeNode root, double target, int k) {
        List<Integer> result = new LinkedList<Integer>();
        // populate the predecessor and successor stacks
        Stack<TreeNode> pred = new Stack<TreeNode>();
        Stack<TreeNode> succ = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null) {
            if (target <= curr.val) {
                succ.push(curr);
                curr = curr.left;
            } else {
                pred.push(curr);
                curr = curr.right;
            }
        }
        while (k > 0) {
            if (pred.empty() && succ.empty()) {
                break;
            } else if (pred.empty()) {
                result.add( getSuccessor(succ) );
            } else if (succ.empty()) {
                result.add( getPredecessor(pred) );
            } else if (Math.abs(target - pred.peek().val) < Math.abs(target - succ.peek().val)) {
                result.add( getPredecessor(pred) );
            } else {
                result.add( getSuccessor(succ) );
            }
            k--;
        }
        return result;
    }

    private int getPredecessor(Stack<TreeNode> st) {
        TreeNode popped = st.pop();
        TreeNode p = popped.left;
        while (p != null) {
            st.push(p);
            p = p.right;
        }
        return popped.val;
    }

    private int getSuccessor(Stack<TreeNode> st) {
        TreeNode popped = st.pop();
        TreeNode p = popped.right;
        while (p != null) {
            st.push(p);
            p = p.left;
        }
        return popped.val;
    }

    // iterative  O(N)
    static LinkedList<Integer> path = new LinkedList<>();
    public static List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curt = root;
        while (curt != null){
            stack.push(curt);
            curt = curt.left;
        }
        while (!stack.isEmpty()){
            curt = stack.pop();
            if (res.size() == k){
                if (Math.abs(curt.val - target) >= Math.abs(res.getFirst() - target)){
                    break;
                } else {
                    res.removeFirst();
                }
            }
            res.add(curt.val);
            if (curt.right != null){
                curt = curt.right;
                while (curt != null){
                    stack.push(curt);
                    curt = curt.left;
                }
            }
        }
        return res;
    }

    // O(n) + O(n) time
    public static List<Integer> closestKValues_Recursive(TreeNode root, double target, int k) {
        Deque<Integer> dq = new LinkedList<>();

        inorder(root, dq);
        while (dq.size() > k){
            if (Math.abs(dq.peekFirst() - target) > Math.abs(dq.peekLast() - target)) {
                dq.pollFirst();
            } else {
                dq.pollLast();
            }
        }
        return new ArrayList<>(path);
    }

    private static void inorder(TreeNode root, Deque<Integer> dq){
        if (root == null) {
            return;
        }
        inorder(root.left, dq);
        dq.add(root.val);
        inorder(root.right, dq);
    }
}
