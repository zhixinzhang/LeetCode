package XianQiao.CCI;

/**
 * @Author: Xianqiao
 * @Date: 5/31/20 21:53
 */
public class CCI_4PalindromePermutaion {
    /** Palindrome Permutation: Given a string, write a function to check if it is a permutation of
     * a palindrome. A palindrome is a word or phrase that is the same forwards and backwards.
     * A permutation is a rearrangement of letters. The palindrome does not need to be limited to
     * just dictionary words. */

    /** Solution 1 */
    boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }
    boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }
    int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }
    int [] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1){
                table[x]++;
            }
        }
        return table;
    }



    /** Solution 2 */
    boolean isPermutationOfPalindrome2(String phrase) {
        int countOdd = 0;
        int [] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

}
