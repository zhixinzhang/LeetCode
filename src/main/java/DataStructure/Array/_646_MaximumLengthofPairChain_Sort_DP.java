package DataStructure.Array;
import java.util.*;
/**
 * Created by zhang on 2018/1/3.
 */
public class _646_MaximumLengthofPairChain_Sort_DP {
    public int findLongestChain(int[][] pairs) {
        // 12  34 37 35  56            12 34 56
        //Arrays.sort(pairs)
        Arrays.sort(pairs, (p1, p2)->p1[0]-p2[0]);
        int len = 0;
        int pre = Integer.MIN_VALUE;
        for(int[] pair : pairs){
            if(pair[0] > pre){  // not overlap
                len++;
                pre = pair[1];
            }else if(pair[1] < pre){ // overlap but with smaller second element
                pre = pair[1];
            }
        }
        return len;
    }
}
