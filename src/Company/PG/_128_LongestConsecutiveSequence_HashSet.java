package Company.PG;
import java.util.HashSet;
/**
 * Created by zhang on 2017/10/7.
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 Your algorithm should run in O(n) complexity
 時間複雜度是O（n）
 * 衹能循環一遍 所以用hashset
 * 存入hashset之後  每個元素 左右search 看是否有連續的在 hashset中
 * 找到最長的longest  Math.max(a,b)
 *  */
// use hashset to store each num in nums
// for loop hashset and for each num in hashset to left and right
// delete hs(num) when we find hs contains hs(hum) avoid second loop
public class _128_LongestConsecutiveSequence_HashSet {
    public static int longestConsecutive(int[] nums) {
        final HashSet<Integer> hs = new HashSet<>();
        for (int i:nums) {
            hs.add(i);
        }
        int longest = 0;
        for (int i: nums) {
            int length = 1;
            for (int j = i-1; hs.contains(j); --j){
                hs.remove(j);
                ++length;
            }
            for (int j = i+1; hs.contains(j); ++j){
                hs.remove(j);
                ++length;
            }
            longest = Math.max(longest,length);
        }
        return longest;
    }
    public  static  void main(String args[]){

        int[] array = {100, 4, 200, 1, 3, 2};
//        int[] array = {0,0};

        longestConsecutive(array);

    }
}
