package Company.uber;

/**
 * Created by zhang on 2018/9/15.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=432148&ctid=201324
 */
// 原题是把字典里所有的字符串都加厚
// uber follow up 只加一个
public class _616_AddBoldTaginString_followUp {
    public static void main(String[] args){
        addBoldTag("aaabbcc", new String[]{"aaa","aab","bc"});
    }
    public static String addBoldTag(String s, String[] dict) {
        int n = s.length();
        int[] mark = new int[n+1];
        for(String d : dict) {
            int i = -1;
            while((i = s.indexOf(d, i+1)) >= 0) {
                mark[i]++;
                mark[i + d.length()]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i = 0; i <= n; i++) {
            int cur = sum + mark[i];
            if (cur > 0 && sum == 0) sb.append("<b>");
            if (cur == 0 && sum > 0) sb.append("</b>");
            if (i == n) break;
            sb.append(s.charAt(i));
            sum = cur;
        }
        return sb.toString();
    }

    public static String addBoldTag_followUp(String s, String[] dic){
        int l = s.length();
        int[] bold = new int[l+1];
        for (String c : dic){
            int i = s.indexOf(c);
            if (i >= 0){
                bold[i] = 1;
                bold[i+c.length()] = -1;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < l; i++){
            int cur = sum + bold[i];
            if (cur > 0 && sum == 0) sb.append("<b>");
            if (cur == 0 && sum > 0) sb.append("</b>");
            if (i == l) break;
            sb.append(s.charAt(i));
            sum = cur;
        }
        return sb.toString();
    }
}
