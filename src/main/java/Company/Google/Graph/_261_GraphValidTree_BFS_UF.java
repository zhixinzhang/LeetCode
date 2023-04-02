package Company.Google.Graph;

import java.util.*;

/**
 * Created by zhang on 2018/6/14.
 * 判断是否有环 以及是否都联通  用bfs O(V+E)
 * 重点是要删除子节点里的负节点
 *
 * UF
 */
public class _261_GraphValidTree_BFS_UF {
    /**             0
     *          1
     *             2    4
     * **/
    public static boolean validTree(int n, int[][] edges) {
        // 0 - 1 2 3
        // 1 - 0 4
        // 4 - 1
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i<n; i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            hm.put(i, list);
        }

        for(int[] edge: edges){
            hm.get(edge[0]).add(edge[1]);
            hm.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()){
            int curNode = q.poll();
            if (visited.contains(curNode))
                return false;
            visited.add(curNode);
            for (int i : hm.get(curNode)){
                if (!visited.contains(i))
                    q.offer(i);
            }
        }
        if (visited.size() == n)
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        validTree_UF(5,new int[][]{{0,1}, {2,1}, {2,0}, {2,4}});
    }

//   [0 1 2 3 4]
//   []
    public static boolean validTree_UF(int n, int[][] edges) {
        int[] father = new int[n];
        for(int i = 0; i<n; i++){       //[0 1 2 3 4]
            father[i] = i;
        }

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            int fatherA = find(a,father);
            int fatherB = find(b,father);
            if(fatherA == fatherB)
                return false;
            father[fatherB] = fatherA;
        }
        return edges.length + 1 == n;

    }
    public static int find(int a,int[] nums){
        while(a != nums[a]){
            nums[a] = nums[nums[a]];
            a = nums[a];
        }
        return a;
    }


    public static boolean validTree_UF_CompressPath(int n, int[][] edges) {
        int[] father = new int[n];
        Arrays.fill(father,-1);

        for(int[] edge : edges){
            int fatherA = find(edge[0],father);
            int fatherB = find(edge[1],father);
            if(fatherA == fatherB)
                return false;
            father[fatherB] = fatherA;
        }
        return edges.length + 1 == n;
    }
    public static int find_CP(int a,int[] father){
        if (father[a] == -1) return a;
        if (father[father[a]] != -1)
            father[a] = father[father[a]];

        return find_CP(father[a],father);
    }


}
