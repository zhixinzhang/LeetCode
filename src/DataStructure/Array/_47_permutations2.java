package DataStructure.Array;

import java.util.*;

/**
 * Created by zhang on 2017/10/18.
 */
public class _47_permutations2 {
    public static void main(String[] args){

    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);          // O(nlogn)
        backTrack(res, nums,new ArrayList<>(),used);
        return res;
    }
    private static void backTrack(List<List<Integer>> res,int[] nums,List<Integer> tempList,boolean[] used){
        if (tempList.size() == nums.length){
            res.add(new ArrayList<Integer>(tempList));
            return;
        }
        // 1 2 3 3 3 4
        for (int i = 0; i< nums.length; i++){
            // judge cur element used or not
            if(used[i] || i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
                continue;
            used[i] = true;
            tempList.add(nums[i]);
            backTrack(res,nums,tempList,used);
            // return to the previous state
            used[i] = false;
            tempList.remove(tempList.size()-1);
        }
    }

}
