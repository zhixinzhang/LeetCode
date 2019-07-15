package company.PG;
import java.util.*;
/**
Given a string that contains ternary expressions. The expressions may be nested, task is convert the given ternary expression to a binary DataStructure.Tree.
Examples:
Input :  string expression =   a?b:c 
Output :        a
              /  \
             b    c
Input : expression =  a?b?c:d:e
Output :     a
           /  \
          b    e
        /  \
       c    d
*/
//  https://www.geeksforgeeks.org/convert-ternary-expression-binary-tree/
/**
Idea is that we traverse a string make first character as root and do following step recursively .
1. If we see Symbol ‘?’
…….. then we add next character as the left child of root.
2. If we see Symbol ‘:’
…….. then we add it as the right child of current root.
do this process until we traverse all element of “String”.

Below c++ implementation of above idea
**/
public class _ConvertTernaryExpressiontoaBinaryTree_preorder{

    public static TreeNode tenaryToTree_stack(String s) {
        if (s.length() == 0)
            return null;

        TreeNode root = new TreeNode(s.charAt(0));
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                TreeNode node = stack.peek();
                node.left = new TreeNode(s.charAt(i + 1));
                stack.push(node.left);
            } else if (s.charAt(i) == ':') {
                stack.pop();
                TreeNode node = stack.pop();
                node.right = new TreeNode(s.charAt(i + 1));
                stack.push(node.right);
            }
        }

        return root;
    }
    // Class to represent DataStructure.Tree node
    // a?(b?d:e):(c)   recursion
    public static TreeNode tenaryToTree_recursion(String s) {
        if (s.length() == 0) return null;
        int index1 = s.indexOf('?'), index2 = s.lastIndexOf(':');
        char val = s.charAt(0);
        TreeNode root = new TreeNode(val);
        if (index1 == -1) return root;
        root.left = tenaryToTree_recursion(s.substring(index1 + 1, index2));
        root.right = tenaryToTree_recursion(s.substring(index2 + 1));
        return root;

    }


    public static String treeToTenary_recur(TreeNode root){
        if (root == null)
            return "";
        String res = String.valueOf(root.val);
        String left = treeToTenary_recur(root.left);
        String right = treeToTenary_recur(root.right);

        if (left == "" && right == "")
            return res;
        if (left == "")
            return res + "?" + ":" + right;
        if (right == "")
            return res+" " + "?" +left+":";
        return res + "?" + left +":"+right;

    }
    /**
     *                  a
     *              b         e
     *          c      d           g
     * */

    public static void main(String[] args) {
        String test = "a?b?d:e:c";
        TreeNode root = new TreeNode('a');
        root.left = new TreeNode('b');
        root.left.left = new TreeNode('c');
        root.left.right = new TreeNode('d');
        root.right = new TreeNode('e');
        root.right.right = new TreeNode('g');
        String cc = treeToTenary_recur(root);
        TreeNode node = tenaryToTree_recursion(test);
    }

    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {

        }
        public TreeNode(char val) {
            this.val = val;
        }
}

}