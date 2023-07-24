package Company.Rivian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _2150_FindAllLonelyNumbersintheArray_map {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        List<Integer> l1=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i],1);
            }
            else{
                hm.put(nums[i],hm.get(nums[i])+1);
            }
        }
        
        for(int i=0;i<n;i++){
        if(hm.get(nums[i])==1 && !hm.containsKey(nums[i]-1) && !hm.containsKey(nums[i]+1)){
                    l1.add(nums[i]);
                }
            }
            return l1;
    }
}
