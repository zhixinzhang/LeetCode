package Company.PayPal.OA;

import java.util.HashMap;
import java.util.Map;

/**
 * 2）相同订单：给两个字符串，问它们的长度是否相同以及任意字符的频次相差不超过3。这个也挺简单，
 * hashmap挨个数频次可解。但是楼主粗心忘了看第一个条件（最简单的条件）导致有一个test case没过。
 * 
*/
public class SameOrderCompare {
    public static void main(String[] args) {
        compareOrder("thisistest", "isistestIm");
    }

    private static boolean compareOrder(String s1, String s2){
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 != null && s2 != null && s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < s1.length(); i++){
            int c1 = cache.getOrDefault(s1.charAt(i), 0) + 1;
            cache.put(s1.charAt(i), c1);
            int c2 = cache.getOrDefault(s2.charAt(i), 0) - 1;
            cache.put(s2.charAt(i), c2);
        }

        for (Map.Entry<Character, Integer> entry : cache.entrySet()){
            char c = entry.getKey();
            int count = entry.getValue();
            if (Math.abs(count) > 3) {
                System.out.println("character : " + c + " frequency bigger than " + count);
                return false;
            }
        }

        return true;

    }
}
