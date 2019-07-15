package company;

import DataStructure.BinaryTree.TreeNode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/13/19
 * Time: 2:26 PM
 * Description:
 *
 * 3. 三哥, 一堆的BQ, 问你你做过的项目之类的, 之后出了一道题, 给你个binary tree, 横向打出所有节点, 要求如果两个节点的横向的index一样,
 * \要depth最深的那个, 然后print出这些节点(大概是这么意思). 比如
 */


public class _314_BinaryTreeVerticalOrderTraversal_FollowUp_BFS {
    public List<Integer> print(TreeNode root){
        HashMap<Integer, Integer> hm = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        Queue<Integer> qIndex = new LinkedList<>();
        qIndex.add(0);
        int min = 0, max = 0;
        while (!q.isEmpty()){
            TreeNode curNode = q.poll();
            int index = qIndex.poll();
            hm.put(index, curNode.val);
            if (curNode.left != null){
                q.add(curNode.left);
                qIndex.add(index - 1);
                min = Math.min(min, index - 1);
            }
            if (curNode.right != null){
                q.add(curNode.right);
                qIndex.add(index + 1);
                max = Math.max(max, index + 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = min; i <= max; i++ ){
            ans.add(hm.get(i));
        }
        return ans;
    }
}
