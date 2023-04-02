package Company.Google;

/**http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=300737&extra=page%3D3%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311*/

import java.util.ArrayList;
import java.util.List;

/**
Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

*/
public class _163_MissingRanges{
   public List<String> findMissingRanges(int[] nums, int lower, int upper) {
       List<String> res = new ArrayList<>();
       long prev = (long)lower - 1; // int -> long
       long curr;
       for(int i = 0; i <= nums.length; i++) {
           curr = i == nums.length ? (long)upper + 1: (long)nums[i]; // int -> long
           if(prev + 2 == curr) {
               res.add((prev + 1) + "");
           } else if(prev + 2 < curr) {
               res.add((prev + 1) + "->" + (curr - 1));
           }
           prev = curr;
       }
       return res;
    }
//[0, 1, 3, 50, 75] low
    public List<String> findMissingRanges_My(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int i : nums) {
            if(i > lower) res.add(lower+((i-1 > lower)?"->"+(i-1):""));
            if(i == upper) return res; // Avoid overflow
            lower = i+1;
        }
        if(lower <= upper) res.add(lower + ((upper > lower)?"->"+(upper):""));
        return res;
    }
}