package Company.LinkedIn;
import DataStructure.BinaryTree.TreeNode;

import java.util.*;

public class _671_SecondMinimumNodeInaBinaryTree_PreOrder{
    // DFS
    int min1;
    long ans = Long.MAX_VALUE;

    public void dfs(TreeNode root) {
        if (root != null) {
            if (min1 < root.val && root.val < ans) {
                ans = root.val;
            } else if (min1 == root.val) {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        min1 = root.val;
        dfs(root);
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }


    // BFS
    public int findSecondMinimumValue_BFS(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root); int min=root.val; boolean flag=true;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                TreeNode curr=q.poll();
                if(min<curr.val && flag){ // For the first time, find the greater value than root node
                    min=Math.max(curr.val, min);
                    flag=false;
                }
                if(curr.val!=root.val){ // find smaller element(IF EXIST) than current minimum and it should NOT be equal to root value
                    min=Math.min(curr.val, min);
                }
                if(curr.left!=null){q.add(curr.left);}
                if(curr.right!=null){q.add(curr.right);}
            }
        }
        return (min==root.val) ? -1 : min;
    }

}