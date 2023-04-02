package Company.Google.Array;

/**
 * Created by zhang on 2018/8/8.
 */
public class _135_Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len-1] = 1;
        for (int i = 1; i<len; i++){
            if (ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
            }else {
                left[i] = 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
            else
                right[i] = 1;
        }
        int res = 0;
        for (int i = 0; i<len; i++){
            res += Math.max(left[i],right[i]);
        }
        return res;
    }
}
