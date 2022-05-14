package google.String;

/**
 * Created by zhang on 2018/7/31.
 * 第一题: Given a string with B*A*C*D* pattern, * means the preceding character can appear 0 or multiple times in the string. Count the number of 'A'.
 e.g., "BBAACCDDD", return 2
 "BBCDD", return 0
 "AAA", return 3
 Follow up: what if the string is so large that cannot be fitted in memory?


 Split the larger one into several parts until it can be fitted into memory, run bs on multiple machines, then merge the local results into a final one.
 The reason why it works is that no matter how many parts you split, the substring always follows *B*A*C*D pattern. . 一亩-三分-地，独家发布
 Actually, you can continue to optimize on single machine if the substring is still relatively larger. It's a little bit tricky.
 Hopefully, I have made myself clear.
 */
public class findAPattern_BS {
    public static void main(String[] args){
        solu("BBAACCDDD");
    }
    public static int solu(String s){
        char[] c = s.toCharArray();
        int len = c.length;
        if (s == null || s.length() == 0)
            return 0;
        if (c[0] == 'A' && c[len-1] == 'A')
            return len;
        int l = 0, r = len-1;
        int mid;
        while (l < r){
            mid = l + (r - l)/2;
            if (c[mid] == 'A'){
                if (c[l] == 'B')    l++;
                if (c[r] == 'C' || c[r]=='D') r--;
                if (c[l] == 'A' && c[r] == 'A') break;
            }else if (c[mid] == 'B'){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return r - l + 1;
    }
}
