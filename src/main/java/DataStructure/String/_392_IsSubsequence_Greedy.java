package DataStructure.String;
import java.util.*;

/**
 * Created by zhang on 2018/5/2.
 */
public class _392_IsSubsequence_Greedy {

    public boolean isSubsequence(String s, String t) {
        // two pointer
        if(s == null || s.length() == 0)
            return true;
        int sIndex = 0, tIndex = 0;
        int sL = s.length(), tL = t.length();
        while(tIndex < tL){   //这里用到的贪心算法，就是在t中越先找到 s的字符 那么在t中就更容易的找到 s剩下的字符
            if(sIndex < sL && (s.charAt(sIndex) == t.charAt(tIndex))){
                sIndex++;
            }
            tIndex++;
            if(sIndex == sL)
                return true;

        }
        return false;
    }

    public boolean isSubsequence_FollowUp(String s, String t) {
        if (s == null || t == null) return false;

        Map<Character, List<Integer>> map = new HashMap<>(); //<character, index>

        //preprocess t
        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<Integer>());
            }
            map.get(curr).add(i);
        }

        int prev = -1;  //index of previous character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.get(c) == null)  {
                return false;
            } else {
                List<Integer> list = map.get(c);
                prev = binarySearch(prev, list, 0, list.size() - 1);
                if (prev == -1) {
                    return false;
                }
                prev++;
            }
        }

        return true;
    }

    private int binarySearch(int index, List<Integer> list, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) < index) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start == list.size() ? -1 : list.get(start);
    }
}
