package Company.Thumbtack;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Luke Zhang
 * @Date 2021-06-07 15:39
 *
 * https://www.1point3acres.com/bbs/thread-570239-1-1.html
 */
public class NGrams {
    public static void main(String[] args){
        int n = 3;
        List<List<String>> file = new ArrayList<>();
        file.add(Arrays.asList("abcdefg", "defg"));
        file.add(Arrays.asList("abcdefg", "defg"));
        file.add(Arrays.asList("abcdefg", "abc"));

        HashMap<String, Integer> nGramCount = new HashMap<>();
        for (List<String> ss : file){
            for (String s : ss){
                if (s.length() >= 3){
                    StringBuilder sb = new StringBuilder(s.substring(0, n));
                    nGramCount.put(sb.toString(), nGramCount.getOrDefault(sb.toString(), 0) + 1);
                    for (int i = n; i < s.length(); i++){
                        sb.deleteCharAt(0);
                        sb.append(s.charAt(i));
                        nGramCount.put(sb.toString(), nGramCount.getOrDefault(sb.toString(), 0) + 1);
                    }
                }
            }
        }

        for (Map.Entry<String, Integer> entry : nGramCount.entrySet()){
            System.out.println(entry.getKey() + " count : " + entry.getValue());
        }
    }
}
