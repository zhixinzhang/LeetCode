package google.Array;
import java.util.*;
/**
 * Created by zhang on 2018/6/20.
 *
 * bfs 相似的连接到一起
 *
 */
public class _839_SimilarStringGroups_BFS {
    public int numSimilarGroups_BFS(String[] A) {
        HashSet<String> hs = new HashSet<>();
        for(String s : A) hs.add(s);
        Queue<String> q = new LinkedList<>();
        int res = 0;
        for(int i = 0; i< A.length; i++){
            String s = A[i];
            if(!hs.contains(s))
                continue;
            hs.remove(s);
            res++;
            q.add(s);
            while(!q.isEmpty()){
                String group = q.poll();
                for(int j = 0; j<A.length; j++){
                    if(!hs.contains(A[j]))
                        continue;

                    int diff = 0;
                    for(int l = 0; l<A[j].length(); l++){
                        if(group.charAt(l) != A[j].charAt(l))
                            diff++;
                    }
                    if(diff == 2){
                        hs.remove(A[j]);
                        q.add(A[j]);
                    }

                }
            }


        }
        return res;
    }
    public int numSimilarGroups_UF_Classic(String[] A) {
        int[] parent = new int[A.length];
        for(int i=0; i<parent.length; i++) {
            parent[i] = i;
        }
        int groups = A.length;
        for(int i=0; i<A.length-1; i++) {
            for(int j=i+1; j<A.length; j++) {
                if(isSimilar_UF(A[i], A[j])) {
                    int p1 = i;
                    int p2 = j;
                    while(p1!=parent[p1]) {
                        p1 = parent[p1];
                    }
                    while(p2!=parent[p2]) {
                        p2 = parent[p2];
                    }
                    if(p1!=p2) {
                        groups--;
                        parent[p2] = p1;
                    }
                }
            }
        }
        return groups;
    }

    private boolean isSimilar_UF(String word1, String word2) {
        int count = 0;
        for(int i=0; i<word1.length(); i++) {
            if(word1.charAt(i)!=word2.charAt(i)&&++count>2) {
                return false;
            }
        }
        return true;
    }
    public int numSimilarGroups_UF(String[] A) {
        //{"tars", "rats","rsta", "arts"}  {"star"}.
        // tars rats arts star rsta tsra
        // [0 1 2 3 4 5] [1 1 1 1 1 1]
        // father tars - rats [0 0 2 3 4 5] value[2 2 1 1 1 1]
        // father tars - tsra [0 0 2 3 4 0] value[3 3 1 1 1 3]
        // father rats - rsta [0 0 0 3 4 0] value[4 4 4 1 1 4]
        // father rats - arts [0 0 0 0 4 0] value[5 5 5 5 1 5]
        //
        int res = 0;
        UnionFind uf = new UnionFind(A.length);
        for (int i = 0; i < A.length; i++){
            for (int j = i+1; j<A.length; j++){
                if(uf.father[i] == uf.father[j] && isSimilar(A[i],A[j])){
                    uf.union(i,j);
                }
            }
        }
        // [0 1 2 3 4 5]
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i<uf.father.length; i++){
            hs.add(uf.father[i]);
        }
        return hs.size();
    }
    public boolean isSimilar(String a, String b){
        int i = 0;
        for (int j = 0; j<a.length(); j++){
            if (a.charAt(j) != b.charAt(j))
                i++;
        }
        if (i == 2)
            return true;
        return false;
    }
    class UnionFind{
        int[] father;
        int[] count;
        UnionFind(int size){
            father = new int[size];
            count = new int[size];
            for (int i = 0; i<size; i++){father[i] = i;}
            Arrays.fill(count,1);
        }
        void union(int a, int b){
            int fa = find(a,father);
            int fb = find(b,father);
            if (fa != fb){
                father[fa] = fb;
                int val = count[fa] + count[fb];
                for (int i = 0; i<father.length; i++){
                    if (father[i] == father[fa] || father[i] == father[fb]){
                        count[i] = val;
                    }
                }
            }
        }
        int find(int a, int[] father){
            while (a != father[a]){
                father[a] = father[father[a]];
                a = father[a];
            }
            return a;
        }

    }
}
