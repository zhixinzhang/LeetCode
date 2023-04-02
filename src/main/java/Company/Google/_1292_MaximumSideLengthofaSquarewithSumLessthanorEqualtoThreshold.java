package google;

import java.util.HashMap;
import java.util.Map;
/**
 * @author Luke Zhang
 * @Date 2020-01-01 14:37
 */
public class _1292_MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold {
    public int maxSideLength(int[][] mat, int threshold) {
        int res = 0;
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return res;

        // build sum matrix
        int row = mat.length, col = mat[0].length;
        int[][] sumMat = new int[row][col];
        sumMat[0][0] = mat[0][0];
        for (int i = 1; i < row; i++)
            sumMat[0][i] = sumMat[0][i - 1] + mat[0][i];
        for (int i = 1; i < col; i++)
            sumMat[i][0] = sumMat[i - 1][0] + mat[i][0];
        for (int i = 1; i < row; i ++){
            for (int j = 1; j < col; j ++){
                sumMat[i][j] = sumMat[i - 1][j] + sumMat[i][j-1] - sumMat[i - 1][j - 1] + mat[i][j];
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = Math.max(row, col);
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                for (int l = 1; l <= maxLen; j++){
                    if (i + l >= row || j + l >= col) continue;
                    int curSquareVal = sumMat[i + l][j + l] - sumMat[i][j];
                    map.putIfAbsent(curSquareVal, 0);
                    map.put(curSquareVal, map.get(curSquareVal) + 1);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int squarVal = entry.getKey();
            int count = entry.getValue();
            if (squarVal <= threshold)
                res = Math.max(count, res);
        }
        return res;
    }
}
