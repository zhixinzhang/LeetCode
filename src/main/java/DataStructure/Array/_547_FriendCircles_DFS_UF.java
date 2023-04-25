package DataStructure.Array;
import java.util.*;

public class _547_FriendCircles_DFS_UF {
	public int findCircleNum_DFS(int[][] M) {
		if (M == null && M.length == 0)
			return 0;
		int n = M.length;
		boolean[] visited = new boolean[n];
		int count = 0;
		//如果dfs大于0，说明有未遍历的结点
		//只需要遍历所有结点
		for (int i = 0; i < n; i++)
			if (dfs(M, i, visited) > 0)
				count++;
		return count;
	}

	private int dfs(int[][] mat, int i, boolean[] visited) {
		if (visited[i])
			return 0;
		visited[i] = true;
		int count = 1;
		for (int j = 0; j < visited.length; j++)
			if (i != j && mat[i][j] == 1)
				count += dfs(mat, j, visited);
		return count;
	}

	Queue<Integer> q = new LinkedList<>();

	public void bfs(int[][] M, int[] visited, int i) {
		// visit[i];
		q.offer(i);
		visited[i] = 1;
		while (!q.isEmpty()) {
			int node = q.poll();
			for (int j = 0; j < M.length; j++) {
				// 未被访问过且是邻接点,注意是node的邻接点
				if (visited[j] == 0 && M[node][j] == 1) {
					// visit[j];
					q.offer(j);
					visited[j] = 1;
				}
			}
		}

	}

	public int findCircleNum_BFS(int[][] M) {
		int[] visited = new int[M.length];
		int count = 0;
		for (int i = 0; i < M.length; i++) {
			if (visited[i] == 0) {
				bfs(M, visited, i);
				count++;
			}
		}
		return count;
	}


	// UF 
	public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        int count = n;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (isConnected[i][j] == 1 && uf.find(i) != uf.find(j)) {
                    count--;
                    uf.union(i, j);
                }
            }
        }

        return count;
    }

    class UnionFind {
        int[] parent;
        int[] rank;
        
        public UnionFind(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
            rank = new int[n];
        }

        public int find(int x){
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int a, int b){
            int aP = find(a);
            int bP = find(b);
            if (aP == bP) {
                return;
            }
            if (rank[aP] < rank[bP]) {
                parent[aP] = bP;
            } else if (rank[aP] > rank[bP]){
                parent[bP] = aP;
            } else {
                parent[bP] = aP;
                rank[aP]++;
            }
        }
    }

}