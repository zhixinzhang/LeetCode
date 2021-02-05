package Company.Houzz;

import java.util.HashMap;

/**
 * Created by zhang on 2018/1/21.
 */
//O(n)
public class _2Sum_HashMap {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> hm = new HashMap<>(); // targer - val index
            int[] res = new int[2];
            for (int i = 0; i< nums.length;i++){
                if(hm.containsKey(nums[i])){
                    res[0] = hm.get(nums[i]);
                    res[1] = i;
                    return res;
                }else {
                    hm.put(target-nums[i],i);
                }
            }
            return res;
        }
    }
