package DataStructure.Integer;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/14/19
 * Time: 3:28 PM
 * Description:
 *
 * dp[i] represents whether a player can win given the number i if he is the first turn.
 */

public class _1025_DivisorGame_DP {
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N+1];
        dp[0] = true;
        dp[1] = false;
        for (int i = 1; i <= N; i++){
            for (int j = 1; j < i; j++){
                if( i % j == 0 && !dp[i - j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
}
