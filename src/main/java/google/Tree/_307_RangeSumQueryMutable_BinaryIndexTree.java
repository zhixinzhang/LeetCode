package google.Tree;

/**
 * Created by zhang on 2018/4/30.
 */
//https://leetcode.com/problems/range-sum-query-mutable/discuss/75753/Java-using-Binary-Indexed-Tree-with-clear-explanation
//https://blog.csdn.net/dreamgchuan/article/details/51173561
/**
 * 	 * Binary Indexed Trees (BIT or Fenwick tree):
 * https://www.topcoder.com/community/data-science/data-science-
 * tutorials/binary-indexed-trees/
 *
 * Example: given an array a[0]...a[7], we use a array BIT[9] to
 * represent a tree, where index [2] is the parent of [1] and [3], [6]
 * is the parent of [5] and [7], [4] is the parent of [2] and [6], and
 * [8] is the parent of [4]. I.e.,
 *
 * BIT[] as a binary tree:
 *            ______________*
 *            ______*
 *            __*     __*
 *            *   *   *   *
 * indices: 0 1 2 3 4 5 6 7 8
 *
 * */
public class _307_RangeSumQueryMutable_BinaryIndexTree {
    int[] nums;
    int[] BIT;
    int n;
    public _307_RangeSumQueryMutable_BinaryIndexTree(int[] nums) {
        this.nums = nums;
        n = nums.length;
        BIT = new int[n+1];
        for(int i = 0; i < n; i++){
            init(i,nums[i]);
        }
    }
    public void init(int i, int val){
        i++;
        while(i <= n){
            BIT[i] += val;
            i += (i & -i);
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i,diff);
    }

    public int sumRange(int i, int j) {
//        return getSum(j) - getSum(i - 1);
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

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        int a = (int) Math.sqrt(9);

        _307_RangeSumQueryMutable_BinaryIndexTree s = new _307_RangeSumQueryMutable_BinaryIndexTree(nums);
        s.sumRange(5,7);
    }
}
