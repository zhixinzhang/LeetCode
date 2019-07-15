package DataStructure.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhang on 2017/2/7.
 */
//先序遍历  用stack
public class BinaryTreePreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();

        if(root == null)
            return returnList;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.empty()){
            TreeNode n = stack.pop();
            returnList.add(n.val);

            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            }

        }
        return returnList;
    }




    public static  void main(String args[]){
        List<String>  nodes = new ArrayList<>();
        int level = 1;
        TreeNode treeNodeFirst = new TreeNode(Integer.parseInt(nodes.get(0)));
        TreeNode treeNode = null;
        treeNode = treeNode.productTree(treeNodeFirst, nodes,level);

    }
}
