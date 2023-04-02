package Company.Google;
import java.util.*;
/**
 * Created by zhang on 2018/5/17.
 *dfs 跟普通dfs不一样的是 每次要查是不是能飞
 *
 */
public class _568_MaximumVacationDays_DFS {
        public int maxVacationDays(int[][] flights, int[][] days) {
            int N = flights.length, K = days[0].length;
            int[][] cache = new int[K][N];
            for(int i = 0; i<K; i++){
                Arrays.fill(cache[i],-1);
            }
            return dfs(flights,days,0,0,cache); // city 0 week 0
        }
    public int dfs(int[][] flights, int[][] days, int k, int i, int[][] cache){
        int N = flights.length, K = days[0].length;
        if(k == K)  return 0;
        if(cache[k][i] >= 0)    return cache[k][i];
        int max = 0;
        for(int j = 0; j<N; j++){
            if(i == j || flights[i][j] == 1){
                int temp = dfs(flights, days, k+1, j, cache) + days[j][k];
                max= Math.max(temp, max);
            }
        }
        cache[k][i] = max;
        return max;
        }
    }
