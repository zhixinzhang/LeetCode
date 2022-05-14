package Company.Houzz;

/**
 * Created by zhang on 2018/1/21.
 */
//O(logn)
public class _74_Searcha2DMatrix_BinarySearch {
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
