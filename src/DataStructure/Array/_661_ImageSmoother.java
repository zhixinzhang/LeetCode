package DataStructure.Array;


public class _661_ImageSmoother{
	    public int[][] imageSmoother(int[][] M) {
           int m = M.length, n = M[0].length;
    for (int i=0; i<m; i++)
        for (int j=0; j<n; j++)
            for (int I=i-1; I<i+2; I++)
                for (int J=j-1; J<j+2; J++)
                    if (I >= 0 && I < m && J >= 0 && J < n)
                        M[i][j] += 256 + M[I][J] % 256 * 4096;
    for (int i=0; i<m; i++)
        for (int j=0; j<n; j++)
            M[i][j] = M[i][j] / 4096 / (M[i][j] / 256 % 16);
    return M;
    }
}