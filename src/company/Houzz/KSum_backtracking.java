package company.Houzz;
import java.util.*;
/**
 * Created by zhang on 2018/1/22.
 */
public class KSum_backtracking {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        kSum(result, new ArrayList<Integer>(), nums, target, 4, 0, nums.length-1);
        return result;
    }

    private void kSum(List<List<Integer>> result,List<Integer> cur,int[] nums, int target,int k,int start, int end){
        if(k == 0 || nums.length==0 || start>end) return;
        if(k == 1){
            for (int i = start; i <= end ; i++) {
                if(nums[i] == target){
                    cur.add(nums[i]);
                    result.add(new ArrayList<Integer>(cur));
                    cur.remove(cur.size()-1);
                }
            }
            return;
        }

        if(k == 2){ // 2 sum
            int sum;
            while (start < end){
                sum = nums[start]+nums[end];

                if(sum == target){
                    cur.add(nums[start]);
                    cur.add(nums[end]);
                    result.add(new ArrayList<Integer>(cur));
                    cur.remove(cur.size()-1);
                    cur.remove(cur.size()-1);

                    //avoid duplicate
                    while(start < end && nums[start] == nums[start+1]) ++start;
                    ++start;
                    while(start < end && nums[end] == nums[end-1]) --end;
                    --end;
                }else if(sum < target){
                    //avoid duplicate
                    while(start < end && nums[start] == nums[start+1]) ++start;
                    ++start;
                }else{
                    while(start < end && nums[end] == nums[end-1]) --end;
                    --end;
                }
            }
            return;
        }

        //避免一些不必要case
        if(k*nums[start] > target || k*nums[end]<target) return;

        // k > 2 : choose nums[i] and do k-1 sum on the rest at right
        for (int i = start; i <= (end-k+1) ; i++) {
            // avoid duplicate
            if(i>start && nums[i]==nums[i-1]) continue;
            // 重点
            if(k*nums[i] <= target) { //避免掉一些不必要case
                cur.add(nums[i]);
                kSum(result, cur, nums, target - nums[i], k - 1, i + 1, end);
                cur.remove(cur.size() - 1);
            }
        }

    }
}
