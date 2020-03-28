package XianQiao;

public class NumberOfIsland_DFS {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 1, 0, 1, 1},
                {0, 1, 0, 1, 1},
                {0, 1, 0, 1, 1},
                {0, 1, 0, 1, 1},
                {0, 1, 0, 1, 1}};
        int result = numIslands(grid);
        System.out.println(result);
    }
    static int[][] directions = new int[][]{
            {0,1}, //index = 0
            {1,0}, //index = 1   directions[1] = dir  dir[0] = 1  dir[1] = 0
            {-1,0}, //directions[2] = dir  dir[0] = -1  dir[1] = 0
            {0,-1}//directions[3] = dir  dir[0] = 0  dir[1] = -1
    };
    public static int numIslands(int[][] grid){
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;

        int ans = 0;
        for (int y = 0; y < m; ++y)
            for(int x = 0; x < n; ++x)
                if (grid[y][x] == 1){
                    ++ans;
                    dfs(grid, x, y, n, m);
                }
        return ans;
    }
    private static void dfs(int[][] grid, int x, int y, int n, int m){
        if (x < 0 || y < 0 || x >= n || y >= m || grid[y][x] == 0)
            return;
        grid[y][x] = 0;
        System.out.println("current x = " + x + " y = " + y);
//        dfs(grid, x+1, y, n, m);
//        dfs(grid, x-1, y, n, m);
//        dfs(grid, x, y+1, n, m);
//        dfs(grid, x, y-1, n, m);
        for (int[] dir : directions){
            System.out.println(dir[0] + " " + dir[1]);
            dfs(grid, x+dir[0], y+dir[1], n, m);
        }
    }
}
