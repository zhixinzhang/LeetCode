package DataStructure.Array;

/**
 * Created by zhang on 2017/1/26.
 */
public class RotateImage48 {

    public void rotate(int[][] matrix) {

        //水平对折
        int n = matrix.length;
        for(int i = 0;i < n/2; i++){
            for(int j = 0;j<n;j++){
                change(matrix,i,j,n-1-i,j);
            }
        }
        //主对角线对折
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                change(matrix,i,j,j,i);
            }
        }

    }
    private static void  change (final int[][] matrix,int i,int j,int p,int q){
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[p][q];
        matrix[p][q] = tmp;

    }
}
