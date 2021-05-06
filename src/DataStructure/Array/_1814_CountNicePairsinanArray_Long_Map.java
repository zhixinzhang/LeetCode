package DataStructure.Array;

import java.util.HashMap;

/**
 * @author Luke Zhang
 * @Date 2021-05-02 14:22
 */
public class _1814_CountNicePairsinanArray_Long_Map {

    public int countNicePairs(int[] nums) {
        int mod=(int)Math.pow(10,9)+7;
        int count=0;

        HashMap<Long,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            long rev=reverse(nums[i]);

            long diff=nums[i]-rev;
            if(map.containsKey(diff)){
                count=(count%mod + map.get(diff)%mod)%mod;
            }

            map.put(diff,map.getOrDefault(diff,0)+1);
        }

        return count;
    }

    private long reverse(int num){
        long rev=0;
        while(num!=0){
            rev=rev*10 + num%10;
            num/=10;
        }
        return rev;
    }
}
