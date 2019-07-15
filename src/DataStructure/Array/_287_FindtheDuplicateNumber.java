package DataStructure.Array;

/**
 * Created by zhang on 2018/3/26.
 * Now the problem is the same as find the cycle in linkedlist!
 * 如果有重复的数 那么他们一定指向同一个index！！！
 */
public class _287_FindtheDuplicateNumber {
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
    public static void main(String[] args){
        findDuplicate(new int[]{1, 3, 4, 2, 2});
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
}
