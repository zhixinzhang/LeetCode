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

//    public static void main(String[] args){
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(6);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(7);
//        verticalTraversal_2d(root);
//    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(8);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(4);
        root.right.left.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(5);
        verticalTraversal_2d(root);
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


    // solution 2 有bug
    static List<List<Integer>> ans = new ArrayList<>();
    static Map<Integer, List<int[]>> map = new HashMap<>();
    static int minLeft = 0, maxRight = 0;

    public static List<List<Integer>> verticalTraversal_2d(TreeNode root) {
        if (root == null) {
            return ans;
        }


        // for loop map
        dfs(root, 0, 0);
        for (int i = minLeft; i <= maxRight; i++){
            List<Integer> res = new ArrayList<>();
            Collections.sort(map.get(i), new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[2] != o2[2]) return o1[2] - o2[2];
                    if (o1[0] != o2[0]) return o1[0] - o2[0];
                    return 0;
                }
            });

            for (int[] node : map.get(i)){
                res.add(node[0]);
            }
            System.out.println(res);
            ans.add(res);
        }

        return ans;
    }

    private static void dfs (TreeNode root, int col, int vol){
        if (root == null) {
            return;
        }
        minLeft = Math.min(col, minLeft);
        maxRight = Math.max(col, maxRight);
        map.putIfAbsent(col, new ArrayList<>());

        if (map.get(col).isEmpty()) {
            map.get(col).add(new int[] {root.val, col, vol});
        } else {
            List<int[]> prevNodes = map.get(col);
            prevNodes.add(new int[]{root.val, col, vol});
        }

        dfs(root.left, col - 1, vol + 1);
        dfs(root.right, col + 1, vol + 1);
    }


    // Soltion 2 :
    static Map<Integer, List<Integer>> map_2 = new HashMap<>();
    static int min = 0;
    static int max = 0;
    public static List<List<Integer>> verticalTraversal_PreOrderDFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        preOrderDfs(root, 0);
        while (min <= max){
            Collections.sort(map_2.get(min));
            res.add(map_2.get(min));
            min++;
        }
        return res;
    }

    private static void preOrderDfs(TreeNode root, int index){
        if (root != null) {
            min = Math.min(min, index);
            max = Math.max(max, index);

            map_2.putIfAbsent(index, new ArrayList<>());
            map_2.get(index).add(root.val);
            preOrderDfs(root.left, index - 1);
            preOrderDfs(root.right, index + 1);
        }
    }
}
