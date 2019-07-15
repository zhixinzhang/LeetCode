package company.Amazon.UnionFind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/25/19
 * Time: 3:12 PM
 * Description:
 */
class UnionFind {
    int[] father;

    UnionFind(int len) {
        father = new int[len];
        for (int i = 0; i < len; i++) {
            father[i] = i;
        }
    }

    int find(int position) {
        while (father[position] != position) {
            father[position] = father[father[position]];
            position = father[position];
        }
        return position;
    }

    void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            father[fa] = fb;
        }


    }
}

public class _827_MakingALargeIsland_UnionFind {

    public void main(String[] args) {
        System.out.println("");
    }

    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // create father array and size array, and initialize them
        int[] father = new int[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            father[i] = i;
        }

        int[] size = new int[rows * cols];
        Arrays.fill(size, 1);

        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        // scan grid, update father array and size array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int id = i * cols + j;
                    for (int k = 0; k < 4; k++) {
                        int newi = i + dx[k];
                        int newj = j + dy[k];
                        int newid = newi * cols + newj;
                        if (isValid(rows, cols, newi, newj) && grid[newi][newj] == 1) {
                            union(father, size, id, newid);
                        }
                    }
                }
            }
        }

        // find current max component size
        int max = 0;
        for (int i = 0; i < size.length; i++) {
            max = Math.max(max, size[i]);
        }

        // find max component size if we set any 0 to 1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    int id = i * cols + j;
                    int combinedSize = 1;
                    Set<Integer> prevFather = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int newi = i + dx[k];
                        int newj = j + dy[k];
                        int newid = newi * cols + newj;
                        if (isValid(rows, cols, newi, newj) && grid[newi][newj] == 1) {
                            int currFather = find(father, newid);
                            if (prevFather.isEmpty() || !prevFather.contains(currFather)) {
                                combinedSize += size[currFather];
                                prevFather.add(currFather);
                            }
                        }
                    }
                    max = Math.max(max, combinedSize);
                }
            }
        }

        // return whole size if the grid is an all 1 matrix, otherwise return the value of max
        return max == 0 ? rows * cols : max;


    }

    public int find(int[] father, int id) {
        if (father[id] == id) {
            return id;
        }
        return father[id] = find(father, father[id]);
    }

    public void union(int[] father, int[] size, int id1, int id2) {
        int fa1 = find(father, id1);
        int fa2 = find(father, id2);
        if (fa1 != fa2) {
            father[fa1] = fa2;
            size[fa2] += size[fa1];
        }
    }

    public boolean isValid(int rows, int cols, int i, int j) {
        if (i >= 0 && i < rows && j >= 0 && j < cols) {
            return true;
        }
        return false;
    }


}
