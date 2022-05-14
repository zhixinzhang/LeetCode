package DataStructure.Array;

/**
 * Created by zhang on 2017/10/7.
 * Write an efficient algorithm that searches for a value in an m x n matrix
 * Given target = 3, return true.
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 */
/*
* 在mn的矩阵中 判断是否能找到target
* 最差的办法 time o（mn）
* 因为是 sorted 所以可以用 binary search
* //bs的方法 也可以分为两种 第一种 把2d 变成 1d  唯一需要思考的是  变成1D之后  martix 的两个索引 mid/n   mid%n
* */
public class _78_Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        if(matrix[0].length == 0 || matrix[0] == null){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n -1;

        // binary search ---- trans 2D matrix to 1D Linked
        while (end >= start){
            int mid = start + (end - start)/2;
            //cur val  smaller or greater than cur val
            int locat_m = mid/n;
            int locat_n = mid%n;
            if (matrix[locat_m][locat_n] == target){
                return true;
            }else if (matrix[locat_m][locat_n] > target){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
        return false;
    }
}
