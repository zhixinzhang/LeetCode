package Company.Houzz;

/**
 * Created by zhang on 2018/1/17.
 */
/**
 *n = 1            2
 *   1             1
 *                    2
 *                 2
 *               1
 * */
public class _96_UniqueBinarySearchTrees_DP {
    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for(int i = 1; i<= n;i++){                    // i represent root  j represent left children num
            for(int j = 0; j<i ;j++){
                res[i]  +=  res[j] * res[i-j-1];                             //res[i] mean i as root
            }
        }

        return res[n];
    }
}
