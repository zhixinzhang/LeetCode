package Company.Rippling;

public class _1314_MatrixBlockSum_SlidingWindows {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] result = new int[m][n];

        int[] pre = new int[m];
        for(int i =0; i < m+k; i++) {
            int sum = 0;
            for(int j =0; j<n+k; j++) {

                if(i < m && j < n) {
                    pre[j] = pre[j] + mat[i][j];
                }
                if(i > k*2 && j < n) {
                    pre[j] = pre[j] - mat[i-(2*k)-1][j];
                }
                if(i >= k && j < n) {
                    sum = sum+ pre[j];
                }
                if(j>k*2 && i>=k)
                    sum = sum -pre[j-(k*2)-1];
                if(j>=k && i>=k)
                    result[i-k][j-k] = sum;

            }

        }

        return result;
    }
}
