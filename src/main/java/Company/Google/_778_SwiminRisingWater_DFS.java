package Company.Google;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 * Created by zhang on 2018/5/21.
 * 重点是 这个2D的数组里 每个值是他的海拔 每一秒都下雨
 * 当海拔跟四周相等之后 才可以游过去
 * 要求 求出最少多少秒才可以 游到右下角
 0  1  2  3  4
 24 23 22 21  5
 12 13 14 15 16
 11 17 18 19 20
 10  9  8  7  6
 维护一个priorityqueue 每次最小的高度 同时维持当前最大的值
 */
// O(n^2 logn)
public class _778_SwiminRisingWater_DFS {
    /**
     * Let's keep a priority queue of which square we can walk in next. We always walk in the smallest one that is 4-directionally adjacent to ones we've visited.
     *
     * When we reach the target, the largest number we've visited so far is the answer.
     *
     * Time Complexity: O(N^2 \log N)O(N
     * 2
     *  logN). We may expand O(N^2)O(N
     * 2
     *  ) nodes, and each one requires O(\log N)O(logN) time to perform the heap operations.
     *
     * Space Complexity: O(N^2)O(N
     * 2
     *  ), the maximum size of the heap.
     * */
    public int swimInWater_PQ(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (grid[a[0]][a[1]] - grid[b[0]][b[1]]));
        pq.add(new int[]{0, 0});
        int level = 0;
        int n = grid.length;
        int[][] nexts = {{0 ,1}, {0, -1},{1, 0}, {-1, 0}};
        boolean[][] isVisited = new boolean[n ][n];
        while (!pq.isEmpty()){
            int[] top = pq.poll();
            level = Math.max(level, grid[top[0]][top[1]]);
            if (top[0] == n - 1 && top[1] == n - 1){
                break;
            }

            for (int[] next : nexts){
                int x = top[0] + next[0];
                int y = top[1] + next[1];
                if (!(x < 0|| x > n - 1 || y < 0 || y > n - 1)  && !isVisited[x][y]){
                    isVisited[top[0]][top[1]] = true;
                    pq.add(new int[]{x, y});
                }
            }
        }
        return level;
    }


/**
 * Whether the swim is possible is a monotone function with respect to time, so we can binary search this function for the correct time: the smallest T for which the swim is possible.
 *
 * Say we guess that the correct time is T. To check whether it is possible, we perform a simple depth-first search where we can only walk in squares that are at most T.
 *
 * Time Complexity: O(N^2 \log N)O(N
 * 2
 *  logN). Our depth-first search during a call to possible is O(N^2)O(N
 * 2
 *  ), and we make up to O(\log N)O(logN) of them.
 *
 * Space Complexity: O(N^2)O(N
 * 2
 *  ),
 * */
    public static int swimInWater_BS_DFS(int[][] grid) {
        int N = grid.length;
        int lo = grid[0][0], hi = N * N;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!possible(mi, grid)) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }

    public static boolean possible(int T, int[][] grid) {
        int N = grid.length;
        Set<Integer> seen = new HashSet();
        seen.add(0);
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        Stack<Integer> stack = new Stack();
        stack.add(0);

        while (!stack.empty()) {
            int k = stack.pop();
            int r = k / N, c = k % N;
            if (r == N-1 && c == N-1) return true;

            for (int i = 0; i < 4; ++i) {
                int cr = r + dr[i], cc = c + dc[i];
                int ck = cr * N + cc;
                if (0 <= cr && cr < N && 0 <= cc && cc < N
                        && !seen.contains(ck) && grid[cr][cc] <= T) {
                    stack.add(ck);
                    seen.add(ck);
                }
            }
        }

        return false;
    }
    public static void main(String[] args){
        int[][] grid = new int[][]{{0,2},{1,3}};
        swimInWater_BS_DFS(grid);
    }
}
