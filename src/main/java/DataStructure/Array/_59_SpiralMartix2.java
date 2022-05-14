package DataStructure.Array;

/**
 * Created by zhang on 2021/5/13.
 */
/**
 * 1. use iterative
 * 2. 用递归方法  recursion
 * */
public class _59_SpiralMartix2 {
    public int[][] generateMatrix_iterative(int n) {
        // Declaration
        int[][] matrix = new int[n][n];

        // Edge Case
        if (n == 0) {
            return matrix;
        }

        // Normal Case
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int num = 1; //change

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i ++) {
                matrix[rowStart][i] = num ++; //change
            }
            rowStart ++;

            for (int i = rowStart; i <= rowEnd; i ++) {
                matrix[i][colEnd] = num ++; //change
            }
            colEnd --;

            for (int i = colEnd; i >= colStart; i --) {
                if (rowStart <= rowEnd)
                    matrix[rowEnd][i] = num ++; //change
            }
            rowEnd --;

            for (int i = rowEnd; i >= rowStart; i --) {
                if (colStart <= colEnd)
                    matrix[i][colStart] = num ++; //change
            }
            colStart ++;
        }

        return matrix;
    }

    //
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n <= 0){
            return new int[0][0];
        }
        int[] cur = {0};
        onceSpiral(res,cur,n,0);
        return res;
    }

    private void onceSpiral(int[][] res, int[] cur, int size, int offset){
        if (size == 0){
            return;
        }
        if (size == 1){
            res[offset][offset] = ++cur[0];
            return;
        }

        //left to right
        for(int i = offset; i < size -1 + offset; i++){
            res[offset][i] = ++cur[0];
        }
        //top to bot
        for(int i = offset; i < size -1 + offset; i++){
            res[i][size-1+offset] = ++cur[0];
        }
        //right to left
        for(int i = size - 1 + offset; i > offset; i--){
            res[size - 1 + offset][i] = ++cur[0];
        }

        //4. left col
        for(int i = size - 1 + offset; i > offset; i--) {
            res[i][offset] = ++cur[0];
        }

        onceSpiral(res, cur, size - 2, offset + 1);
    }
}
