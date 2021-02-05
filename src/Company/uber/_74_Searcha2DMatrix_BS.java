package Company.uber;

/**
 * Created by zhang on 2018/9/10.
 */
public class _74_Searcha2DMatrix_BS {
    //O(log m * n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;
        int mid;
        while(start <= end){
            mid = start + (end - start) / 2;
            int curI = mid / n;
            int curJ = mid % n;
            if(matrix[curI][curJ] == target)
                return true;
            if(matrix[curI][curJ] < target)
                start = mid + 1;

            if(matrix[curI][curJ] > target)
                end = mid - 1;

        }
        return false;
    }
}
