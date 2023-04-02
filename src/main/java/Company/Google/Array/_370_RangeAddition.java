package google.Array;

/**
 * Created by zhang on 2018/6/22.
 *
 * 跟meetingroom 不一样的是 这个是每个点都加上一样的值 不用pq
 * 把每个operation的值操作 放到nums里
 * 比如[1 3 2]
 * -2 0 0 2 0
 */
public class _370_RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
            int[] nums = new int[length];
            for (int[] update : updates){
                nums[update[1]] += update[2];
                if (update[0] > 0)
                    nums[update[0] - 1] -= update[2];
            }
            for (int i = length - 2; i>=0; i--){
                nums[i] = nums[i+1] + nums[i];
            }
            return nums;
        }
    }
