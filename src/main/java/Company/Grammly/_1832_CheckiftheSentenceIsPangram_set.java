package Company.Grammly;

import java.util.HashSet;
import java.util.*;

public class _1832_CheckiftheSentenceIsPangram_set {

    public static void main(String[] args){
        boolean ans = isPangram("thequickbrownfox jumpsoverthelazydog");
        boolean c = true;
    }

    private static boolean isPangram(String sentence){
        if (sentence == null || sentence.length() == 0) {
            return true;
        }

        Set<Character> set = new HashSet<>();
        for (char c : sentence.toCharArray()){
            if (c == ' ') continue;
            if (c >= 'a' && c <= 'z') {
                set.add(c);
            } else {
                return false;
            }
        }

        return set.size() == 26;
    }
}
