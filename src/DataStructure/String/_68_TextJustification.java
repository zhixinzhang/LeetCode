package DataStructure.String;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Luke(New Man) Zhang
 * @Date: 2021/1/6 23:26
 * Link :
 * Description:
 * https://leetcode.com/problems/text-justification/discuss/1005142/Java-Concise-Solution-Beats-100
 *
 * First we need to calculate how many words can be filled in a line. Using two pointers i and j to specify words[i, j] can be filled in a line. Then there has 3 cases need to consider:
 *
 * Last line: it should be left justified and no extra space is inserted between words.
 * Only one word in a line: just left justified, append space in the rest.
 * Regular justify: we need to calculate how many spaces in the line and how many extra spaces we need to assign from left to right.
 */
public class _68_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i = 0, n = words.length;
        if (words == null || words.length == 0) {
            return ans;
        }
        while(i < words.length) {
            int j = i, length = words[i].length();
            while(j + 1 < words.length && length + words[j + 1].length() + (j + 1 - i) <= maxWidth) {
                length += words[j + 1].length();
                j++;
            }

            StringBuilder sb = new StringBuilder();
            if(j == n - 1) { // Case 1: last line.
                while(i <= j) {
                    sb.append(words[i++]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1); // remove extra space in last word.
                while(sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else if(j - i == 0) { // Case 2: only one word in a line.
                sb.append(words[i]).append(" ");
                sb.deleteCharAt(sb.length() - 1); // remove extra space in last word.
                while(sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else { // Case 3: regular justify.
                int spaces = maxWidth - length;
                int space = spaces / (j - i);
                int extra = spaces % (j - i);
                while(i < j) {
                    sb.append(words[i++]);
                    if(extra-- > 0) sb.append(" "); // fill extra space.
                    for(int k=0; k<space; k++) sb.append(" "); // fill space.
                }
                sb.append(words[i]); // append the last word.
            }
            i = j + 1;
            ans.add(sb.toString());
        }
        return ans;
    }
}
