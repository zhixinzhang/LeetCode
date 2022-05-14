package google;
import  java.util.*;
/**
 * Created by zhang on 2018/5/16.
 * original:     2, 1, 4, 4, 3, 5, 7, 6
 max:          2, 2, 4, 4, 4, 5, 7, 7
 sorted:       1, 2, 3, 4, 4, 5, 6, 7
 The chunks are: 2, 1 | 4, 4, 3 | 5 | 7, 6

 It needs to be noted that at index 3, although max[i] == sorted[i],
 this is not the right dividing point. Otherwise, the number after it (3) will be in the wrong chunk.
 *
 */
public class _768_MaxChunksToMakeSorted2_Hard {
    public int maxChunksToSorted(int[] arr) {
        if(arr == null || arr.length == 0)  return 0;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int[] max = new int[arr.length];
        max[0] = arr[0];
        for(int i = 1; i< arr.length; i++){
            max[i] = Math.max(max[i-1],arr[i]);
        }

        int count = 0;
        int uL = Integer.MAX_VALUE;
        for(int i = arr.length - 1; i>=0; i--){
            if(max[i] == sorted[i]){
                if(sorted[i] > uL){
                    continue;
                }
                count++;
                uL = arr[i];
            }
        }
        return count;
    }
}
