package DataStructure.Array;

/**
 * @author Luke(New Man) Zhang
 * @Date 4/5/2021 11:42 PM
 * <p>
 * Description:  n ^ 2
 * Similar task :
 * Key Point:  https://leetcode.com/problems/maximal-network-rank/discuss/1144968/Java-straightforward-solution.-n2-compare-all-nodes-twice
 */

public class _1615_MaximalNetworkRank_Graph {

    public int maximalNetworkRank(int n, int[][] roads) {
        int maxConnect = 0;
        int[] counts = new int[n];
        // build graph, if city number not Continuous need consider Hash
        boolean[][] cache = new boolean[n][n];          // default value is false
        for (int[] road : roads){
            cache[road[0]][road[1]] = true;         // two way connected
            cache[road[1]][road[0]] = true;
            counts[road[0]] ++;      // how many connections belong to this city
            counts[road[1]] ++;
        }

        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                int ijConnected = cache[i][j] ? -1 : 0;
                maxConnect = Math.max(maxConnect, counts[i] + counts[j] + ijConnected);
            }
        }

        return maxConnect;
    }
}
