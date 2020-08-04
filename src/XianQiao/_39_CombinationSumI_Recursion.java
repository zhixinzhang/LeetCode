package XianQiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Xianqiao
 * @Date: 8/3/20 16:32
 */
public class _39_CombinationSumI_Recursion {
    /** Given a set of candidate numbers (candidates) (without duplicates) and a
     * target number(target), find all unique combinations in candidates where
     * the candidate numbers sums to target.
     * Input: candidates = [2,3,6,7], target = 7,
     * A solution set is:
     * [
     *   [7],
     *   [2,2,3]
     * ] */
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates.length == 0 || target < 0 || candidates == null) {
            return ans;
        }
        helper(candidates, target, new ArrayList<Integer>, 0);
        return ans;
    }
    public void helper(int[] candidates, int remain, ArrayList<Integer> path, int start) {
        if (remain == 0) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = start; i < candidates.length; i++) {
            if (remain - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            helper(candidates, remain - candidates[i], path, i);
            path.remove(path.size() - 1);
        }
    }
}
