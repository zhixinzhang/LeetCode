package Company.Google.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/8/6.
 */
public class _120_Triangle_DP {
    public static int max(List<List<Integer>> tri){
        int b = tri.size();
        int res = tri.get(0).get(0);
        for (int i = 1; i < b; i++){
            int size = tri.get(i).size();
            for (int j = 0; j < size; j++){
                int a = 0, c = 0;
                if (j -1 >= 0)
                    a = tri.get(i-1).get(j-1);
                if (j< size-1)
                    c = tri.get(i-1).get(j);
                int cur = tri.get(i).get(j);
                tri.get(i).set(j,Math.max(a,c)+cur);
            }
        }
        List<Integer> ss = new ArrayList<>();
        ss.add(1,0);
        return res;
    }
    public static void main(String[] args){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        l1.add(3);
        res.add(l1);

        l2.add(2);
        l2.add(4);
        res.add(l2);

        l3.add(6);
        l3.add(5);
        l3.add(7);
        res.add(l3);

        max(res);
    }
}
