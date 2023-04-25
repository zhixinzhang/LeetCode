package Company.Sony;
import java.util.*;
/**
 * Created by zhang on 2018/1/21.
 */
//O(nlogn) + O(n ^ 2)
public class _15_3Sum_sort {
    //-1, 0, 1, 2, -1, -4
    // -4 -1 -1 0 1 2
    //low = -4   left to right  -1 -1 0 1 2
    // if left
    //Sort the array, iterate through the list, and use another two pointers to approach the target.
    // Make a list of set and then iterate over nums array and then use two pointer method to 
    // find the sum of all the three numbers required and if the sum is equal to zero then make a new ArrayList and store all the three numbers in it and then store that ArrayList in the set of list.
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans=new HashSet<>();
        for(int i = 0; i < nums.length-2; i++){
            int p1 = i+1;
            int p2 = nums.length-1;
            while(p1 < p2){
                int sum = nums[i]+nums[p1]+nums[p2];
                if(sum == 0){  
                    ans.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                    p1++;
                }
                else if(sum < 0){
                    p1++;
                }
                else{
                    p2--;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
