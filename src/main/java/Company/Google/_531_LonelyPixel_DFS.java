package google;

import java.util.Arrays;

/**
 * Created by zhang on 2018/5/29.
 * 跟200 不一样
 */
public class _531_LonelyPixel_DFS {
    public static int findLonelyPixel(char[][] picture) {
        int n = picture.length, m = picture[0].length;

        int[] rowCount = new int[n], colCount = new int[m];
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                if (picture[i][j] == 'B') { rowCount[i]++; colCount[j]++; }

        int count = 0;
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                if (picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) count++;

        return count;
    }
    public static void main(String[] args){
        findLonelyPixel(new char[][]{{'W', 'W', 'B'},{'W', 'B', 'W'},{'B', 'W', 'W'}});
    }
}
