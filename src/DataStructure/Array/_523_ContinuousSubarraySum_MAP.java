package DataStructure.Array;
import java.util.*;
/**
 * Created by zhang on 2017/12/25.
 */
//1、处理k为0的情况；2、用HashMap保存sum对k取余数，如果前序有余数也为sum % k的位置，那么就存在连续子数组和为k的倍数
public class _523_ContinuousSubarraySum_MAP {
    public static void main(String[] args){
        checkSubarraySum(new int[]{23, 2, 4, 6, 7},6);
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int sum = 0;
        //[23, 2, 4, 6, 7],  k=6
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer prev = map.get(k == 0 ? sum : sum % k);
            if (prev != null) {
                if (i - prev > 1) {
                    return true;
                }
            } else {
                map.put(k == 0 ? sum : sum % k, i);
            }
        }
        return false;
    }
}
