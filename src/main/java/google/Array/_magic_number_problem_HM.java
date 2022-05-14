package google.Array;

import java.util.HashMap;

/**
 * Created by zhang on 2018/8/6.
 */
public class _magic_number_problem_HM {
    public static void main(){
        int[] res = magic(new int[]{1,2,3,4});
    }
    public static int[] magic(int[] arr){
        if (arr == null || arr.length == 0)
            return arr;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            int val = arr[i];
            int step = 0;
            if (val == 1){
                res[i] = 0;
                continue;
            }
            while (val != 1){
                if (hm.containsKey(val)){
                    step += hm.get(val);
                    break;
                }
                if (val % 2 == 0){
                    val /= 2;
                }else {
                    val = val * 3 + 1;
                }
                step++;
            }
            hm.putIfAbsent(arr[i], step);
            res[i] = step;
        }
        return res;
    }
}
