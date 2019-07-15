package DataStructure.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/8/19
 * Time: 6:43 PM
 * Description:
 */


public class _990_SatisfiabilityofEqualityEquations_UF_DFS {
    class UnionFind{
        int[] uf;
        UnionFind(int size){
            uf = new int[size];
            for (int i = 0; i < size; i ++)
                uf[i] = i;
        }
        void union(int a, int b){
            int fa = find(a);
            int fb = find(b);
            uf[fa] = fb;
        }
        int find(int a){
            while (uf[a] != a){
                uf[a] = uf[uf[a]];
                a = uf[a];
            }
            return a;
        }
    }
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String e : equations){
            if (!e.contains("!")){
                int a = uf.find(e.charAt(0) - 'a');
                int b = uf.find(e.charAt(3) - 'a');
                uf.union(a, b);
            }
        }
        for (String e : equations){
            if (e.contains("!")){
                int a = uf.find(e.charAt(0) - 'a');
                int b = uf.find(e.charAt(3) - 'a');
                if(a == b)
                    return false;
            }
        }
        return true;
    }
}
