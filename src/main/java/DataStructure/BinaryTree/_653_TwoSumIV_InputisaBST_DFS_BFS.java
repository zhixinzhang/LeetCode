package DataStructure.BinaryTree;
import java.util.*;

public class _653_TwoSumIV_InputisaBST_DFS_BFS{

		    Set<Integer> hs = new HashSet<>();  // k - temp.val    temp.val
	    public boolean findTarget_DFS(TreeNode root, int k) {
	        //break condition
	        if(root == null) return false;
	        if (hs.contains(root.val)) return true;
	        hs.add(k - root.val);
	        return findTarget_DFS(root.left, k) || findTarget_DFS(root.right, k);
	    }

	    public boolean findTarget_BFS(TreeNode root, int k) {
        // BFS travel tree and HM to store data
    
        HashMap<Integer,Integer> hm = new HashMap<>();  // k - temp.val    temp.val
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i<len;i++){
                TreeNode temp = q.poll();
                if(hm.containsKey(temp.val)){
                    return true;
                }else{
                    hm.put(k-temp.val,temp.val);
                }
                if(temp.left!=null)q.offer(temp.left);
                if(temp.right!=null)q.offer(temp.right);
            }
        }
        return false;
        
    }
}