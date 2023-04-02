package Company.Google.DP;


/**
 * Created by zhang on 2018/6/11.
 */
public class scoreAmobee_DP {
    public int solution(String s, int k,int si,int sj){
        int[][] dp = new int[s.length()][s.length()];
        dp[0][0] = 0;
        for (int i = 0; i<s.length(); i++){
            for (int j = i; j<s.length(); j++){
                dp[i][j] = Math.max(dp[i][j-1],dp[i][j]);
            }
        }
        return dp[si][sj];
    }
}
