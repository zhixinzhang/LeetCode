package google.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhang on 2018/8/6.
 */
public class _219_ContainsDuplicate2_HM {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i <  nums.length; i++) {
            Integer ord = map.put(nums[i], i);
            if(ord != null && i - ord <= k) {
                return true;
            }
        }

        return false;
    }
}
