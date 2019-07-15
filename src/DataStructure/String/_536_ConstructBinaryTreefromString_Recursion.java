package DataStructure.String;

import DataStructure.BinaryTree.TreeNode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/24/19
 * Time: 9:55 AM
 * Description:
 */


public class _536_ConstructBinaryTreefromString_Recursion {
    // 4(2(3)(1))(6(5))
    // 4(23(1))(6)
    public static void main(String[] args){
        str2tree("4(2(3)(1))(6(5))");
    }
    // recursion divided conquer
    public static TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int firstLeft = s.indexOf('(');
        if (firstLeft == -1) {
            return new TreeNode(Integer.parseInt(s));
        }
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, firstLeft)));
        int count = 0, i = firstLeft;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count == 0) {
                root.left = str2tree(s.substring(firstLeft + 1, i));
                break;
            }
            i++;
        }
        if (i != s.length() - 1) {
            root.right = str2tree(s.substring(i + 2, s.length() - 1));
        }
        return root;
    }
    public static TreeNode str2tree_stack(String s) {
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0, j = i; i < s.length(); i++, j = i){
            char c = s.charAt(i);
            if(c == ')')    stack.pop();
            else if(c >= '0' && c <= '9' || c == '-'){
                while(i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                TreeNode currentNode = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
                if(!stack.isEmpty()){
                    TreeNode parent = stack.peek();
                    if(parent.left != null)    parent.right = currentNode;
                    else parent.left = currentNode;
                }
                stack.push(currentNode);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }
}
