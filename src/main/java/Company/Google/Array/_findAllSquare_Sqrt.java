package Company.Google.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/8/10.
 * 给一个数n，返回所有比n小，而且有两种方式（用两个数的平方相加的和）能表达的数。
 举例：85 = 2^2 + 9^2 = 6^2 + 7^2

 写完code，又follow-up问了test case，runtime，可以怎么优化等等，最后的最后，愉快的聊天中结束了。
 Timeline：
 06/29 报名
 07/11 兴趣爱好
 07/24 面试
 07/25 HC
 */
public class _findAllSquare_Sqrt {
    public static List<int[]> find(int n){
        List<int[]> res = new ArrayList<>();
        double c = Math.sqrt(n);
        int up = (int)Math.sqrt(n);
//        int[] range = new int[up];
        for (int i = 1; i<= up; i++){
            int l = i*i;
            int r = n - l;
            int rr = (int) Math.sqrt(r);
            if (rr * rr + l == n && i < rr)
                res.add(new int[]{i,rr});
        }
        return res;
    }
    public static void main(String[] args){
        find(85);
    }
}
