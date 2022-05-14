package DataStructure.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhang on 2017/10/18.
 * [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class _46_Permutations {

    public List<List<Integer>> permute_more(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        if (nums == null || nums.length == 0){
            return res;
        }
        LinkedList<Integer> list = new LinkedList<>();
        helper(nums,list,res, used);
        return res;
    }
    private void helper(int[] nums,LinkedList<Integer> list, List<List<Integer>> res, boolean[] used){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i< nums.length;i++){
            if (used[i] == false){
                used[i] = true;
                list.addLast(nums[i]);
                helper(nums,list,res, used);
                used[i] = false;
                list.removeLast();
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        List<Integer> list = new ArrayList<>();
        helper(res,nums,list);
        return res;
    }
    private void helper(List<List<Integer>> res,int[] nums, List<Integer> list){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i< nums.length;i++){
            if (!list.contains(nums[i])){
                list.add(nums[i]);
                helper(res,nums,list);
                list.remove(list.size()-1);
            }
        }
    }
}
