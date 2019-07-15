package DataStructure.Array;
import java.util.*;

/**
 * Created by zhang on 2018/5/4.
 */
public class _733_FloodFill_BFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return new int[0][0];
        }
        if (sr < 0 || sr >= image.length) {
            return image;
        }
        if (sc < 0 || sc >= image[0].length) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        int originalValue = image[sr][sc];
        if (originalValue == newColor) {
            return image;
        }
        image[sr][sc] = newColor;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dirs) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || x >= image.length) {
                    continue;
                }
                if (y < 0 || y >= image[0].length) {
                    continue;
                }
                if (image[x][y] != originalValue) {
                    continue;
                }
                image[x][y] = newColor;
                queue.offer(new int[]{x, y});
            }
        }
        return image;
    }
}
