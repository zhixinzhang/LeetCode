package Company.Google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2017/12/5.
 */
/**matrix  每行梅列 如果有一个1 就输出 坐标*/
public class EachLineOnlyOne {
    public List<int[]> firstOne(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int[] rowArr = new int[n];
        int[] colArr = new int[m];
        List<int []> res = new ArrayList<>();
        for(int i = 0; i<n;i++){
            int curRowNum = 0;
            for(int j = 0; j<m;j++){
                if(matrix[i][j] == 1){
                    curRowNum  ++;
                }
            }
            rowArr[i] = curRowNum;
        }

        for(int i = 0; i<m;i++){
            int curColNum = 0;
            for(int j = 0; j<n;j++){
                if(matrix[i][j] == 1){
                    curColNum  ++;
                }
            }
            colArr[i] = curColNum ;
        }

        for (int i = 0 ; i< colArr.length;i++){
            if (colArr[i] == 1){
                int[] cur = new int[2];
                for (int j = 0; j<rowArr.length;j++){
                    if (rowArr[j] == 1)
                        cur[0] = cur[i];
                        cur[1] = rowArr[j];
                        res.add(cur);
                }
            }
        }
        return res;
    }

}
