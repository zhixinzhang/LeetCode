package company.Amazon;

import DataStructure.BinaryTree.TreeNode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/22/19
 * Update: 1/8/21
 * Time: 12:35 PM
 * Description:
 */


public class _314_BinaryTreeVerticalOrderTraversal_BFS_DFS_TreeMap{

    static List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> verticalOrder_BFS(TreeNode root) {
        if (root == null) {
            return ans;
        }

        int max = 0, min = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> columns = new LinkedList<>();
        queue.add(root);
        columns.add(0);
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        while (!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            int curIndex = columns.poll();
            map.putIfAbsent(curIndex, new ArrayList<>());
            map.get(curIndex).add(curNode.val);

            if (curNode.left != null) {
                queue.add(curNode.left);
                columns.add(curIndex - 1);
                min = Math.min(curIndex - 1, min);
            }

            if (curNode.right != null) {
                queue.add(curNode.right);
                columns.add(curIndex + 1);
                max = Math.max(max, curIndex + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    static int max = 0;
    static int min = 0;
    public static List<List<Integer>> verticalOrder_DFS(TreeNode root) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        dfsPreOrder(root, 0, map);

        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    private static void dfsPreOrder(TreeNode root, int index, HashMap<Integer, List<Integer>> map ){
        if (root == null) {
            return;
        }

        map.putIfAbsent(index, new ArrayList<>());
        map.get(index).add(root.val);
        dfsPreOrder(root.left, index - 1, map);
        dfsPreOrder(root.right, index + 1, map);
        min = Math.min(min, index);
        max = Math.max(max, index);
    }


    public List<List<Integer>> verticalOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> res = new HashMap<>();
        dfs(root,0,res);

        List<List<Integer>> end = new ArrayList<>();
        //对map利用key排序
        Map<Integer, List<Integer>> resMap = sortMapByKey(res);
        for(Map.Entry<Integer, List<Integer>> entry : res.entrySet()){
            end.add(entry.getValue());
        }
        return end;
    }

    private void dfs(TreeNode root, int index, HashMap<Integer, List<Integer>> res){
        if(root == null) return;
        res.putIfAbsent(index, new ArrayList<>());
        res.get(index).add(root.val);
        dfs(root.left,index-1,res);
        dfs(root.right, index+1, res);
    }

    private Map<Integer, List<Integer>> sortMapByKey(Map<Integer, List<Integer>> map){
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<Integer, List<Integer>> sortMap = new TreeMap<Integer, List<Integer>>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }




    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);

        verticalOrder_DFS(root);
    }
}

class MapKeyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer s1, Integer s2) {
        return s1-s2;  //从小到大排序
    }
}
