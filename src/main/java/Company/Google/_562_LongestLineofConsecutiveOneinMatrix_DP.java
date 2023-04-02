package google;


public class _562_LongestLineofConsecutiveOneinMatrix_DP{

	public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int[][][] dp = new int[4][M.length][M[0].length];
        int[] maxL = new int[4];
        int[] dx = {0, -1, -1, -1};
        int[] dy = {-1, 0, -1, +1};
        for (int x = 0; x < M.length; x++) {
            for (int y = 0; y < M[0].length; y++) {
                for (int i = 0; i < 4; i++) {
                    int lastX = x + dx[i];
                    int lastY = y + dy[i];
                    if (!isInBound(M, lastX, lastY)) {
                        dp[i][x][y] = M[x][y];
                    } else if (M[x][y] == 0) {
                        dp[i][x][y] = 0;
                    } else {
                        dp[i][x][y] = dp[i][lastX][lastY] + 1;
                    }
                    maxL[i] = Math.max(maxL[i], dp[i][x][y]);
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = Math.max(result, maxL[i]);
        }
        
        return result;
    }
    
    private boolean isInBound(int[][] M, int x, int y) {
        return x >= 0 && x < M.length && y >= 0 && y < M[0].length;
    }



	
}