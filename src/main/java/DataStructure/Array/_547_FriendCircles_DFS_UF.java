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

}