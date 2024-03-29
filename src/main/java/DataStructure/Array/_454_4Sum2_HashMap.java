package DataStructure.Array;
import java.util.*;

// 将数组分成一半   Time complexity:  O(n^2)
//Space complexity: O(n^2)
public class _454_4Sum2_HashMap{
	  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
      Map<Integer, Integer> map = new HashMap<>();
    
    for(int i=0; i<C.length; i++) {
        for(int j=0; j<D.length; j++) {
            int sum = C[i] + D[j];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
    }
    
    int res=0;
    for(int i=0; i<A.length; i++) {
        for(int j=0; j<B.length; j++) {
            res += map.getOrDefault(-1 * (A[i]+B[j]), 0);
        }
    }
    
    return res;
    }
}