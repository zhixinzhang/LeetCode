//package DataStructure.BinaryTree;
//
//import java.util.Deque;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Stack;
//
///**
// * Created by zhang on 2017/9/27.
// */
///**first time create TreeNode use recursion
// *each level use queue to judge is or nor symme
// *
// * */
//
///**虽然我用的是bfs 但并不是一层一层对比的**/
//
//public class _101_RecursionSymmetricTree {
//    public static boolean isSymmetric_BFS(TreeNode root) {
//        if (root == null)
//            return true;
//        Deque<TreeNode> deque = new LinkedList<>();
//        deque.offerFirst(root.left);
//        deque.offerLast(root.right);
//        while (!deque.isEmpty()){
//            TreeNode left = deque.pollFirst();
//            TreeNode right = deque.pollLast();
//            if (left == null && right == null){
//                continue;
//            }
//            if (left == null || right == null || left.val != right.val){
//                return  false;
//            }
//            deque.offerFirst(left.right);
//            deque.offerFirst(left.left);
//            deque.offerLast(right.left);
//            deque.offerLast(right.right);
//        }
//        return true;
//    }
//
//    public boolean isSymmetric_Stack(TreeNode root) {
//
//        if (root == null) return true;
//        Stack<TreeNode> s = new Stack<>();
//        s.push(root.left);
//        s.push(root.right);
//        while (!s.isEmpty()) {
//            TreeNode p = s.pop ();
//            TreeNode q = s.pop ();
//            if (p == null && q == null) continue;
//            if (p == null || q == null) return false;
//            if (p.val != q.val) return false;
//            s.push(p.left);
//            s.push(q.right);
//            s.push(p.right);
//            s.push(q.left);
//        }
//        return true;
//    }
//
//
//    public static void main(String args[]){
//        int[] arr = {2,2,3,4,4,3};
//        TreeNode treeNode = new TreeNode(1);
//        Queue<TreeNode> q = new LinkedList();
//        q.add(treeNode);
//        Boolean res = isSymmetric_BFS(treeNode);
//    }
//}
