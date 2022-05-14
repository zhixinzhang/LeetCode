package DataStructure.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Luke(New Man) Zhang
 * @Date 4/10/2021 4:05 PM
 * <p>
 * Description:
 * Similar task :
 * Key Point:
 */

public class _1239_MaximumLengthOfaConcatenatedStringwithUniqueCharacters_DFS {
//    public static void main(String[] args){
//        List<String> l = new ArrayList<>();
//        l.add("yy");
//        l.add("bkhwmpbiisbldzknpm");
//        maxLength(l);
//    }
    public int maxLength(List<String> arr) {
        return process(arr, "", 0);
    }
    int process(List<String> arr, String s, int index) {
        if (index > arr.size()) return 0;
        Set<Character> set = new HashSet<>();
        for(char c: s.toCharArray()) {
            if(set.contains(c)) return 0;
            set.add(c);
        }
        int max = s.length();
        for(int i = index; i < arr.size(); i++) {
            max = Math.max(max, process(arr, s + arr.get(i), i + 1));
        }
        return max;
    }
}
