package Company.Google;

import java.util.TreeSet;

/**
 * Created by zhang on 2018/5/11.
 */
// 把二维数组 抽象成 一维数组！
// 求matrix 中和最大的那个矩阵
// 一堆arrat 找出连续的一段 和最大 不大于k
public class _363_MaxSumofRectangleNoLargerThanK_TreeSet {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;              //行
        int n = matrix[0].length;           // 列
        int res = Integer.MIN_VALUE;
        for (int left = 0; left<n; left++ ){        //案列扫
            int[] sums = new int[m];
            for (int right = left; right < n; right++){ // 向右侧列增加
                for (int i = 0; i<m; i++) {
                    sums[i] += matrix[i][right];
                }
                    TreeSet<Integer> set = new TreeSet<>();
                    set.add(0);
                    int cur = 0;
                    for (int sum : sums){       //当前列 最大的矩形面积
                        cur += sum;
                        Integer num = set.ceiling(cur - k);
                        if (num != null){
                            res = Math.max(res, cur - num);
                        }
                        set.add(cur);
                    }
                }
            }
        return res;
    }
    /**
     *
     *  nlogn   --- Binary search 但是这里不行
     *  用TreeSet
     *  nums 1 2 -3 4 5 6
     *  0 1 3 0 4 9 15          n+1 = n + n -1
     * */
//    public int helper(int[] nums, int k){
//        TreeSet<DataStructure.Integer> set = new TreeSet<>();
//        set.add(0);
//        int res = 0, sum = 0;
//        for (int i = 0; i<nums.length; i++){
//            sum += nums[i];
//            DataStructure.Integer num = set.ceiling(sum - k);
//            if (num != null){
//                res = Math.max(res, sum - num);
//            }
//            set.add(sum);
//        }
//    }
}
