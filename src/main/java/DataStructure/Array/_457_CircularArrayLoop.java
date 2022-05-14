package DataStructure.Array;

/**
 * Created by zhang on 2018/5/4.
 * 必须要过0 或者 nums.length
 */
public class _457_CircularArrayLoop {
    public static boolean circularArrayLoop(int[] nums) {
        if (nums.length == 0) return false;

        int index = 0;
        boolean passedBoundary = false;
        for(int i=0;i<nums.length;i++) {
            int newIdx = index+nums[index];

            if(newIdx >= nums.length) {
                passedBoundary = true;
            }

            index = (newIdx) % nums.length;

            if(index < 0) {
                index += nums.length;
                passedBoundary = true;
            }

            if(index == 0 && passedBoundary) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args){
        circularArrayLoop(new int[]{2,-1,1,-2,-2});
    }
}
