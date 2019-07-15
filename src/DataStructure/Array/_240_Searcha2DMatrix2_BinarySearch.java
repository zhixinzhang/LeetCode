package DataStructure.Array;

/**
 * Created by zhang on 2018/3/26.
 * We start search the matrix from top right corner, initialize the current position to top right corner, if the target is greater than the value in current position, then the target can not be in entire row of current position because the row is sorted, if the target is less than the value in current position, then the target can not in the entire column because the column is sorted too.
 * We can rule out one row or one column each time, so the time complexity is O(m+n).
 */
// 从右上角开始搜索，如果target大就向左，如果target小 就往右
public class _240_Searcha2DMatrix2_BinarySearch {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
                return false;
            }
            int col = matrix[0].length - 1;
            int row = 0;
            while (col >= 0 && row <= matrix.length - 1){
                if (target == matrix[row][col])
                    return true;
                if (target < matrix[row][col]) {
                    col--;
                }else if (target > matrix[row][col]){
                    row++;
                }
            }
            return false;
        }
    }
