package google;

/**
 * Created by zhang on 2018/5/22.
 */
public class _758_BoldWordsinString_int {
    public static String boldWords(String[] words, String S) {
        if(words.length == 0)   return S;
        //["ab", "bc"]  --- "aabcd"  "01110"
        int[] flag = new int[S.length()+1];
        for(String s : words){
            int index = S.indexOf(s);
            int right = index + s.length()-1;
            while (index <= right){
                flag[index] = 1;
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int n = S.length();
        int[] mark = new int[n+1];
        for(int i = 0; i <= n; i++) {
            int cur = sum + mark[i];
            if (cur > 0 && sum == 0) sb.append("<b>");
            if (cur == 0 && sum > 0) sb.append("</b>");
            if (i == n) break;
            sb.append(S.charAt(i));
            sum = cur;
        }
        return sb.toString();
    }
    public static void main(String[] args){
        boldWords(new String[]{"ab", "bc"},"aabcd");
    }
}
