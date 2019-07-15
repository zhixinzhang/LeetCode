package company.Amazon;

import DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/21/19
 * Time: 4:36 PM
 * Description:
 */

class Point{
    int x,y,val;
    Point(int x,int y,int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

public class _987_VerticalOrderTraversalofaBinaryTree_DFS_PQ {

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        verticalTraversal(root);
    }
    static List<PriorityQueue<Integer>> hm = new ArrayList<>();

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if(p1.x < p2.x) return -1;
                if(p2.x < p1.x) return 1;
                if(p1.y > p2.y) return -1;
                if(p1.y < p2.y) return 1;
                return p1.val - p2.val;
            }
        });
        dfs(root,0,0,pq);
        Point prev = null;
        List<Integer> l = new ArrayList<>();
        while(!pq.isEmpty()){
            Point p = pq.poll();
            if(prev == null || p.x != prev.x){
                if(prev != null) res.add(l);
                l = new ArrayList<>();
            }
            l.add(p.val);
            prev = p;
        }

        if(res.size() > 0) res.add(l);
        return res;
    }


    private static void dfs(TreeNode root,int x,int y,PriorityQueue<Point> pq){
        if(root == null) return;
        pq.offer(new Point(x,y,root.val));
        dfs(root.left,x-1,y-1,pq);
        dfs(root.right,x+1,y-1,pq);
    }
}
