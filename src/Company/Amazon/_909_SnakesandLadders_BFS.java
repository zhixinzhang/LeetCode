package Company.Amazon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/11/19
 * Time: 4:45 PM
 * Description:
 */


public class _909_SnakesandLadders_BFS {
    public static void main(){}
    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length <= 1) {
            return 0;
        }
        return shortestPath(board);
    }

    // BFS search
    public int shortestPath(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int step = 0;
        queue.add(1);
        visited.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int k = 1; k <= 6; k++) {
                    // check if the next one is board[i][j] or cur + k
                    int next = cur + k;
                    int[] index = squareToIndex(n, next);
                    int x = index[0], y = index[1];
                    if (board[x][y] > 0) {
                        next = board[x][y];
                    }
                    if (next >= n * n) {
                        return step;
                    }
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
        return -1;
    }

    private int[] squareToIndex(int n, int square) {
        int colFromLeft = (square - 1) % n;
        int rowFromBottom = (square - 1) / n;
        return new int[] {n - 1 - rowFromBottom, rowFromBottom % 2 == 0 ? colFromLeft : n - 1 - colFromLeft};
    }
}
