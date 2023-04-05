package Company.Grammly;
import java.util.*;

public class _TaketheIntersectionofTwoArrays_set {
    private int[] getInter(Integer[] a1, Integer[] a2){
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(a1));

        for (int i : a2){
            if (set.contains(i)) {
                res.add(i);
            }
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
