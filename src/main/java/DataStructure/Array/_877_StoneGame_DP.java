package DataStructure.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/16/19
 * Time: 3:06 PM
 * Description:
 * https://leetcode.com/problems/stone-game/solution/
 */


public class _877_StoneGame_DP {

    public boolean stoneGame_DP(int[] piles) {
        int N = piles.length;

        // dp[i+1][j+1] = the value of the game [piles[i], ..., piles[j]].
        int[][] dp = new int[N+2][N+2];
        for (int size = 1; size <= N; ++size)
            for (int i = 0; i + size <= N; ++i) {
                int j = i + size - 1;
                int parity = (j + i + N) % 2;  // j - i - N; but +x = -x (mod 2)
                if (parity == 1)
                    dp[i+1][j+1] = Math.max(piles[i] + dp[i+2][j+1], piles[j] + dp[i+1][j]);
                else
                    dp[i+1][j+1] = Math.min(-piles[i] + dp[i+2][j+1], -piles[j] + dp[i+1][j]);
            }

        return dp[1][N] > 0;
    }

    public boolean stoneGame(int[] piles) {
        int pickHead = piles[0];
        int pickTail = piles[piles.length-1];
        int sum = pickHead + pickTail;

        for(int i = 1; i < piles.length-1; i ++){
            sum += piles[i];
            int tmp = pickHead;
            pickHead = pickTail +  piles[i];
            pickTail = Math.max(tmp, pickTail);
        }

        int alex = Math.max(pickHead, pickTail);
        return  (sum - alex) < alex;
    }
}
