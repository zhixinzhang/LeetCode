package SystemDesign;
import java.util.*;

/**
 * Created by zhang on 2018/5/3.
 */

public class _398_RandomPickIndex_ReservoirSampling {
    int[] nums;
    Random r = new Random();
    public _398_RandomPickIndex_ReservoirSampling(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        // find all same vale and store the index to list
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == target)
                arr.add(i);
        }
        return arr.get(r.nextInt(arr.size()));
    }
}
