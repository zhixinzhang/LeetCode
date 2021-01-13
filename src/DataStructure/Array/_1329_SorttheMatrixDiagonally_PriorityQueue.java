package DataStructure.Array;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description:
 * Key Point:  https://leetcode.com/problems/sort-the-matrix-diagonally/solution/
 * 用PriorityQueue
 * Time complexity: \mathcal{O}(N \times M \times \log (\min(N, M)))O(N×M×log(min(N,M))), where NN is a number of rows and MM is a number of columns. We perform N \times MN×M operations in two nested loops. At each iteration, we push an element into a heap that contains the current diagonal.
 * The longest diagonal contains not more than \min(N, M)min(N,M) elements.
 *
 * Space complexity: \mathcal{O}(N \times M)O(N×M) to keep the hashmap with all input elements, where NN is a number of rows and MM is a number of columns.
 */

public class _1329_SorttheMatrixDiagonally_PriorityQueue {

    // hashmap to keep the diagonals
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                map.putIfAbsent(i - j, new PriorityQueue<>());
                map.get(i - j).add(mat[i][j]);
            }
        }

        // output
        // build output
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                mat[i][j] = map.get(i - j).poll();
            }
        }

        return mat;
    }
}
