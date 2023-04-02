package Company.Google.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhang on 2018/6/27.
 */
public class _859_BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) return false;
        int swap = 0;
        char AC = ' ';
        char BC = ' ';
        int[] count = new int[26];
        // ab    ba
        for(int i = 0; i<A.length(); i++){
            count[A.charAt(i) - 'a']++;
            if(A.charAt(i) != B.charAt(i) && swap >= 2)
                return false;

            if(A.charAt(i) != B.charAt(i) && AC == ' '){
                AC = A.charAt(i);
                BC = B.charAt(i);
                swap++;
            }else if(A.charAt(i) != B.charAt(i) && AC != ' '){
                if(AC != B.charAt(i) || A.charAt(i) != BC )
                    return false;
                else
                    swap++;
            }

        }
        //ab
        for(int i : count){
            if(i>=2)
                return true;
        }
        if(swap != 2)
            return false;
        return true;
    }
/**
 * If A.length() != B.length(): no possible swap
 *
 * If A == B, we need swap two same characters. Check is duplicated char in A.
 *
 * In other cases, we find index for A[i] != B[i]. There should be only 2 diffs and it's our one swap.
 *
 * */

    public boolean buddyStrings_simple(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            Set<Character> s = new HashSet<>();
            for (char c : A.toCharArray())
                s.add(c);
            return s.size() < A.length();
        }

        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i) if (A.charAt(i) != B.charAt(i)) dif.add(i);
        return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }
}
