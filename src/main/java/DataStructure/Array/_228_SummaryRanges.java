package DataStructure.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/4/24.
 */
public class _228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i<nums.length;i++){
            int a=nums[i];
            while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
                i++;
            }
            if(a!=nums[i]){
                res.add(a+"->"+nums[i]);
            }else{
                res.add(a+"");
            }
        }
        return res;
    }
}
