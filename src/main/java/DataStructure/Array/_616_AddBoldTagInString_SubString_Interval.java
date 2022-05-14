package DataStructure.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description: https://leetcode.com/problems/add-bold-tag-in-string/solution/
 * Key Point:
 *
 * Let's try to learn which letters end up bold, since the resulting answer will just be the canonical one - we put bold tags around each group of bold letters.
 *
 * To do this, we'll check for all occurrences of each word and mark the corresponding letters bold.
 *
 * Algorithm
 *
 * Let's work on first setting mask[i] = true if and only if the i-th letter is bold. For each starting position i in S, for each word, if S[i] starts with word, we'll set the appropriate letters bold.
 */

public class _616_AddBoldTagInString_SubString_Interval {

    // simple and good solution
    public String addBoldTag(String s, String[] dict) {
        if (s == null || s.length() == 0 || dict.length == 0) {
            return s;
        }

        boolean[] flag = new boolean[s.length()];

        for (String substr : dict){
            // we need replace all dic in word 's'
            int start= 0;
            while (start < s.length()){
                start = s.indexOf(substr, start);
                if (start < 0) {
                    break;
                }
                int end = start + substr.length();
                for (int i = start; i < end; i++){
                    flag[i] = true;
                }
                start++; // Just start from next index, instead of iterating through entire string
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (flag[i] && (i - 1 < 0 || !flag[i-1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (flag[i] && (i + 1 == s.length() || !flag[i + 1])) {
                sb.append("</b>");
            }
        }

        return sb.toString();
    }


    // Solution 2 : build a interval class
    class Interval{
        int start, end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public String addBoldTag_Interval_Sort(String s, String[] dict) {
        List<Interval> list = new ArrayList<>();
        for (String word : dict) {
            int index = s.indexOf(word);
            while (index > 0) {
                list.add(new Interval(index, index + word.length()));
                index = s.indexOf(word, index + 1);
            }
        }

        // need sort merge
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> res = mergeInterval(list);
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        for (Interval interval : res){
            sb.append(s.substring(pre, interval.start));
            sb.append("<b>" + sb.substring(interval.start, interval.end) + "</b>");
            pre = interval.end;
        }
        return sb.toString();
    }

    private List<Interval> mergeInterval (List<Interval> list){
        List<Interval> res = new ArrayList<>();
        if(list==null || list.size()==0){
            return res;
        }

        res.add(list.get(0));

        for (int i = 0; i < list.size(); i++){
            Interval temp = list.get(i);
            if (temp.start > res.get(res.size() - 1).end) {
                res.add(temp);
            } else {
                int max = Math.max(res.get(res.size()-1).end, temp.end);
                res.get(res.size() - 1).end = max;
            }
        }

        return res;
    }
}
