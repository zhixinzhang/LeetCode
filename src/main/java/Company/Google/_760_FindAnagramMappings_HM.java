package Company.Google;

import java.util.HashMap;

/**
 * Created by zhang on 2018/5/22.
 */
public class _760_FindAnagramMappings_HM {
        public int[] anagramMappings(int[] A, int[] B) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            int[] res = new int[A.length];
            for (int i = 0; i< B.length;i++){
                hm.put(B[i],i);
            }
            for (int i = 0; i<A.length;i++){
                int index = hm.get(A[i]);
                res[i] = index;
            }
            return res;
        }
    }
