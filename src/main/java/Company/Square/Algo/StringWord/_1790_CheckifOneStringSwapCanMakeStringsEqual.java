package Company.Square.Algo.StringWord;
import java.util.*;


public class _1790_CheckifOneStringSwapCanMakeStringsEqual {
    public static void main(String[] args){
        boolean res = areAlmostEqual("bank", "kanb");
        System.out.println(res);
    }

    // O(N) + O(N)
    public boolean areAlmostEqual_better(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;
        ArrayList<Integer> list = new ArrayList<>();
        boolean toReturn = false;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) list.add(i);
        }
        if(list.size() > 2) return false;
        if(list.size() == 2) 
        {
            int i = list.get(0) , j = list.get(1);
            toReturn = s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
            return toReturn;
        }
        
        return toReturn;
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1 == null && s2 == null || s1.equals(s2)){
            return true;
        }
        if (s1.length() != s2.length()){
            return false;
        }

        Map<Character, Integer> cache = new HashMap<>();
        for (char c : s1.toCharArray()){
            cache.putIfAbsent(c, 0);
            int count = cache.get(c) + 1;
            cache.put(c, count);
        }

        for (char c : s2.toCharArray()){
            if ( !cache.containsKey(c) ) {
                return false;
            }
            int count = cache.get(c) - 1;
            if (count == 0) {
                cache.remove(c);
            } else {
                cache.put(c, count);
            }
        }

        return true;
    }

}
