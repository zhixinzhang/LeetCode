package Company.Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/5/19
 * Time: 7:58 PM
 * Description:
 */


public class _22_GenerateParentheses_backtrack {

    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis_bc(int n) {
        if (n == 0)
            return ans;

        dfs(new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void dfs(StringBuilder sb, int leftParenth, int rightParent, int n){
        if (leftParenth > n ||  rightParent > n)
            return;

        if (leftParenth == rightParent && rightParent == n) {
            ans.add(sb.toString());
            return;
        }

        if (leftParenth > rightParent) {
            dfs(sb.append(')'), leftParenth, rightParent + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        dfs(sb.append('('), leftParenth + 1, rightParent, n);
        sb.deleteCharAt(sb.length() - 1);

    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if(n == 0) return ans;
        recursion(n,n,n,ans, "");
        return ans;
    }

    public void recursion(int n, int l, int r, List<String> ans, String s){
        if(s.length() == n * 2){
            ans.add(s);
        }else{
            if(l > 0) recursion(n,l-1,r,ans,s+"(");
            if(r > l) recursion(n,l,r-1,ans,s+")");
        }
    }
}
