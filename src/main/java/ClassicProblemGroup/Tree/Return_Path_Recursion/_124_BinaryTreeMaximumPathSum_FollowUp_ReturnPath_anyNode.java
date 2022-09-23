package ClassicProblemGroup.Tree.Return_Path_Recursion;


import google.TreeNode;

import java.util.*;
/**
 * Created by zhang on 2018/1/29.
 */
///*Follow up: 输出sum最大的Path 任意两个节点*/
//1.find maxsum path -- recursion and from bottom to top fo count max sum
//2. remember the path and print List<String> to store pre travel path
//                          1
//                      10      9                      2 - 10 - 3 or 2- 10 - 1 --
//                    2    3  1    5                  when i find maxsum each node return
public class _124_BinaryTreeMaximumPathSum_FollowUp_ReturnPath_anyNode {
    static Node maxSum = new Node(Integer.MIN_VALUE, new ArrayList<>());
    static class Node {
        int curSum;
        List<String> curPath;
        public Node(int curSum, List<String> curPath) {
            this.curSum = curSum;
            this.curPath = new ArrayList<>(curPath);
        }

        public void print() {
            System.out.println("The max Sum is " + curSum);
            System.out.println("The max Sum path is " + String.join("->", curPath));
        }
    }
    public static Node maxSumPath(TreeNode root) {
        helper(root);
        return maxSum;
    }
    private static Node getMaxNode(Node left, Node right) {
        if (left.curSum > right.curSum) return left;
        return right;
    }
    private static Node helper(TreeNode root) {
        if (root == null) return new Node(0, new ArrayList<>());

        Node left = getMaxNode(helper(root.left), new Node(0, new ArrayList<>()));
        Node right = getMaxNode(helper(root.right), new Node(0, new ArrayList<>()));
        List<String> temp = new ArrayList<>();
        temp.addAll(left.curPath);
        temp.add(root.val + "");

        Collections.reverse(right.curPath);         //方向一致

        temp.addAll(right.curPath);
        Collections.reverse(right.curPath);
        maxSum = getMaxNode(maxSum, new Node(left.curSum + right.curSum + root.val, temp));

        if (left.curSum >= right.curSum) {
            left.curSum += root.val;
            left.curPath.add(root.val + "");
            return left;
        } else {
            right.curSum += root.val;
            right.curPath.add(root.val + "");
            return right;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(13);
        root1.left.right.left = new TreeNode(5);
        root1.right.left = new TreeNode(2);
        root1.right.left.right = new TreeNode(7);
        root1.right.right = new TreeNode(-5);
        Node res1 = maxSumPath(root1);
        res1.print();
        //System.out.println(res1.print());
    }
}
