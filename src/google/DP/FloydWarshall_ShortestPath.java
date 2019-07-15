package google.DP;

/**
 * Created by zhang on 2018/7/3.
 */
public class FloydWarshall_ShortestPath {
    public void solution(){
        int v = 10;
        int[][] graph = new int[v][v];
        int[][] dist = new int[v][v];
        int i,j,k;
        for (i = 0; i<v; i++){
            for (j = 0; j<v; j++){
                dist[i][j] = graph[i][j];
            }
        }

        for (k = 0; k < v; k++){
            for (i = 0; i < v; i++) {
                for (j = 0; j < v; j++){
                    if (dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

    }
}
