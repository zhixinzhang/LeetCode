package SystemDesign;

import java.util.Random;

/**
 * Created by zhang on 2018/5/2.
 * 水塘抽样
 * https://leetcode.com/problems/shuffle-an-array/discuss/86006/simple-java-solution
 */
public class _384_ShuffleanArray_Reservoirsampling {
    private int[] nums = new int[]{1,2,3,4};
    private Random random;

    public _384_ShuffleanArray_Reservoirsampling(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    //更牛逼的写法
    public int[] shuffle_classic() {
        int[] rand = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int r = (int) (Math.random() * (i+1));
            rand[i] = rand[r];
            rand[r] = nums[i];
        }
        return rand;
    }


    public int[] shuffle() {
        int[] rand = nums.clone();
        for (int i = 1; i < nums.length; i++){
            int r = random.nextInt(i+1 );
            swap(rand,r,i);
        }
        return rand;
    }
    private void swap(int[] rand, int r, int i){
        int temp = rand[i];
        rand[i] = rand[r];
        rand[r] = temp;
    }
    public static void main(String[] args){
         int[] nums = new int[]{1,2,3,4};
        _384_ShuffleanArray_Reservoirsampling obj = new _384_ShuffleanArray_Reservoirsampling(nums);
        obj.reset();
        obj.shuffle();
    }
}
