package XianQiao;

import java.util.HashMap;

public class TwoSum_XianQiao {
    public static int[] twoSum(int[] nums, int target){
        if(nums == null || nums.length == 0) {
            return new int[]{0, 0};
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
            int leftValue = target - nums[i];
            if(map.containsKey(leftValue)){
                return new int[]{i, map.get(leftValue)};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args){
        int[] nums = new int[]{2, 7, 11, 15, 19};
        int target = 21;
        int[] res = twoSum(nums, target);
        System.out.println("leftIndex is " + res[0]);
        System.out.println("rightIndex is " + res[1]);
    }
}
