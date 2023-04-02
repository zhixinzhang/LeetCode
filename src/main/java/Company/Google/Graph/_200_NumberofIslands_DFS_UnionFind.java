package Company.Google.Graph;

/**
 * Created by zhang on 2018/7/4.
 */
public class _200_NumberofIslands_DFS_UnionFind {
    class UnionFind{
        int[] father;
        int m,n;
        int count = 0;
        UnionFind(char[][] grid){
            m = grid.length;
            n = grid[0].length;
            father = new int[m*n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        int id = i * n + j;
                        father[id] = id;
                        count++;
                    }
                }
            }
        }
        public void union(int a, int b){
            int pa = find(a, father);
            int pb = find(b,father);
            if(pa != pb){
                father[pa] = pb;
                count--;
            }

        }
//        public int find(int a, int[] father){
//            while(father[a] != a){
//                father[a] = father[father[a]];
//                a = father[a];
//            }
//            return a;
//        }
        // find root and make root as parent of i (path compression)
        public int find(int a, int[] father){
            if(father[a] != a)
                father[a] = find(father[a],father);
            return father[a];
        }

    }
    int[][] distance = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands_UF(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for(int i = 0;i<m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    for(int[] d: distance){
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                            int id1 = i*n+j;
                            int id2 = x*n+y;
                            uf.union(id1, id2);
                        }
                    }
                }

            }
        }

        return uf.count;
    }



    public int numIslands_DFS(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(i,j,grid);
                }
            }
        }
        return res;
    }
    public void dfs(int i, int j, char[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if(grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}
