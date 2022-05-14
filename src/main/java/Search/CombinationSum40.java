package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhang on 2017/2/26.
 */
public class CombinationSum40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(candidates,result,path,target,0);

        return  result;
    }

    private  static void dfs(int[] nums, List<List<Integer>> result, List<Integer> path,int gap,int start){
        if (gap == 0) { // 找到一个合法解
            result.add(new ArrayList<>(path));
            return;
        }
        int previous = -1;
        for (int i = start; i < nums.length; i++) {
// 如果上一轮循环已经使用了nums[i]，则本次循环就不能再选nums[i]，
// 确保nums[i]最多只用一次
            if (previous == nums[i]) continue;
            if (gap < nums[i]) return; // 剪枝
            previous = nums[i];
            path.add(nums[i]);
            dfs(nums, result,path, gap - nums[i], i + 1);
            path.remove(path.size() - 1); // 恢复环境
        }
    }

}
