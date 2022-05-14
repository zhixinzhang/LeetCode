package DataStructure.Array;
import java.util.*;
/**
 * Created by zhang on 2017/12/25.
 */
/**本题和maximun size subarray sum equal k比较类似，这里有一个把0转换成-1来进行计算的过程，然后存储一个hashmap用来存放sum，如果接下来的sum在hashmap里面出现过，则说明hashmap里面出现的那个值的索引的开始（不包括索引），到目前的索引的和为0*/

public class _525_ContiguousArray_HashMap {
    public int findMaxLength(int[] nums) {
        for(int i = 0; i<nums.length;i++){
            if(nums[i] == 0) nums[i] = -1;
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int sum = 0, max = 0;
        for(int i = 0 ; i<nums.length;i++){
            sum += nums[i];
            if(hm.containsKey(sum)){
                max = Math.max(max, i - hm.get(sum));
            }else{
                hm.put(sum,i);
            }
        }

        return max;
    }
}
