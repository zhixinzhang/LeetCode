package SystemDesign;
import java.util.*;

/**
 * Created by zhang on 2018/5/3.
 */

public class _398_RandomPickIndex_ReservoirSampling {
//    int[] nums;
//    Random r = new Random();
//    public _398_RandomPickIndex_ReservoirSampling(int[] nums) {
//        this.nums = nums;
//    }
//
//    public int pick(int target) {
//        // find all same vale and store the index to list
//        ArrayList<Integer> arr = new ArrayList<>();
//        for(int i = 0; i<nums.length; i++){
//            if(nums[i] == target)
//                arr.add(i);
//        }
//        return arr.get(r.nextInt(arr.size()));
//    }



    private int[] nums;
    private Random rand;

    public _398_RandomPickIndex_ReservoirSampling(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        int n = this.nums.length;
        int count = 0;
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            // if nums[i] is equal to target, i is a potential candidate
            // which needs to be chosen uniformly at random
            if (this.nums[i] == target) {
                // increment the count of total candidates
                // available to be chosen uniformly at random
                count++;
                // we pick the current number with probability 1 / count (reservoir sampling)
                if (rand.nextInt(count) == 0) {
                    idx = i;
                }
            }
        }
        return idx;
    }
}
