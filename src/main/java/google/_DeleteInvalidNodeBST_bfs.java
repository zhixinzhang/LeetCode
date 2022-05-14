package google;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zhang on 2017/12/5.
 */
/**
 5
 3
 2        4

 2 ----  5

 ***/
// time complexity  O(n)   hashset search O(1)
//space O(n)
//bfs + set

public class _DeleteInvalidNodeBST_bfs {
    public TreeNode invalidEdge(TreeNode root){
        if(root == null) return root;
    //set to store each node
        HashSet<TreeNode> hs = new HashSet<>();
    //bfs search each level node
        Queue<TreeNode> q = new PriorityQueue<>();
        hs.add(root);
        q.add(root);
        while(q.size()!=0){
            // if set contain curNode’s child its invalid
            TreeNode curNode = q.poll();
            if(curNode.left != null){
                if(hs.contains(curNode.left)) {
                    curNode.left = null;
                    return root;
                }else {
                    hs.add(curNode.left);
                    q.add(curNode.left);
                }
            }
            if(curNode.right != null){
                if(hs.contains(curNode.right)){
                    curNode.right = null;
                    return root;
                }else{
                    hs.add(curNode.right);
                    q.add(curNode.right);
                }
            }


        }
        return root;
    }
}
