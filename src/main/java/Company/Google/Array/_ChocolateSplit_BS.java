package Company.Google.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/28/19
 * Time: 3:01 PM
 * Description:
 */


public class _ChocolateSplit_BS {
    public static void main(String[] args){
        splitChocolate(new int[]{3,2,3,1,4}, 3);
    }
    static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> splitChocolate(int[] cho, int n){
        if (cho == null || cho.length < n) return new ArrayList<>();
        int l = Integer.MAX_VALUE, r = 0, mid;
        for (int i : cho){
            r += i;
            l = Math.min(i, l);
        }
        while (l <= r){
            mid = l + (r - l) / 2;
            if (split(cho, mid,n))
                l = mid + 1;
            else
                r = mid - 1;
        }
        return ans;
    }
    // 3 1 10 2 4 1
    public static boolean split(int[] cho, int mid, int n){
        List<List<Integer>> res = new ArrayList<>();
        int i = 0, sum = 0,  k = n;
        while (n-- > 0){
            List<Integer> split = new ArrayList<>();
            for (; i < cho.length; i++){
                sum += cho[i];
                split.add(cho[i]);
                if (sum < mid) continue;
                res.add(split);
                sum = 0;
                i++;
                break;
            }
        }
        ans = res;
        return res.size() == k ? true : false;
    }
}
