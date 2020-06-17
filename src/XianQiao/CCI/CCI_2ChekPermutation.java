package XianQiao.CCI;

import java.util.PriorityQueue;

/**
 * @Author: Xianqiao
 * @Date: 5/30/20 18:29
 */
public class CCI_2ChekPermutation {
    /** Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.*/
    /** Solution 1 */
    boolean permutaion(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128];
        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            letters[c]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            letters[c]--;
            if (letters[c] != 0) {
                return false;
            }
        }
        return true;
    }

    /** My Solution, Solution 2 */
    boolean permutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        PriorityQueue<Character> qs = new PriorityQueue<>();
        PriorityQueue<Character> qt = new PriorityQueue<>();
        for (char c : s_array) {
            qs.add(c);
        }
        for (char c : t_array) {
            qt.add(c);
        }

        while (!qs.isEmpty()) {
            if (qs.peek() != qt.peek()) {
                return false;
            } else {
                qs.poll();
                qt.poll();
            }
        }
        return true;
    }
}
