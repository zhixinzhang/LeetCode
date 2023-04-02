package google;

/**
 * Created by zhang on 2018/5/15.
 */
public class _803_BricksFallingWhenHit_UF {
    class UnionFind{
        int[] father;
        int[] count;
        UnionFind(int len){
            father = new int[len];
            count = new int[len];
            for (int i = 0; i<len; i++){
                father[i] = i;
                count[i] = 1;
            }
        }

        int find(int toFind){
            while (father[toFind] != toFind){
                father[toFind] = father[father[toFind]];
                toFind = father[toFind];
            }
            return toFind;
        }
        void union(int a, int b){
            int fatherA = find(a);
            int fatherB = find(b);
            if (fatherA != fatherB){
                father[fatherA] = fatherB;
                count[fatherB] += count[fatherA];
            }
        }
    }

    public int[] hitBricks(int[][] grid, int[][] hits){
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m*n+1);
        for (int[] hit : hits){
            if (grid[hit[0]][hit[1]] == 1){
                grid[hit[0]][hit[1]] = 2;
            }
        }
        for (int i = 0; i<m;i++){
            for (int j = 0; j<n;j++){
                if (grid[i][j] == 1){
                    unionAround(i,j,grid,uf);
                }
            }
        }
        int count = uf.count[uf.find(0)];
        int[] res = new int[hits.length];
        for (int i = hits.length - 1; i >=0 ; i--){
            int[] hit = hits[i];
            if (grid[hit[0]][hit[1]] == 2){
                unionAround(hit[0],hit[1],grid,uf);
                grid[hit[0]][hit[1]] =1 ;
            }
            int newCount = uf.count[uf.find(0)];
            res[i] = (newCount - count > 0) ? newCount - count - 1 : 0;
            count = newCount;
        }
        return res;
    }

    public void unionAround(int x, int y, int[][] grid, UnionFind uf){
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = new int[]{-1,1,0,1};
        int[] dy = new int[]{0,0,-1,1};
        for (int i = 0; i<4;i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextX >= m || nextY <0 || nextY >= n){
                continue;
            }
            if (grid[nextX][nextY] == 1){
                uf.union(x*n + y+ 1, nextX * n + nextY +1);
            }
        }
        if (x == 0){
            uf.union(x*n + y +1, 0);
        }
    }
}
