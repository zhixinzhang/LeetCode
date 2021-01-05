package company.uber.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhang on 2018/9/20.
 *
 * 两种解法 一遍过 不难
 */
public class _199_BinaryTreeRightSideView_Recursion_BFS {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(11);

//        System.out.println(rightSideView_DFS(root));
    }
    public List<Integer> rightSideView_BFS(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int size = queue.size();

            while (!queue.isEmpty()){
                for (int i = 0; i < size; i ++){
                    TreeNode cur = queue.poll();
                    if (i + 1 == size) {    //the last treenode in current level
                        ans.add(cur.val);
                    }

                    if (cur.left != null) {
                        queue.add(cur.left);
                    }

                    if (cur.right != null) {
                        queue.add(cur.right);
                    }
                }

                size = queue.size();
            }

            return ans;
        }


    public List<Integer> rightSideView_DFS(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        int level = 1;
        ans.add(root.val);
        recurseRightSide(root, level, ans);
        return ans;
    }

    private void recurseRightSide(TreeNode root, int level, List<Integer> ans){

        if (ans.size() < level) {
            ans.add(root.val);
        }
        if (root.right != null) {
            recurseRightSide(root.right, level + 1, ans);
        }

        if (root.left != null) {
            recurseRightSide(root.left, level + 1, ans);
        }

    }

}
