package google.String;

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
}
