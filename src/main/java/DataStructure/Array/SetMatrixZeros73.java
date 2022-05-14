package DataStructure.Array;

import java.util.Arrays;

/**
 * Created by zhang on 2017/1/30.
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.


 */
public class SetMatrixZeros73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m]; //行是否有0
        boolean[] col = new boolean[n]; //列是否有0


        //martix[m][n]
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j] == 0){
                    row[i] = col[j] = true;
                }
            }
        }
        for(int i = 0;i<m;++i){
            if(row[i]){
                Arrays.fill(matrix[i],0);
            }
        }

        for(int j = 0;j<n;++j){
            if(col[j] == true){
                for(int i=0;i<m;i++){
                    matrix[i][j] =0;
                }
            }
        }
    }




}
