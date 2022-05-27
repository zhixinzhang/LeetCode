package Company.LinkedIn;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 5/24/2022 1:22 AM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p> i1 and i2 are the indexes where word1 and word2 were last seen. Except if they're the same word, then i1 is the previous index.
 * <p>
 * Time and Space Complexity:
 * <p> O(N)
 * <p>
 * Data structure
 */

public class _245_ShortestWordDistance3_TwoPointer {

    public static int shortestWordDistance(String[] words, String word1, String word2) {
        long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
        for (int i=0; i<words.length; i++) {

            if (words[i].equals(word1))
                i1 = i;
            if (words[i].equals(word2)) {
                if (word1.equals(word2))
                    i1 = i2;
                i2 = i;
            }
            dist = Math.min(dist, Math.abs(i1 - i2));
        }
        return (int) dist;
    }

    public static void main(String[] args){
        shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "makes");

    }
}
