package XianQiao;

import java.util.HashMap;

public class TwoSum_XianQiao {
    /** 把当前值的配对值和当前值的index配对放进map，这样当到配对值时可以直接get
     * 配对值的index和之前的index 并且只iterate一遍，所以不会重复使用一个值*/
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }

        return new int[] {-1, -1};
    }

    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (map.containsKey(res) && map.get(res) != i) {
                return new int[] {i, map.get(res)};
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args){
        int[] nums = new int[]{2, 7, 11, 15, 19};
        int target = 21;
        int[] res = twoSum(nums, target);
        System.out.println("leftIndex is " + res[0]);
        System.out.println("rightIndex is " + res[1]);
    }
}
