package google.Tree;

/**
 * Created by zhang on 2018/6/30.
 */
public class _307_RangeSumQueryMutable_SegmentTree {
    /**
     *  0 1  2    3    4    5   6 7 8 9 10 11
     *  (27)(23)(47)  (23)  (45) (67) 2 3 4 5 6  7
     *
     * */

    private int[] tree;
    int[] nums;
    int size;
    public void NumArray(int[] nums){
        this.nums = nums;
        if (nums.length > 0){
            size = nums.length;
            tree = new int[size * 2];
            buildSegmentTree(tree, nums);
        }
    }
    public void buildSegmentTree(int[] tree, int[] nums){
        for (int i = size, j = 0; j < nums.length; j++, i++){
            tree[i] = nums[j];
        }
        for (int i = size - 1; i > 0; i--){
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int i, int val){
        nums[i] = val;
        i += size;
        tree[i] = val;
        while (i > 0){
            int left = i;
            int right = i;
            if(i % 2 == 0){
                right = i + 1;
            }else {
                left = i - 1;
            }
            tree[i/2] = tree[left] + tree[right];
            i /= 2;
        }
    }

    public int sumRange(int i, int j){
        i += size;
        j += size;
        int sum = 0;
        while (i <= j){
            if (i % 2 != 0) {
                sum += tree[i];
                i++;
            }
            if (j % 2 != 1) {
                sum += tree[j];
                j--;
            }
            i /= 2;
            j /= 2;
        }
        return sum;
    }

}
