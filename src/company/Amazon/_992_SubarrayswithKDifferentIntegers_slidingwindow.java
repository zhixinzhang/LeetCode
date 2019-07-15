package company.Amazon;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/23/19
 * Time: 4:03 PM
 * Description:
 */


public class _992_SubarrayswithKDifferentIntegers_slidingwindow {
    public static void main(String[] args){
        subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2);
    }
    public static int subarraysWithKDistinct(int[] A, int K) {
        if (A == null || A.length == 0 || K == 0)
            return 0;
        HashMap<Integer, Deque<Integer>> cache = new HashMap<>();
        int res = 0;
        for (int l = 0, r = 0; l < A.length && r < A.length;){
            if (cache.size() <= K || cache.containsKey(A[r])){
                cache.getOrDefault(A[r], new LinkedList<>()).addLast(r);
                if (cache.size() == K){
                    res++;
                }
                r++;
                continue;
            }else if (cache.size() == K && !cache.containsKey(A[r])){
                Deque<Integer> leftDeq = cache.get(A[l]);
                cache.remove(A[l]);
                int curL = leftDeq.pollLast();
                l = curL+1;
            }
        }
        return res;
    }



    public int subarraysWithKDistinct_right(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }
    int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (count.getOrDefault(A[j], 0) == 0) K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}
