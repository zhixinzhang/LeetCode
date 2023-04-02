package Company.Google;
import java.util.*;
/**
 * Created by zhang on 2018/5/15.
 * S = "abcbde"
 words = ["a", "bb", "acd", "ace"]
 Output: 3
 O(n)   queue        bb
 // a - bcde
 // b - cbde  de
 // c - bde
 // d - e
 // e - ""
 */
public class _792_NumberofMatchingSubsequences_Queue {
    public static int numMatchingSubseq_Q(String S, String[] words) {
      HashMap<Character, Queue<String>> hm = new HashMap<>();
      int res = 0;
      for (Character a = 'a'; a <='z'; a++ )
          hm.put(a, new LinkedList());
      for (String word : words){
          hm.get(word.charAt(0)).add(word);
      }
      for (Character c : S.toCharArray()){
            Queue<String> q = hm.get(c);
            int size = q.size();
            for(int i = 0; i<size; i++){
                String curS = q.poll();  //a
                if (curS.length() == 1){
                    res++;
                }else {                 // acd
                    hm.get(curS.charAt(1)).add(curS.substring(1));
                }
            }
      }
      return res;
    }

    public static void main(String[] args){
        numMatchingSubseq_Q("abcde", new String[]{"a", "bb", "acd", "ace"});
    }

    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for(String word:words){
            if(isSubsequence(S,word))
                count++;
        }
        return count;
    }

    public boolean isSubsequence(String str,String t){
        int i = 0, j = 0, l1 = str.length(), l2 = t.length();
        if(l2 > l1){
            return false;
        }
        while(i < l1 && j < l2){
            if(str.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j == l2;
    }
}
