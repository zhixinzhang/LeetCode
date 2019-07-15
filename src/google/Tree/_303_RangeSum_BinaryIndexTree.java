package google.Tree;

/**
 * Created by zhang on 2018/6/21.
 * https://www.jianshu.com/p/138db8b4419b
 */
public class _303_RangeSum_BinaryIndexTree {
    int[] nums;
    int[] BIT;

    public void NumArray(int[] nums){
        this.nums = nums;
        BIT = new int[nums.length + 1];
        for(int i = 1; i<BIT.length; i++){
            while (i < BIT.length){
                BIT[i] += nums[i];
                i += i &(-i);
            }
        }
    }

    public int sumRange(int i, int j){
        return getSum(j+1) - getSum(i);
    }
    public int getSum(int i){
        int sum = 0;
        while (i > 0){
            sum += BIT[i];
            i -= i &(-i);
        }
        return sum;
    }

    public void update(int index, int val){
        val -= nums[index];
        nums[index] = val;
        updateBIT(index, val);
    }
    public void updateBIT(int index, int diff){
        index ++;
        while (index < BIT.length){
            BIT[index] += diff;
            index += (index & -index);
        }
    }
}
