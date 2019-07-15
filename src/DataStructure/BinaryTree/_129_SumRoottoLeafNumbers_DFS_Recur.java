package DataStructure.BinaryTree;


import java.util.Stack;

public class _129_SumRoottoLeafNumbers_DFS_Recur{

     int total;
    
    public int sumNumbers(TreeNode root) {
        total = 0;
        helper(root, 0);
        return total;
    }
    
    void helper(TreeNode root, int sum) {
        if (root == null) return;
        
        sum = sum * 10 + root.val;
        
        if (root.left == null && root.right == null) {
            total += sum;
            return;
        }
        
        helper(root.left, sum);
        helper(root.right, sum);
    }
/*** dfs**/
      public int sumNumbers_DFS(TreeNode root) {
            if(root==null){
                return 0;
            }
            int sum = 0;
            TreeNode curr;
            Stack<TreeNode> ws = new Stack<TreeNode>();
            ws.push(root);
            
            while(!ws.empty()){
                curr = ws.pop();
                
                if(curr.right!=null){
                    curr.right.val = curr.val*10+curr.right.val;
                    ws.push(curr.right);
                }
                
                if(curr.left!=null){
                    curr.left.val = curr.val*10+curr.left.val;
                    ws.push(curr.left);
                }
                
                if(curr.left==null && curr.right==null){ // leaf node
                    sum+=curr.val;
                }
            }
            return sum;
        }


}