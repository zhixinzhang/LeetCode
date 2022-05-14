package DataStructure.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhang on 2017/10/7.
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity
 */
/**時間複雜度是O（n）
 * 衹能循環一遍 所以用hashset
 * 存入hashset之後  每個元素 左右search 看是否有連續的在 hashset中
 * 找到最長的longest  Math.max(a,b)
 *  */
public class _128_LongestConsecutiveSequence_Map_Sort {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
    public  static  void main(String args[]){

//        int[] array = {100, 4, 200, 1, 3, 2};
//        int[] array = {0,3,7,2,5,8,4,6,0,1};
        int[] array = {1,2,0,1};
//        int[] array = {0,0};

        longestConsecutive_sort(array);

    }

    public static int longestConsecutive_sort(int[] nums){
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int maxLen = Integer.MIN_VALUE;
        int l = 0, r = 1;
        int distance = 1;
        while (r < nums.length){
            if (nums[r] - distance != nums[l]) {
                maxLen = Math.max(maxLen, r - l);
                l = r;
                distance = 1;
            } else {
                distance++;
            }
            r++;
        }

        maxLen = Math.max(maxLen, distance);
        return maxLen;
    }
}
