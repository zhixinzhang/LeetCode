package ClassicProblemGroup.SubSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/15/19
 * Time: 5:22 PM
 * Description:
 * https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 *
 * This structure might apply to many other backtracking questions, but here I am just going to demonstrate Subsets,
 * Permutations, and Combination Sum.
 */


public class _78_Subsets_Backtrack {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return ans;

        backtrack(new ArrayList<Integer>(), ans, nums, 0);
        return ans;
    }

    public void backtrack(List<Integer> path, List<List<Integer>> ans, int[] nums, int idx){
        ans.add(new ArrayList<>(path));
        for(int i = idx; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(path, ans, nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
