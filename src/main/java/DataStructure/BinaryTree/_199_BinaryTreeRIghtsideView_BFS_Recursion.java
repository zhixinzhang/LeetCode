package DataStructure.BinaryTree;

import java.util.*;

/**
 * Created by zhang on 2017/2/10.
 */
public class _199_BinaryTreeRIghtsideView_BFS_Recursion {

    //bfs
    public List<Integer> rightSideView_BFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int last = 0;
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                last = cur.val;
                if(cur.left != null)
                    q.add(cur.left);

                if(cur.right != null)
                    q.add(cur.right);
            }
            res.add(last);
        }
        return res;
    }


    // recursion
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView_Recur(TreeNode root) {
        if(root == null)
            return res;
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int depth){
        if(root == null)
            return;

        if(depth == res.size())
            res.add(root.val);

        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }


    HashMap<Integer, Integer> map = new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        inorder(root, 0);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < map.size(); i++){
            ans.add(map.get(i));
        }
        return ans;
    }
    public void inorder(TreeNode root, int depth){
        if(root == null)
            return;
        inorder(root.left, depth+1);
        map.put(depth,  root.val);
        inorder(root.right, depth + 1);
    }

}
