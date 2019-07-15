package DataStructure.Array;

/**
 * Created by zzx on 11/17/16.
 */
//迭代方法  还有数学方法
public class ClimbingStairs70_DP {
    public static int climbStairs(int n) {
        int prev = 0;
        int cur = 1;
        for(int i=1 ;i<=n;++i){
            int tmp = cur;
            cur += prev;
            prev = tmp;
        }
        return  cur;
    }

    public  static  void main(String[] args){
        int n = 5;
        int result = climbStairs(n);
    }
}
