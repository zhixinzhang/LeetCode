package google.Array;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zhang on 2018/7/14.
 */
public class _853_TreeMap {
    public static void main(String[] args){
            carFleet(12,new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3});
    }
    public static int carFleet(int target, int[] pos, int[] speed) {
        TreeMap<Integer, Double> m = new TreeMap<>();
        for (int i = 0; i < pos.length; ++i) m.put(-pos[i], (double)(target - pos[i]) / speed[i]);
        int res = 0; double cur = 0;
        for (Map.Entry<Integer, Double> e : m.entrySet()) {
            if (e.getValue() > cur) {
                cur = e.getValue();
                res++;
            }
        }
        return res;
    }
}
