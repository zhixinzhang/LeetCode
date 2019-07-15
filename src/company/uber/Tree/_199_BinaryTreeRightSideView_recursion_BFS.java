package company.uber.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhang on 2018/9/20.
 */
public class _199_BinaryTreeRightSideView_recursion_BFS {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(11);

        System.out.println(rightSide(root));
    }
    // 只返回右面第一层树叶
    static List<Integer> res = new ArrayList<>();
    public static List<Integer> rightSide(TreeNode root){
        if (root == null)
            return res;
        res.add(root.val);
        rightSide(root.right);
        return res;
    }

    //从右往左看 看右面的树叶  recurion
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }

    public List<Integer> rightSideView_BFS(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root == null)
            return result;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            while(size>0){
                TreeNode node = que.poll();
                if(size==1)
                    result.add(node.val);
                if(node.left != null)
                    que.add(node.left);
                if(node.right != null)
                    que.add(node.right);
                size--;
            }
        }
        return result;

    }
}
