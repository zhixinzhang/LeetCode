package Company.Ebay;
import java.util.*;

import Company.Google.TreeNode;
//先算高度 

public class _655_PrintBinaryTree_DFS_BFS {

    //DFS 
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        
        int height = getHeight(root);
        int row = height + 1;
        int column = (int) Math.pow(2, height+1) - 1;
        
        for(int k=0; k<row; k++){
            List<String> list = new ArrayList<>();
            for(int i=0; i<column; i++){
                list.add("");
            }
            res.add(list);
        }
        
        int left = 0;
        int right = column-1;
        int level=0;
        print(res, left, right, level, root);
   
        return res;
    }

    public void print(List<List<String>> res, int left, int right, int level, TreeNode root){
        if(root == null) return;
        int mid = left+(right-left)/2;
        res.get(level).set(mid, String.valueOf(root.val));
        
        print(res, left, mid-1, level+1, root.left);
        print(res, mid+1, right, level+1, root.right);
    }

    public int getHeight(TreeNode root){
        if (root == null) 
            return -1;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        return Math.max(left, right) + 1;
    }

    // BFS
    class BFSNode {
        TreeNode node;
        int row, col;
        
        BFSNode(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<String>> printTree_BFS(TreeNode root) {
        int h = getHeight(root);
        int m = h+1;
        int n = (int) Math.pow(2, h+1) - 1;
        List<List<String>> res = new ArrayList<>(m);
        for(int i = 0; i < m; i++) {
            String[] list = new String[n];
            Arrays.fill(list, "");
            res.add(Arrays.asList(list));
        }
        
        Queue<BFSNode> q = new LinkedList<>();
        q.add(new BFSNode(root, 0, (n - 1) / 2));
        
        while(!q.isEmpty()) {
            BFSNode bfs = q.remove();
            res.get(bfs.row).set(bfs.col, ""+bfs.node.val);
            
            int colOffset = (int) Math.pow(2, h-bfs.row-1);
            if(bfs.node.left != null) {
                q.add(new BFSNode(bfs.node.left, bfs.row+1, bfs.col-colOffset));
            }
            
            if(bfs.node.right != null) {
                q.add(new BFSNode(bfs.node.right, bfs.row+1, bfs.col+colOffset));
            }
        }
        return res;
    }

}
