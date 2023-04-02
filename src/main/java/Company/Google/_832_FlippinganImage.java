package google;

/**
 * Created by zhang on 2018/5/15.
 */
public class _832_FlippinganImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] res = new int[A.length][A[0].length];
        for(int i = 0; i< A.length; i++){
            int[] curRes = new int[A[0].length];
            for(int j = 0; j<A[0].length; j++){
                int idx = A[0].length - j - 1;
                curRes[idx] = A[i][j] == 0 ? 1 : 0;
            }
            res[i] = curRes;
        }
        return res;
    }
}
