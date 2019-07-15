package company.uber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/9/18.
 *
 * follow up 是输出所有的group
 */
public class _323_NumberofConnectedComponentsinanUndirectedGraph_UF_BFS_DFS {
    public static void main(String[] args){
        countComponents(5, new int[][]{  //0 1 2 3 4
                {1,0,1,0,0},                //0-0   0-2   1-2
                {0,0,1,0,0},
                {1,0,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1},});
    }


    public static int countComponents(int n, int[][] adMatrix) {
        if (n < 1)  return 1;
        int[] father = new int[n];
        for(int i = 0; i<n; i++) father[i] = i;
        for (int i = 0; i < adMatrix.length; i++){
            for (int j = 0; j < adMatrix[0].length; j++){
                if (adMatrix[i][j] == 1){
                    int a = find(father,i);
                    int b = find(father,j);
                    if (a != b){
                        father[b] = a;
                        n--;
                    }
                }
            }
        }
        // 0 0 1 1 1 2 2
        // 01,2 3 4,5 6
//        father = new int[]{0,0,1,1,1,2,2};
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0,j = 0; j < father.length; ){
            List<Integer> curGroup = new ArrayList<>();
            while (j < father.length && father[j] == father[i]){
                curGroup.add(j);
                j++;
            }
            i = j;
            res.add(curGroup);
        }
        System.out.println(res);
        return n;
    }

    public static int find(int[] father, int a){
        while (father[a] != a){
            father[a] = father[father[a]];
            a = father[a];
        }
        return a;
    }


}
