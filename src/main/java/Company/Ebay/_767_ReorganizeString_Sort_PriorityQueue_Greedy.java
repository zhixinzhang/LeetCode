package Company.Ebay;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhang on 2018/9/18.
 * 首先计算最多的character 先放最多的character
 * 然后按照idx放其余的
 */
public class _767_ReorganizeString_Sort_PriorityQueue_Greedy {
    public static void main(String[] args){
        reorganizeString("aabcccdef");
        // abacdc
    }

    public static String reorganizeString(String S) {
        char ch[] = new char[26];
        int max = 0;
        for(char c: S.toCharArray()) {
            ch[c - 'a'] ++;
            if(ch[c-'a'] > ch[max])
                max = c - 'a';
        }
        int len = S.length();
        if(len < 2 * ch[max] - 1) return "";
        int index = 0;
        char []res = new char[len];
        for(int i = 0 ; i < ch[max]; i++) {
            res[index] = (char)(max + 'a');
            index += 2;
        }
        ch[max] = 0;
        for(int i = 0 ; i < 26; i++) {
            int count = ch[i];
            while(count > 0 ) {
                if(index >= len ) index = 1;
                res[index] = (char)(i + 'a');
                index += 2;
                count --;
            }
        }

        return new String(res);
    }

    // Solution 2 : use new charCount class and sort it
    static class CharCount {
        int count;
        char letter;

        CharCount (int count, char letter){
            this.count =count;
            this.letter = letter;
        }
    }

    public static String reorganizeString_PQ(String S) {
        int n = S.length();
        int[] count = new int[26];
        for (char c : S.toCharArray()){
            count[c - 'a'] ++;
        }
        PriorityQueue<CharCount> pq = new PriorityQueue<CharCount>(
            (a,b) -> (a.count == b.count ? a.letter - b.letter : b.count - a.count)
        );

    //    PriorityQueue<CharCount> pqs = new PriorityQueue<CharCount>(
    //            new Comparator<CharCount>() {
    //                @Override
    //                public int compare(CharCount o1, CharCount o2) {
    //                    if (o1.count == o2.count)
    //                        return o1.letter - o2.letter;
    //                    return o2.count - o1.count;
    //                }
    //            }
    //    );

        for (int i = 0; i < 26; ++i) 
            if (count[i] > 0) {
            // not satisfied
            if (count[i] > (n + 1) / 2)
                return "";
            pq.add(new CharCount(count[i], (char) ('a' + i)));
        }

        StringBuilder ans = new StringBuilder();
        while (pq.size() >= 2){
            CharCount c1 = pq.poll();
            CharCount c2 = pq.poll();

            ans.append(c1.letter);
            ans.append(c2.letter);
            if (--c1.count > 0) pq.add(c1);
            if (--c2.count > 0) pq.add(c2);
        }

        if (pq.size() > 0) ans.append(pq.poll().letter);
        return ans.toString();
    }
}
