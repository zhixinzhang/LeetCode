package Company.Grammly;

// https://leetcode.com/problems/last-substring-in-lexicographical-order/solutions/1964848/java-beats-100-00-memory-speed-0ms-april-2022/?languageTags=java
public class _1163_LastSubstringinLexicographicalOrder_TwoPointer {
    public static void main(String[] args){
        String a = lastSubstring("cabcabx");
        String aa = lastSubstring("cabcab");
        String b = "";
    }
    public static String lastSubstring(String s) {
        int n = s.length();
       // We have two pointers each pointing at the start of a
       // possible candidate substring. The pointer on the left
       // is the start of the final answer. Move the pointer with
       // smaller ASCII value to the right.
       int i = 0, j = 1, curLen = 0;
       while (i < n && j < n && curLen < n) {
           if (i + curLen >= n || j + curLen >= n) {
               break;
           }
           if (s.charAt(i + curLen) == s.charAt(j + curLen)) {
               // If two strings have currently have the same priority,
               // extend the length by 1 to see if it will make a difference
               curLen++;
           } else {
               // If two strings have different priority, move the pointer that
               // is pointing to the start of the string with lower priority.
               // We can directly do i += curLen + 1 instead of i += 1 because
               // the substring from i to i + curLen has already been covered
               // (it is impossible that any substring in this range will have a 
               // higher priority than the one that the other pointer is pointing 
               // to right now). Thus, we can skip them directly
               // E.g. d  a  b  d  a  b  x
               //      i        j           --> curLen = 3 (dab = dab)
               // When curLen = 4, d < x, so we need to move i to the right
               // We can move i to index 4 (i.e. the second a) directly. If some 
               // character between index 1 (the first a) and pointer j has higher
               // priority than the character pointed to by j, then i will have left
               // i long ago, which is clearly a contradiction.
               if (s.charAt(i + curLen) < s.charAt(j + curLen)) {
                   i += curLen + 1;
               } else {
                   j += curLen + 1;
               }
               if (i == j) {
                   j++;
               }
               curLen = 0;
           }
       }

       return s.substring(Math.min(i, j));
   }
}
