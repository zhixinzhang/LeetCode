public class JumpGame45 {


    public int jump(int[] nums) {
        int step = 0;
        int left  = 0;
        int right = 0;
        if(nums.length ==1) return 0;

        while(left <= right){
        ++ step;
final int old_right = right;
        for(int i = left; i<= old_right;++i){
        int new_right = i + nums[i];
        if(new_right >= nums.length -1) return step;
        if(new_right > right) right = new_right;
        }
        left = old_right +1;
        }
        return 0;
        }


        }

