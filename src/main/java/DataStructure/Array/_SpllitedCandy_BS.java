package DataStructure.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/18/19
 * Time: 4:40 PM
 * Description:
 */


public class _SpllitedCandy_BS {
    public static void main(){

    }

    public static List<Integer> solve(int[] nums, int k){
        if(k <= 1)  return  new ArrayList<>();
        int min = Integer.MIN_VALUE, max = 0, sum = 0;
        for (int i : nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
            sum += i;
        }
        max = Math.max(max, sum / k - 1);
        List<Integer> res = new ArrayList<>();
        while (min < max){
            List<Integer> ans = new ArrayList<>();
            int mid = (min + max) / 2;
            // mid
//            for (){}


        }
        return res;
    }
}
