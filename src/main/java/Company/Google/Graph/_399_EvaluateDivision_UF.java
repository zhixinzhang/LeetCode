package Company.Google.Graph;

import java.util.Arrays;

/**
 * Created by zhang on 2018/6/15.
 * equations = [ ["a", "b"], ["b", "c"] ],
 values = [2.0, 3.0],
 queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 /**  a  b c d       [-1 2 3 6]
 *
 *  a = 12  b = 6   c = 1  d = 3
 *  a/b = 2      [ 1 2 3 4] -- father[1 1 2 3]  val [2 1 -1 -1]
 *  d/c = 3      father [1 1 2 2]   val [2 1 1 3]
 *  b/c = 6       father[1 1 1 1]   val[2 1 1 3] --- val[12 6 1 3]
 */
public class _399_EvaluateDivision_UF {
    static class UnionFind{
        int[] father;
        double[] count;
        UnionFind(){
            father = new int[26];
            count = new double[26];
            Arrays.fill(father,-1);
            Arrays.fill(count,-1);
        }
        void union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            if(pa != pb){
                for (int i = 0; i<26;i++){
                    if (father[i] == pb)
                        father[i] = pa;
                }
            }
//                father[pb] = pa;
        }
        public int find(int a){
            if(father[a] == -1){
                father[a] = a;
                return a;
            }

            while( a != father[a]){
                father[a] = father[father[a]];
                a = father[a];
            }
            return a;
        }
    }
    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res = new double[queries.length];
        int n = equations.length;
        UnionFind uf = new UnionFind();

        double[] count = uf.count;
        for(int i = 0; i<n; i++){
            String[] num = equations[i];
            int a = num[0].charAt(0) - 'a';
            int b = num[1].charAt(0) - 'a';
            uf.union(a,b);
            // handle count
            if(count[a] == -1 && count[b] == -1){
                count[a] = 1;
                count[b] = 1 / (values[i]);
            }else if(count[b] == -1 && count[a] != -1){
                count[b] = count[a] / (values[i]);
            }else if(count[b] != -1 && count[a] == -1){
                count[a] = count[b] * values[i];
            }
        }
        // handle querys
        int[] father = uf.father;
        for(int i = 0; i<queries.length; i++){
            int a = queries[i][0].charAt(0) - 'a';
            int b = queries[i][1].charAt(0) - 'a';
            if(father[a] == -1 || father[b] == -1 || father[a] != father[b])
                res[i] = -1;
            else
                res[i] = count[a] / count[b];
        }
        return res;

    }

    public static void main(String[] args){
        calcEquation(new String[][]{{"a", "b"},{"c", "b"}},
                new double[]{2.0,3.0},
                new String[][]{{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"},{"x", "x"}});

//        calcEquation(new String[][]{{"a", "d"},{"a", "c"},{"a", "b"},{"e","f"}},
//                new double[]{6.0, 3.0, 2.0, 7.0},
//                new String[][]{{"a", "c"}, {"b", "a"}, {"b", "d"}, {"d", "b"},{"e","e"},{"e","g"}, {"x", "x"}});
    }
}
