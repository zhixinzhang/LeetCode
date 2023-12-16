package AlgoSummary;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/21/19
 * Time: 4:25 PM
 * Description:
 * Based On 51_Nqueen and 52_NQueen2
 */


public class BackTracking_Template {
    int ans = 0;
    boolean[] col, diag1, diag2;
    public int totalNQueens(int n) {
        col = new boolean[n];
        diag1 = new boolean[2*n];
        diag2 = new boolean[2*n];
        dfs(0, n);
        return ans;
    }

    private void dfs(int currow, int n){
        if(currow == n){
            ans++;
            return;
        }
        for(int i = 0; i < n; i++){
            if(!col[i] && !diag1[i + currow] && !diag2[i - currow + n]){
                col[i] = true;
                diag1[i + currow] = true;
                diag2[i - currow + n] = true;
                dfs(currow + 1, n);
                col[i] = false;
                diag1[i + currow] = false;
                diag2[i - currow + n] = false;
            }
        }
    }
}
