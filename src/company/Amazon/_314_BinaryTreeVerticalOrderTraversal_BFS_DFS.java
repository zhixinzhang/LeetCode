package company.Amazon;

import DataStructure.BinaryTree.TreeNode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/22/19
 * Time: 12:35 PM
 * Description:
 */


public class _314_BinaryTreeVerticalOrderTraversal_BFS_DFS {

    public List<List<Integer>> verticalOrder_BFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        q.add(root);
        cols.add(0);

        int min = 0;
        int max = 0;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = cols.poll();

            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(node.val);

            if (node.left != null) {
                q.add(node.left);
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }

            if (node.right != null) {
                q.add(node.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }

        return res;
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
}


class MapKeyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer s1, Integer s2) {
        return s1-s2;  //从小到大排序
    }
}
