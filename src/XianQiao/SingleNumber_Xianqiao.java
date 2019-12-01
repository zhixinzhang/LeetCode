package XianQiao;

import java.util.HashMap;

public class SingleNumber_Xianqiao {
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        HashMap<Integer, Integer> map = new HashMap<>();

        /*
        [7, 4, 4, 3, 1, 1, 3]
        i = 0: (Key, Value) (7, 0)-->(7, 1)
        i = 1: (4, 1)
        i = 2: (4, 2)
        i = 3: (3, 1)

        return 7
        * **/
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = new int[]{7, 4, 4, 3, 1, 1, 3};
        int res = singleNumber(nums);
        System.out.println("leftIndex is " + res);
    }
}
