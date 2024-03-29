package Company.Roblox;

/**
 * @Author: Luke(New Man) Zhang
 * @Date: 2021/1/6 23:11
 * Link :
 * Description:
 * https://leetcode.com/problems/rotate-image/editorial/
 * O(M) time
 */
public class _48_RotateImage {
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


    //

    public void rotate_(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
