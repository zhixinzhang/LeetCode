package Company.Sony;

/**
 * Created by zhang on 2018/2/7.
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1
 */
public class _200_NumberofIslands_DFS_UnionFind {
    // O(row * col)
    public int numIslands_DFS(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1') {
                    search(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void search(char[][] grid, int x, int y) {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]!='1') return;
        grid[x][y] = '0';
        search(grid, x-1, y);
        search(grid, x+1, y);
        search(grid, x, y-1);
        search(grid, x, y+1);
    }


    public int numIslands_UF(char[][] grid) {
        if (grid.length == 0) return 0;
        
        int m = grid.length, n = grid[0].length, zeros = 0;
        UnionFind uf = new UnionFind(m*n);
        int[][] D = {{0,1}, {1,0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') { zeros++; continue; }
                for (int[] d : D) {
                    int x = i+d[0];
                    int y = j+d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                        uf.union(i*n+j, x*n+y);
                    }
                }
            }
        }
        
        return uf.size() - zeros;
    }

    public class UnionFind {

        private int[] parents;
        private int[] rank;
        private int num;
    
        public UnionFind(int N) {
            num = N;
            parents = new int[N];
            for (int i = 0; i < N; i++) parents[i] = i;
            rank = new int[N];
        }
    
        public int find(int i) {
            return (parents[i] == i) ? i : find(parents[i]);
        }
    
        public boolean union(int i, int j) {
            int pi = find(i), pj = find(j);
            if (pi == pj) return false;
            if (rank[pi] > rank[pj]) parents[pj] = pi;
            else {
                parents[pi] = pj;
                if (rank[pi] == rank[pj]) rank[pj]++;
            }
            num--;
            return true;
        }
    
        public int size() {
            return num;
        }

}
