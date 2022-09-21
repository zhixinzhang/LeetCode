package Company.Doordash;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 9/19/2022 12:09 AM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 * https://www.1point3acres.com/bbs/thread-921088-1-1.html
 *
 * Time complexity: O(n + ml), where n is number of characters in restaurantName, m size of the list (names) and l is length of the name in names, since l should be equal to n we have O(n + mn), hence the final time complexity is O(m*n)
 * Space complexity: Constant, as you have just 2 auxiliary arrays with fixed size (128)
 *
 * Let me know your thoughts.
 */

public class _k_anagram_Restaurant {
    public static List<String> findAnagrams(String restaurantName, List<String> names, int allowedCharDiff) {
        List<String> result = new ArrayList<String>();
        int[] restaurantCharCount = new int[128];
        caluculateCharCount(restaurantName, restaurantCharCount);

        for(String name : names) {
            if(restaurantName.length() == name.length()) {
                int[] nameCharCount = new int[128];
                caluculateCharCount(name, nameCharCount);
                int diff = 0;

                for (int i=0; i<nameCharCount.length; i++) {
                    diff += Math.abs(restaurantCharCount[i] - nameCharCount[i]);
                }

                if (diff / 2<=allowedCharDiff) {
                    result.add(name);
                }
            }

        }

        return result;
    }

    private static void caluculateCharCount(String name, int[] charCount) {
        for(int i=0; i<name.length(); i++) {
            charCount[name.charAt(i)]++;
        }
    }

    public static void main(String[] args){
        String input = "hotpot";
        List<String> list = Arrays.asList("hottop", "hotopt", "hotpit", "httoop", "hptoot");
        findAnagrams(input, list, 3);
    }
}
