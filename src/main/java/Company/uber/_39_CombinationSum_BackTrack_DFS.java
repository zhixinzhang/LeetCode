package Company.uber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/9/11.
 */
public class _39_CombinationSum_BackTrack_DFS {
    static List<List<Integer>> res;
    public static void main(String[] args){
        combinationSum(new int[]{2,3,5}, 8);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return res;
        dfs(candidates, 0, 0, target,new ArrayList<>());
        System.out.println(res);
        return res;
    }

    public static void dfs(int[] candidates, int idx, int sum, int target, List<Integer> path){
        if(sum == target){
            res.add(new ArrayList<>(path));  // deep clone
            return;
        }
        if (sum > target)
            return;
        for(int i = idx; i < candidates.length; i++){
            path.add(candidates[i]);
            dfs(candidates, i, sum + candidates[i], target, path);
            path.remove(path.size()-1);
        }
    }
}
