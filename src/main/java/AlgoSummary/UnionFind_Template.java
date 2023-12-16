package AlgoSummary;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/8/19
 * Time: 7:07 PM
 * Description:
 * _990_SatisfiabilityofEqualityEquations_UF_DFS
 */


public class UnionFind_Template {
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
}
