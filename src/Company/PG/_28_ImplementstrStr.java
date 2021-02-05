package Company.PG;

/**
 * Created by zhang on 2018/1/26.
 * Return the index of the first occurrence of needle in haystack, or -1 if needle
 * is not part of haystack.

 Example 1:
 Input: haystack = "hello", needle = "ll"
 Output: 2
 Example 2:
 Input: haystack = "aaaaa", needle = "bba"
 Output: -1
 */
// time O(n)
// from left to right loop hayStack and comapre each subString
// 两种写法
public class _28_ImplementstrStr {
    /*
Time Complexity : O(nm)
Space Complexity : O(1)
Worst Case is every char in base need loop m times:
Base: 	aaaaa
Target: ac
*/
    public int strStr_compareEachCharacter(String base, String target) {
        if (base == null || target == null) {
            return -1;
        }
        if (base.isEmpty() && target.isEmpty()) {
            return 0;
        }
        int i, j;
        int diff = base.length() - target.length();
        for (i = 0; i <= diff; i++) {
            for (j = 0; j < target.length(); j++) {
                if (base.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }


    //O(nm)
    public int strStr(String haystack, String needle) {
        if(haystack == null) return  -1;
        int l1 = haystack.length(), l2 = needle.length();
        if(l2 == 0) return 0;
        for(int i = 0; i <= l1 - l2; i++) {
            if(haystack.substring(i, i+ l2).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    //O(n)
    /**KMP    http://leetcodesolutionandsummaries.blogspot.com/2015/04/implement-strstr-kmp-algorithm.html
     *  1. Find first A from haystack, which is haystack[0]:
     ABABABC    ABABC
     2. Then we try to math rest of the string with needle and immediately find 'A' doesn't with 'C', in haystack[4]:
     ABABABC    ABABC
     3. We can see that haystack[0] to haystack[3] are already computed, and we want to use this result in later matching so we don't need to iterate then again. What we do is, start matching at haystack[2] with needle[2]:
     ABABABC    ABABC
     4. And we'll find a match in the rest of haystack.
     And you'll quickly figure out step 3 is the most tricky one. How do we start from that location? Actually we need to know: how many characters in haystack[0~3] can be reused. Consider haystack[0~3] is already match with needle[0~3], we now need to know at index 4, how many characters in needle should be reused. Further more we want to know for each index in needle, how many characters before that index can be reused?
     */

    public int strStr_KMP(String haystack, String needle) {

        int index = 0;
        int i=0,j=0;

        if(needle.length() > haystack.length()){
            return -1;
        }

        if(needle.length()==0){
            return 0;
        }

        int[] lps = getLps(needle.toCharArray());

        while(i<haystack.length() && j<needle.length()){

            if(haystack.charAt(i) == needle.charAt(j)){
                if(j==0){
                    index=i;
                }
                i++;
                j++;
            }

            else {
                if(j==0){
                    i++;
                }
                else {
                    j=lps[j-1];
                    index = i-j;
                }
            }

        }

        if(j==needle.length()){
            return index;
        } else {
            return -1;
        }

    }

    private int[] getLps(char[] pattern) {

        int[] arr = new int[pattern.length];
        int j=0;
        for(int i=1; i<pattern.length;){

            if(pattern[i] == pattern[j]){
                arr[i] = j+1;
                i++;
                j++;
            } else {
                if(j==0){
                    arr[i] = 0;
                    i++;
                } else {
                    j=arr[j-1];
                }

            }
        }
        return arr;
    }
}
