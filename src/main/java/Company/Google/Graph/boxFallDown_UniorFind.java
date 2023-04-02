package Company.Google.Graph;

import java.util.*;
/**
 * Created by zhang on 2018/6/5.
 * 1. 类似之前一个面经题。只不过不是从天花板吊起来，而是从地上堆起来的盒子。给定一个grid和目标盒子的位置，问去掉目标盒子之后，哪些盒子会动。
 例如：. 围观我们@1point 3 acres
 OXXX. 一亩-三分-地，独家发布
 OOXO
 OOXO

 X是盒子，O是空气，相邻的盒子之间会有粘性。如果去掉第一行第三列的X，它左右相邻的两个会因为没有重力支持掉下来
 */
// 类似lc 803 都是UF的进一步思考 首先去除要要挪动的地方 然后uf整合， 整合之后看那个地方不连着底层
class  UnionFind{
    int[] father;
    UnionFind(int len){
        father = new int[len];
        for (int i = 0; i<len; i++){
            father[i] = i;
        }
    }
    int find(int poistion){
        while (father[poistion] != poistion){
            father[poistion] = father[father[poistion]];
            poistion = father[poistion];
        }
        return poistion;
    }
    void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if (fa != fb){
            father[fa] = fb;
        }
    }
}
public class boxFallDown_UniorFind {
    public static List<int[]> moveBox(char[][] grid, int[] move){
        List<int[]> res = new ArrayList<>();
        grid[move[0]][move[1]] ='O';
        if (grid == null || grid.length == 0 || grid[0].length == 0)    return res;
        int row = grid.length;
        int col = grid[0].length;
        UnionFind uf = new UnionFind(row * col + 1);
        for (int i = 0; i< row; i++){
            for (int j = 0; j<col; j++){
                    if (grid[i][j] == 'X'){
                        unionAround(i,j,grid,uf);
                    }
            }
        }
        int[] resArr = uf.father;
        int limit = (row-1)*col+1;
        for (int i = 0; i< row; i++){
            for(int j = 0; j<col; j++){
                if (grid[i][j] == 'X' && resArr[i * col + j] < limit){
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;
    }
    public static void  unionAround(int i, int j, char[][] grid, UnionFind uf){
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int row = grid.length;
        int col = grid[0].length;
        for (int[] d : dir){
            int nextX = d[0] + i;
            int nextY = d[1] + j;
            if (nextX >= 0 && nextX < row && nextY>=0 && nextY < col){
                if (grid[nextX][nextY] == 'X'){
                    uf.union(i * col + j + 1,nextX * col + nextY + 1);
                }
            }
        }
    }
    public static void main(String[] args){
        /**     o x x x            o x x x
         *      x x x o            x x o o
         *      o o x o            o o x o
         *
         *
         * **/
        moveBox(new char[][]{{'O','X','X','X'},{'X','X','X','O'},
                {'O','O','X','O'}},new int[]{1,2});
    }
}

