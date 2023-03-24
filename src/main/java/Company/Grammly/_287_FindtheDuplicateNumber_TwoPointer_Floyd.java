package Company.Grammly;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhang on 2018/3/26.
 * Now the problem is the same as find the cycle in linkedlist!
 * 如果有重复的数 那么他们一定指向同一个index！！！
 */
public class _287_FindtheDuplicateNumber_TwoPointer_Floyd {

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow==fast) break;
        }
        slow = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int findDuplicate_set(int[] nums) {
        Set<Integer> cache = new HashSet<>();

        for (int n : nums){
            if(!cache.add(n)){
                return n;
            }
        }

        return -1;
    }

    public static void main(String[] args){
//        findDuplicate(new int[]{1, 3, 4, 2, 2});
        findDuplicate(new int[]{3,1,3,4,2});
        int[]ans = findDuplicate_followUp(new int[]{1, 2, 2, 4});
    }

    public int findDuplicate_BinarySearch(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low <= high) {
            int mid = (int) (low + (high - low) * 0.5);
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid) ++cnt;
            }
            if (cnt <= mid) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }


    // https://www.1point3acres.com/bbs/thread-920614-1-1.html
    /**
     * 第一题 有点像力口 耳罢奇，但是不仅要输出到重复的数，还要找到1 到n 范围内缺失得数
比如说 [1,2,2,4] 输出就是[2, 3]，第一个数是指2是重复的，第二个数指这个数组里缺少3
     * 
    */

    public static int[] findDuplicate_followUp(int[] nums) {
        Set<Integer> cache = new HashSet<>();
        int[] ans = new int[2];
        for (int n : nums){
            if(!cache.add(n)){
                ans[0] = n;
            }
        }

        for (int i = 1; i < nums.length; i++){
            if (!cache.contains(i)){
                ans[1] = i;
            }
        }

        return ans;
    }
}
