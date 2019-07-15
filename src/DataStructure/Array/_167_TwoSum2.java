package DataStructure.Array;

import java.util.HashMap;

/**
 * Created by zhang on 2017/9/21.
 * Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class _167_TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i =0;i<numbers.length;i++){
            if(hs.containsValue(numbers[i])){
                result[0] = hs.get(numbers[i]);
                result[1] = i;
            }else{
                hs.put(target-numbers[i],i);
            }
        }
        return result;
    }
}
