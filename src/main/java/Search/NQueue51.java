package Search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2017/2/26.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
 * both indicate a queen and an empty space respectively.
 */
public class NQueue51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n<0) return  result;
        int[]  c = new int[n];
        dfs(c,0,result);
        return  result;
    }

        private void dfs(int[]  c,int row, List<List<String>> result) {
            final int N = c.length;
            for (int i = 0;i<N;i++){
                //判斷是否可以 添加點
//                isValid(N,c,result);

            }
            if(row == N){


            }


        }

    }
