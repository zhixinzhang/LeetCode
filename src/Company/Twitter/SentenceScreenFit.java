package Company.Twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Luke Zhang
 * @Date 2021-06-12 15:57
 *
 * Write an program which takes a very long sentence as input. The program splits the long sentence into smaller lines such that each line should be less than or equal to 200 characters. Each line should also contain line information at the end( The limit of 200 character is inclusive of this limit). It should not break words into pieces. If a word does not fit in 200 character line it should go to the next line.
 *
 * example : Input : "This is a word wrap question with dynamic line information and I am confused how to solve..."
 */
public class SentenceScreenFit {
    static int suffix = 5;
    public static void main(String[] args){
        String s = "This is a word wrap question with dynamic line information and I am confused how to solve";
        int len = 100;
        List<String> sentences = find(s, len);
    }


    private static List<String> find(String sentence, int len){
        List<String> ans = new ArrayList<>();
        String[] words = sentence.split(" ");
        int totalLen = len - suffix;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        while (right < words.length){
            int curLen = sb.length() + words[right].length() + 1;
            if (curLen <= totalLen) {
                sb.append(words[right]);
                sb.append(" ");
                right++;
            } else {
                ans.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        if (sb.length() != 0) {
            ans.add(sb.toString());
        }

        for (int i = 0; i < ans.size(); i++){
            String curSen = ans.get(i);
            char[] array = new char[totalLen - curSen.length()];
            Arrays.fill(array, ' ');
            curSen += new String(array);
            String s = String.format("%s(%s/%s)", curSen, String.valueOf(i + 1), String.valueOf(ans.size()));
            System.out.println(s);
        }

        return ans;
    }
}
