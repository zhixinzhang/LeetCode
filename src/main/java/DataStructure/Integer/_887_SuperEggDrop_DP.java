package DataStructure.Integer;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/8/19
 * Time: 10:37 AM
 * Description:
 * https://leetcode.com/problems/super-egg-drop/
 * https://www.cnblogs.com/Phantom01/p/9490508.html
 * https://leetcode.com/problems/super-egg-drop/discuss/158974/C%2B%2BJavaPython-2D-and-1D-DP-O(KlogN)
 * https://leetcode.com/problems/super-egg-drop/discuss/159055/Java-DP-solution-from-O(KN2)-to-O(KNlogN)
 */


public class _887_SuperEggDrop_DP {

    /**
     * O(K * N^2)
     * 首先，这个题比较绕。需要求一个最优决策使得步数最小，但是实际的步数是随着真实结果变化而变化的。
     * 于是，为了保证在我们假设的步数内一定能够解完，我们可以假设每次决策都会得到最坏结果。
     *
     * dp[n][k] 表示用k个鸡蛋测n层最少需要多少步。
     * 我们可以枚举第一次在第i层扔鸡蛋，会得到两种结果:
     *
     * 鸡蛋坏掉: 我们接下来需要面对的情形是: 用 k-1 个鸡蛋来测量 i-1 层，所以最少需要 dp[i-1][k-1] 步。
     * 鸡蛋没坏: 我们接下来要面对的情形是: 用 k 个鸡蛋来测量 n-i 层，所以最少需要 dp[n-i][k] 步。
     * 因为我们总会面对最坏情况，所以，在第i层扔，会用 max(dp[i-1][k-1], dp[n-i][k]) + 1 步。
     * 所以我们的递推式如下:
     * dp[n][k] = min{ max(dp[i-1][k-1], dp[n-i][k]) + 1 } (1 <= i <= n)
     *
     *
     *     int MAXK = 100, MAXN = 100;
     *
     *     int max(int a, int b) {return a > b ? a : b;}
     *     int min(int a, int b) {return a < b ? a : b;}
     *
     *     int superEggDrop(int K, int N) {
     *         int dp[MAXN+2][MAXK+2];
     *         for (int i = 0; i <= MAXN; i++) {
     *             dp[i][0] = 0;
     *             dp[i][1] = i;
     *         }
     *         for (int j = 2; j <= MAXK; j++) {
     *             for (int i = 1; i <= MAXN; i++) {
     *                 dp[i][j] = i;
     *                 for (int k = 1; k < i; k++) {
     *                     dp[i][j] = min(dp[i][j], max(dp[k-1][j-1], dp[i-k][j]) + 1);
     *                 }
     *             }
     *         }
     *         return dp[N][K];
     *     }
    * **/



    public int superEggDrop(int K, int N) {
        int[][] memo = new int[K + 1][N + 1];
        return helper(K, N, memo);
    }
    private int helper(int K, int N, int[][] memo) {
        if (N <= 1) {
            return N;
        }
        if (K == 1) {
            return N;
        }
        if (memo[K][N] > 0) {
            return memo[K][N];
        }

        int low = 1, high = N, result = N;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int left = helper(K - 1, mid - 1, memo);
            int right = helper(K, N - mid, memo);
            result = Math.min(result, Math.max(left, right) + 1);
            if (left == right) {
                break;
            } else if (left < right) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        memo[K][N] = result;
        return result;
    }
}
