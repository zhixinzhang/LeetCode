//package DataStructure.Tree.Array;
//import java.util.*;
//
//
//public class _594_LongestHarmoniousSubsequence_HM{
//	    public int findLHS_HM(int[] nums) {
//        int max = 0;
//        Map<DataStructure.Integer, DataStructure.Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        for (int num : map.keySet()) {
//            if (map.containsKey(num + 1)) {
//                max = Math.max(max, map.get(num) + map.get(num + 1));
//            }
//        }
//
//        return max;
//    }
//
//    public int findLHS(int[] nums) {
//    if (nums.length == 0) {
//        return 0;
//    }
//    Arrays.sort(nums);
//    int start = 0;
//    int nextstart = 0;
//    for (int i = 1; i < nums.length; i++) {
//        if (nums[i] - nums[start] == 1) {
//            if (nums[nextstart] < nums[i]) {
//                nextstart = i;
//            }
//            res = Math.max(res, i - start + 1);
//        } else if (nums[i] - nums[start] > 1) {
//            start = start == nextstart ? i : nextstart;
//            i--;
//        }
//    }
//    return res;
//}
//}