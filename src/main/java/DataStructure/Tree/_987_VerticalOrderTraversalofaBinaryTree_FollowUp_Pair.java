//package DataStructure.Tree;
//
//import javafx.util.Pair;
//
//import java.util.*;
//
//
///**
// * @author Luke(New Man) Zhang
// * @Date 4/24/2021 9:25 PM
// * <p>
// * Description:
// * Similar task :
// * Key Point:
// *
// * Follow up
// * https://leetcode.com/discuss/interview-question/508157/Bloomberg-or-Phone-or-Vertical-Order-Traversal
// */
//
//public class _987_VerticalOrderTraversalofaBinaryTree_FollowUp_Pair {
//    static class TreeNode {
//        Character val;
//        TreeNode left;
//        TreeNode right;
//
//        public TreeNode(Character c){
//            this.val = c;
//            this.left = null;
//            this.right = null;
//        }
//    }
//
//    public static void main (String[] args){
//        TreeNode root = new TreeNode('r');
//        root.left = new TreeNode('e');
//        root.right = new TreeNode('t');
//        root.right.left = new TreeNode('e');
//        root.right.left.left = new TreeNode('c');
//        root.right.left.left.left = new TreeNode('s');
//        bfs(root);
//    }
//
//    private  static String bfs (TreeNode root){
//        if (root == null)
//            return "";
//
//        Pair<Integer, TreeNode> pair = new Pair<Integer, TreeNode>(0, root);
//        Map<Integer, List<TreeNode>> map = new HashMap<>();
//        map.put(0, new ArrayList<TreeNode>());
//        map.get(0).add(root);
//        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();
//        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//        queue.add(pair);
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++){
//                Pair<Integer, TreeNode> p = queue.poll();
//                int vol = p.getKey();
//                TreeNode curNode = p.getValue();
//
//                if (curNode.left != null) {
//                    queue.add(new Pair<>(vol - 1, curNode.left));
//                    map.putIfAbsent(vol - 1, new ArrayList<>());
//                    map.get(vol - 1).add(curNode.left);
//                    min = Math.min(max, vol - 1);
//                }
//
//                if (curNode.right != null) {
//                    queue.add(new Pair<>(vol + 1, curNode.right));
//                    map.putIfAbsent(vol + 1, new ArrayList<>());
//                    map.get(vol + 1).add(curNode.right);
//                    max = Math.max(min, vol + 1);
//                }
//
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = min; i <= max; i++){
//            List<TreeNode> nodes = map.get(i);
//            for (TreeNode node : nodes){
//                sb.append(node.val);
//            }
//        }
//
//        return sb.toString();
//    }
//}
