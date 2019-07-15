package DataStructure.Array;

/**
 * Created by zhang on 2017/10/12.
 */
/**
 * 用递归方法  recursion
 * */
public class _59_SpiralMartix2 {
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
