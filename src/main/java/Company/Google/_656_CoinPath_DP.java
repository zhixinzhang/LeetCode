package google;
import java.util.*;
/**
 * Created by zhang on 2018/5/15.
 */
public class _656_CoinPath_DP {
    public List<Integer> cheapestJump(int[] A, int B) {
        int n = A.length;
        int[] c = new int[n]; // cost
        int[] p = new int[n]; // previous index
        int[] l = new int[n]; // length
        Arrays.fill(c, Integer.MAX_VALUE);
        Arrays.fill(p, -1);
        c[0] = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == -1) continue;
            for (int j = Math.max(0, i - B); j < i; j++) {
                if (A[j] == -1) continue;
                int alt = c[j] + A[i];
                if (alt < c[i] || alt == c[i] && l[i] < l[j] + 1) {
                    c[i] = alt;
                    p[i] = j;
                    l[i] = l[j] + 1;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        for (int cur = n - 1; cur >= 0; cur = p[cur]) path.add(0, cur + 1);
        return path.get(0) != 1 ? Collections.emptyList() : path;
    }


    public List<Integer> cheapestJump_fromRightToLeft(int[] A, int B) {
        List<Integer> res = new ArrayList<>();
        if(A==null || A.length<1 || A[A.length-1]<0){
            return res;
        }
        int[] forward = new int[A.length];
        int[] cost = new int[A.length];
        Arrays.fill(forward,-1);
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[A.length-1]=A[A.length-1];
        for(int i=forward.length-2;i>=0;i--){
            if(A[i]==-1){
                continue;
            }
            for(int j=i+1;j<=Math.min(i+B,A.length-1);j++){
                if(cost[i]>cost[j]+A[i]&&cost[j]!=Integer.MAX_VALUE){
                    cost[i]=cost[j]+A[i];
                    forward[i]=j;
                }
            }
        }

        if(cost[0]==Integer.MAX_VALUE){
            return res;
        }
        int k=0;
        while(k!=-1){
            res.add(k+1);
            k=forward[k];
        }
        return res;
    }

    public static int miniCost(int[] A, int B){
        // [1,2,4,-1,2] b = 2
        //  0 1 2  3 4
        int[] dp = new int[A.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = A[0];
        for (int i = 1; i<A.length; i++){
            for (int j = 1; j<= B; j++){
                if (i - j >= 0 && A[i-j] >= 0 && A[i]>=0){
                    dp[i] = Math.min(dp[i],dp[i - j] + A[i]);
                    int a = 0;
                }
            }
        }
        int res = dp[A.length-1];
        if (res == Integer.MAX_VALUE)
            return -1;
        return dp[A.length];
    }
    public static void main(String[] args){
        miniCost(new int[]{1,2,4,-1,2},2);
    }
}
