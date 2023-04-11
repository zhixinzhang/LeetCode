package DataStructure.Graph;

import java.util.Arrays;

/**
 * 
 * 
 * 
 * https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/solutions/326305/union-find-java/
1.sort timestamp in increasing order.
2. union element who has same parent.
3. when there is only one parent, done.
*/
public class _1101_TheEarliestMomentWhenEveryoneBecomeFriends_UF {
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, (a, b) -> (a[0] - b[0]));
        UnionFind uf = new UnionFind(N);
        for (int[] log : logs){
            uf.union(log[1], log[2]);
            if (uf.res == 1) {
                return log[0];
            }
        }

        return -1;
    }

    public class UnionFind {
        int[] parent;
        int res;
        public UnionFind(int size){
            parent = new int[size];
            for (int i = 0; i < size; i++){
                parent[i] = i;
            }
            res = size;
        }

        public int find(int child){
            if (parent[child] != child){
                int p = find(parent[child]);
                parent[child] = p;
            }

            return parent[child];
        }

        public void union(int a, int b){
            int parentA = find(a);
            int parentB = find(b);

            if (parentA != parentB) {
                parent[parentA] = parentB;
                res --;
            }
        }
    }
}
