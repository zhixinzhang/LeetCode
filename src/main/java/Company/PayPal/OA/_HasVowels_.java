package Company.PayPal.OA;

import java.util.LinkedList;
import java.util.List;

// https://www.1point3acres.com/bbs/thread-949217-1-1.html
// https://www.1point3acres.com/bbs/thread-939219-1-1.html
public class _HasVowels_ {
    public static void main(String[] args) {
        
    }
    private static List<Integer> hasVowels(List<String> strArr, List<String> query){
        List<Integer> res = new LinkedList<>();
        int[] count = new int[strArr.size() + 1];
        count[0] = 0;
        
        for (int i = 0; i < strArr.size(); i++){
            String str = strArr.get(i);
            char first = str.charAt(0);
            char last = str.charAt(str.length() - 1);
            count[i] = count[i - 1];
            if (isVowel(first) && isVowel(last)){
                count[i] += 1;
            }
        }

        for (String s : query){
            String[] idx = s.split("-");
            int start = Integer.parseInt(idx[0]);
            int end = Integer.parseInt(idx[1]);
            int cur = count[end] - count[start - 1];
            res.add(cur);
        }

        return res;
    }

    private static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
