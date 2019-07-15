package DataStructure.Integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/21/19
 * Time: 3:58 PM
 * Description:
 */


public class _51_NQueens_BackTrack {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return ans;
        boolean[] col = new boolean[n];
        //2*n-1个斜对角线
        boolean[] dia1 = new boolean[2*n-1];
        boolean[] dia2 = new boolean[2*n-1];
        backtrack(n,new ArrayList<>(), col, dia1, dia2, 0);
        return ans;
    }

    private void backtrack(int n,List<String> list,boolean[] visited,boolean[] dia1,boolean[] dia2,int rowIndex) {
        if (rowIndex == n) {
            ans.add(new ArrayList<String>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            //这一行、正对角线、反对角线都不能再放了，如果发现是true，停止本次循环
            if (visited[i] || dia1[rowIndex + i] || dia2[rowIndex - i + n - 1])
                continue;

            //init一个长度为n的一维数组，里面初始化为'.'
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');

            charArray[i] = 'Q';
            String stringArray = new String(charArray);
            list.add(stringArray);
            visited[i] = true;
            dia1[rowIndex + i] = true;
            dia2[rowIndex - i + n - 1] = true;

            backtrack(n, list, visited, dia1, dia2, rowIndex + 1);

            //reset 不影响回溯的下个目标
            list.remove(list.size() - 1);
            charArray[i] = '.';
            visited[i] = false;
            dia1[rowIndex + i] = false;
            dia2[rowIndex - i + n - 1] = false;
        }
    }
}
