package Company.Doordash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/discuss/interview-question/1522955/Doordash-Onsite
// 从dashmart位置开始bfs，得出所有点距离dashmart额距离，最后算
// O(m*n + k) k is numerb of locations
public class _Dashmart_BFS {
    public static void main(String[] args) {
        // findMinDistance();
    }

    static int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static List<Integer> findMinDistance(char[][] cityMap, List<int[]> deliveryLocations) {
        List<Integer> res = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < cityMap.length; i++) {
            for (int j = 0; j < cityMap[0].length; j++) {
                if (cityMap[i][j] == 'D') 
                    queue.add(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < 0 || c < 0 || r >= cityMap.length || c >= cityMap[0].length || cityMap[r][c] != ' ') continue;
                cityMap[r][c] = (char) (cityMap[row][col] + 1);
                queue.add(new int[]{r, c});
            }
        }
        for (int[] deliveryLocation : deliveryLocations) {
            int i = deliveryLocation[0];
            int j = deliveryLocation[1];
            res.add(cityMap[i][j] - 'D');
        }
        return res;
    }
}
