package Company.Houzz;
import java.util.*;
/**
 * Created by zhang on 2018/1/21.
 */
//O(nlogn) + O(n ^ 2)
public class _15_3Sum_sort {
    //-1, 0, 1, 2, -1, -4
    // -4 -1 -1 0 1 2
    //low = -4   left to right  -1 -1 0 1 2
    // if left
    //Sort the array, iterate through the list, and use another two pointers to approach the target.
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new LinkedList<>();
        if(num == null || num.length < 3)
            return res;
        Arrays.sort(num);
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}
