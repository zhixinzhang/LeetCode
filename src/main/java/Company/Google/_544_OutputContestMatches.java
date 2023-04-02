package Company.Google;
import java.util.*;
/**
 * Created by zhang on 2018/5/20.
 */
public class _544_OutputContestMatches {
    public String findContestMatch_Iteration(int n) {
        String[] m = new String[n];
        for (int i = 0; i < n; i++) {
            m[i] = String.valueOf(i + 1);
        }
        while (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                m[i] = "(" + m[i] + "," + m[n - 1 - i] + ")";
            }
            n /= 2;
        }
        return m[0];
    }


    public static String findContestMatch(int n) {
        if(n <= 0)  return "";
        List<String> l = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            l.add(String.valueOf(i));       // 1 2 3 4...8
        }
        recur(l,n);
        return l.get(0);
    }
    private static void recur(List<String> l, int n){
        if(n <= 2){
            l.set(0,"(" + l.get(0) +","+ l.get(1) + ")");
            return;
        }
        for(int i = 0;i<n/2 ;i++){
            String curS = "(" + l.get(i) + "," + l.get(n - i - 1) + ")";
            l.set(i,curS);
        }
        recur(l,n/2);
    }

    // 16  25  34
    // 1634 25
    public static void main(String[] args){
        findContestMatch(6);
    }
}
