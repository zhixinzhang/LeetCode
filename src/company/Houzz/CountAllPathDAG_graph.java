package company.Houzz;

/**
 * Created by zhang on 2018/1/21.
 */
//  https://www.geeksforgeeks.org/count-possible-paths-source-destination-exactly-k-edges/
//A simple solution is to start from u, go to all adjacent vertices and recur for
// adjacent vertices with k as k-1, source as adjacent vertex and destination as v.
//O(Vk) where V is the number of vertices in the given graph
public class CountAllPathDAG_graph {

    static final int V = 4; //Number of vertices

    // A naive recursive function to count walks from u
    // to v with k edges
    int countwalks(int graph[][], int u, int v, int k)
    {
        // Base cases
        if (k == 0 && u == v)           return 1;
        if (k == 1 && graph[u][v] == 1) return 1;
        if (k <= 0)                     return 0;

        // Initialize result
        int count = 0;

        // Go to all adjacents of u and recur
        for (int i = 0; i < V; i++)
            if (graph[u][i] == 1)  // Check if is adjacent of u
                count += countwalks(graph, i, v, k-1);

        return count;
    }

    // Driver method
    public static void main (String[] args) throws java.lang.Exception
    {
        /* Let us create the graph shown in above diagram*/
        int graph[][] =new int[][] { {0, 1, 1, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };
        int u = 0, v = 3, k = 2;
        CountAllPathDAG_graph p = new CountAllPathDAG_graph();
        System.out.println(p.countwalks(graph, u, v, k));
    }
    //We can optimize the above solution using Dynamic Programming.

    // A Dynamic programming based function to count walks from u
    // to v with k edges
    //O(V3K)
    int countwalks_DP(int graph[][], int u, int v, int k)
    {
        // Table to be filled up using DataStructure.DP. The value count[i][j][e]
        // will/ store count of possible walks from i to j with
        // exactly k edges
        int count[][][] = new int[V][V][k+1];

        // Loop for number of edges from 0 to k
        for (int e = 0; e <= k; e++)
        {
            for (int i = 0; i < V; i++)  // for source
            {
                for (int j = 0; j < V; j++) // for destination
                {
                    // initialize value
                    count[i][j][e] = 0;

                    // from base cases
                    if (e == 0 && i == j)
                        count[i][j][e] = 1;
                    if (e == 1 && graph[i][j]!=0)
                        count[i][j][e] = 1;

                    // go to adjacent only when number of edges
                    // is more than 1
                    if (e > 1)
                    {
                        for (int a = 0; a < V; a++) // adjacent of i
                            if (graph[i][a]!=0)
                                count[i][j][e] += count[a][j][e-1];
                    }
                }
            }
        }
        return count[u][v][k];
    }


}
