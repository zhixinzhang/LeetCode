package Company.zillow.String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhang on 2018/8/21.
 */
public class _151_reverseStringWordByWord {
    public static void main(String[] args){
        reverse("a good   example");
    }
    public static String reverse(String s){
        String[] sArray = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = sArray.length - 1; i >= 0; i--) {
            //if(sArray[i].isEmpty())
            //continue;
            if (!sArray[i].isEmpty()) {
                sb.append(sArray[i]);
                sb.append(" ");
            }

        }
        return sb.toString().trim();
    }

    public String reverseList(String s){
        s = s.trim();

        List<String> words = Arrays.asList(s.split(" "));
        Collections.reverse(words);

        String res = String.join(" ", words);
        return res;
    }
}
