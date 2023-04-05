package Company.Grammly;
import java.util.*;

import Company.Google.TreeNode;

public class _404_SumofLeftLeaves_Queue_Recu {
    	//Queue
        public int sumOfLeftLeaves(TreeNode root) {
            if(root == null || root.left == null && root.right == null) return 0;
            int res = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            
            while(!queue.isEmpty()) {
                TreeNode curr = queue.poll();
    
                if(curr.left != null && curr.left.left == null && curr.left.right == null) 
                    res += curr.left.val;
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
    
            return res;
        }
        
        public int sumOfLeftLeaves_Recu(TreeNode root) {
    
         if(root == null) return 0;
            int ans = 0;
            if(root.left != null){
                if(root.left.left == null && root.left.right == null){
                    ans += root.left.val;
                }else{
                    ans += sumOfLeftLeaves(root.left);
                }
            }
    
            ans +=  sumOfLeftLeaves(root.right);
            
            return ans;
            }
}
