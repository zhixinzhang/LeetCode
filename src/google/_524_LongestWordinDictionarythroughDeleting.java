package google;


import java.util.List;

// O(nk) sort List and compare each string
public class _524_LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String l = "";
        for (String t: d)
            if (isSub(s, t) && t.length() >= l.length())
                if (t.length() > l.length() || t.compareTo(l) < 0)
                    l = t;
        return l;
    }
    
    boolean isSub(String s, String t) {
        int j = 0;
        for (int i = 0; i < t.length(); i++)
            while (j == s.length() || t.charAt(i) != s.charAt(j++))
                if (j == s.length())
                    return false;
        return true;
    
        
    }
}