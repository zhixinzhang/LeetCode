package google.Array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by zhang on 2018/6/24.
 */
public class _843_GuesstheWord_Greedy {
    public interface Master{
        public int guess(String a);
    }
    public void findSecretWord(String[] wordlist, Master master) {
        int[] count = new int[26];
        for(String s : wordlist){
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }
        }

        Set<String> set = new HashSet<>();
        for(String s : wordlist){
            set.add(s);
        }
        int i = 0;
        while(i++ < 10){
            String best = getBestCandidate(set, count);
            int match = master.guess(best);
            for (Iterator<String> ite = set.iterator(); ite.hasNext();) {
                if (match(best, ite.next()) != match) {
                    // Remove the candidate that not matches.
                    ite.remove();
                }
            }
        }
    }
    private String getBestCandidate(Set<String> wordlist, int[] count) {
        int max = 0;
        String best = "";
        for(String s : wordlist){
            int c = 0;
            for(char a : s.toCharArray()){
                c += count[a - 'a'];
            }
            if(c > max){
                max = c;
                best = s;
            }
        }
        return best;

    }
    private int match(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i))
                count++;
        }
        return count;
    }
}
