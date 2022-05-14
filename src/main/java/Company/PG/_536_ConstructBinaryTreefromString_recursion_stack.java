package Company.PG;
import java.util.*;
/**
 * Created by zhang on 2018/1/28.
 */
//原题 536 Input: "4(2(3)(1))(6(5))"
//这里是变种 (DataStructure.Tree 1 (Tree2 (DataStructure.Tree 4 null null) null)(DataStructure.Tree 3 (DataStructure.Tree null)(DataStructure.Tree 6 null null)))
//we travel the tree by preorder  root -> left -> right
public class _536_ConstructBinaryTreefromString_recursion_stack {
    //原题没有Tree的  recursion 方法
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        int firstParen = s.indexOf("(");
        int val = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
        TreeNode cur = new TreeNode(val);
        if (firstParen == -1) return cur;
        int start = firstParen, leftParenCount = 0;
        for (int i=start;i<s.length();i++) {
            if (s.charAt(i) == '(') leftParenCount++;
            else if (s.charAt(i) == ')') leftParenCount--;
            if (leftParenCount == 0 && start == firstParen) {
                cur.left = str2tree(s.substring(start+1,i));
                start = i+1;
            }
            else if (leftParenCount == 0) cur.right = str2tree(s.substring(start+1,i));
        }
        return cur;
    }
    //原题  stack方法
    public TreeNode str2tree_stack(String s) {
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0, j = i; i < s.length(); i++, j = i){
            char c = s.charAt(i);
            if(c == ')')    stack.pop();
            else if(c >= '0' && c <= '9' || c == '-'){
                while(i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                TreeNode currentNode = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
                if(!stack.isEmpty()){
                    TreeNode parent = stack.peek();
                    if(parent.left != null)
                        parent.right = currentNode;
                    else parent.left = currentNode;
                }
                stack.push(currentNode);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }

    //company.PG
    //(DataStructure.Tree 1 (DataStructure.Tree 2 (DataStructure.Tree 4 null (DataStructure.Tree 5 null null)) null )(DataStructure.Tree 3 null (DataStructure.Tree 6 null null)))
    //19 (2 (4 n (5 n n)))(3 n (6 n n))
    //1. remove all tree key
    // first find root.val and go left when left is null go right
    // when we touch the leaf node return
    public static TreeNode str2tree_recursion_follow(String s){
        s=s.trim();
        if (s == null || s.length() == 0) return null;
        // find root value
        String rootS = s.split(" ")[0];
        int num = 0;
        for (int i = 0; i<rootS.length();i++){
            if (Character.isDigit(rootS.charAt(i))){
                num = num * 10 + rootS.charAt(i) - '0';
            }
        }
        TreeNode cur = new TreeNode(num);           // find root node
        String[] arr = s.split(" ");
        int firstParen = s.indexOf("(");
//        if (firstParen == -1) return cur;
        int start = firstParen, leftParenCount = 0;
        for (int i=start;i<s.length();i++) {
            if (arr.length >= 3){
                if (arr[1].equals("(")){             // go deep left child
                    cur.left = str2tree_recursion_follow(s.substring(start+1,s.length()));
                    start = i+1;
                }else if (arr[1].equals("n") && arr[2].charAt(0)== 'n'){
                    return cur;
                }else if (arr[1].equals("n") && arr[2].charAt(0) != 'n'){       //right child
                    cur.right = str2tree_recursion_follow(s.substring(start+1,s.length()));
                    return cur;
                }
            }
        }
        return cur;
    }


    public static void main(String[] args){
        //DataStructure.Tree 1 (DataStructure.Tree 2 (DataStructure.Tree 4 null (DataStructure.Tree 5 null null)) null ) (DataStructure.Tree 3 null (DataStructure.Tree 6 null null))
        String s = "(DataStructure.Tree 1 (DataStructure.Tree 2 (DataStructure.Tree 4 null (DataStructure.Tree 5 null null)) null) (DataStructure.Tree 3 null (DataStructure.Tree 6 null null)))";
        String or = "1(2 (4 null))";
        String c = s.substring(1,s.length()-1);
        c = c.replaceAll("Tree","");
        c = c.replaceAll("null","n");
        str2tree_recursion_follow(c);
    }

//1(2 (4 n (5 n n)))(3 n (6 n n))
// stack '(' push      ')' pop
//how to know left or right child
    static TreeNode nullNode = new TreeNode();
    public static TreeNode str2tree_static_follow(String s){
        s = s.replaceAll("Tree","");
        s = s.replaceAll("null","n");
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0, j = i; i < s.length(); i++, j = i){
            char c = s.charAt(i);

            if(c == ')')
                stack.pop();
            else if(c >= '0' && c <= '9' || c == '-'){
                while(i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                //judge left child or right child
                TreeNode currentNode = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
                char bb = s.charAt(i);
                char bbb = s.charAt(i+2);
                if (bbb != 'n')
                    currentNode.left = new TreeNode(Integer.MAX_VALUE);     //left child not null
                else
                    currentNode.right = new TreeNode(Integer.MAX_VALUE);
                if(!stack.isEmpty()){
                    TreeNode parent = stack.peek();
                    if(parent.left != null && parent.left.val == Integer.MAX_VALUE)
                        parent.left = currentNode;
                    else
                        parent.right = currentNode;
                }
                stack.push(currentNode);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }

}
