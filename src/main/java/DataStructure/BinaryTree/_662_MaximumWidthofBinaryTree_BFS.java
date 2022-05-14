package DataStructure.BinaryTree;
import java.util.*;

public class _662_MaximumWidthofBinaryTree_BFS{

	 public int widthOfBinaryTree(TreeNode root) {
    if(root==null){
            return 0;
        }
        int yaer = Integer.MAX_VALUE;
        Deque<TreeNode> q = new ArrayDeque<>();
        int max =1;

        q.add(root);
        while(!q.isEmpty()){
            while(!q.isEmpty() && q.peek().val==yaer){
                q.poll();
            }
            while(!q.isEmpty() && q.peekLast().val==yaer){
                q.pollLast();
            }
            int cursize = q.size();
            max = Math.max(cursize, max);

            for(int i=0; i<cursize; i++){
                TreeNode curnode = q.poll();
                if(curnode==null){
                    q.add(new TreeNode(yaer));
                    q.add(new TreeNode(yaer));
                }else{
                    if(curnode.left!=null){
                        q.add(curnode.left);
                    }else{
                        q.add(new TreeNode(yaer)); 
                    }
                    if(curnode.right!=null){
                        q.add(curnode.right);
                    }else{
                        q.add(new TreeNode(yaer)); 
                    }
                }
            }
        }
        return max;
        
    }
}