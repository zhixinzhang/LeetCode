package Company.Amazon;

import DataStructure.BinaryTree.TreeNode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/21/19
 * Time: 4:36 PM
 * Description:
 *
 * Similar to 314 Binary Tree Vertical Order Traversal
 *
 * Two solutions :
 * 1: build new Point class and use x and y coordinate
 * 2: Use Preorder dfs and position index and hashmap
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
        verticalTraversal_PreOrderDFS(root);
    }
    static List<PriorityQueue<Integer>> hm = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> verticalTraversal(TreeNode root) {

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


    // Soltion 2 :
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int min = 0;
    static int max = 0;
    public static List<List<Integer>> verticalTraversal_PreOrderDFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        preOrderDfs(root, 0);
        while (min <= max){
            res.add(map.get(min));
            min++;
        }
        return res;
    }

    private static void preOrderDfs(TreeNode root, int index){
        if (root != null) {
            min = Math.min(min, index);
            max = Math.max(max, index);

            map.putIfAbsent(index, new ArrayList<>());
            map.get(index).add(root.val);
            preOrderDfs(root.left, index - 1);
            preOrderDfs(root.right, index + 1);
        }
    }
}
