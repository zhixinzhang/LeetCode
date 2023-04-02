package Company.Google;

import java.util.*;

/**
 * Created by zhang on 2018/5/19.
 *
 * 我们能知道有多少个 lock 用dfs搜索 其实很简答 注意recover set 还有字符串
 * 我自己写的
 */
public class _753_CrackingtheSafe_DFS {
    static int total;
    public static String crackSafe(int n, int k) {
        if(n == 0 || k <= 0) return "";
        StringBuilder sb = new StringBuilder();
        total = (int) Math.pow(k,n);
        for (int i = 0; i<n;i++){sb.append("0");}
        HashSet<String> visited = new HashSet<>();
        visited.add(sb.toString());
        dfs(sb, visited, n,k);
        return sb.toString();
    }
    public static boolean dfs(StringBuilder sb, HashSet<String> visited, int n, int k){
        if (visited.size() == total)    return true;
        String prev = sb.substring(sb.length() - n + 1, sb.length());
        for (int i = 0; i < k; i++){
            String next = prev + i;
            if (!visited.contains(next)){
                visited.add(next);
                sb.append(i);
                if (dfs(sb,visited,n,k))
                    return true;
                visited.remove(next);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return false;
    }
    public static void main(String[] args){
        String c = crackSafe(3,2);
    }

}
