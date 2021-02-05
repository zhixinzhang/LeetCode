package Company.zillow.String;

/**
 * Created by zhang on 2018/9/25.
 */
public class _186_ReverseWordsinaString2_ {
    public void reverseWords(char[] str) {
        reverse(str,0,str.length - 1);
        int start = 0;
        int end = 0;

        while (end < str.length) {
            while (end < str.length && str[end] != ' ') {
                end++;
            }
            reverse(str,start,end - 1);
            start = end + 1;
            end = start;
        }
    }

    public void reverse(char[] str, int start, int end) {
        if (start > end) {
            return;
        }
        for (; start < end; start++, end--) {
            char c = str[start];
            str[start] = str[end];
            str[end] = c;
        }
    }
}
