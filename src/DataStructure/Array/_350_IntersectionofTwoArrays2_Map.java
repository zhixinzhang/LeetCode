package DataStructure.Array;
import java.util.*;

/**
 * Created by zhang on 2018/4/28.
 */
public class _350_IntersectionofTwoArrays2_Map {
    public int[] _350_IntersectionofTwoArrays2_Map(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer i : nums1){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(Integer i : nums2){
            if(hm.containsKey(i)){
                list.add(i);
                int count = hm.getOrDefault(i,0);
                count--;
                if(count<=0)
                    hm.remove(i);
                else
                    hm.put(i,count);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i< list.size();i++){
            res[i] = list.get(i);
        }
        return res;

    }
}
