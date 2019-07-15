package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhang on 2017/2/26.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 */
public class combinationSum39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        dfs(candidates,path,result,target,0);

        return  result;
    }
    public  static  void dfs(int[] candidates,List<Integer> path, List<List<Integer>> result,int gap,int start ){
        if (gap == 0) { // 找到一个合法解
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i<candidates.length;i++){
            if (gap <candidates[i]){
                return;
            }
            path.add(candidates[i]);
            dfs(candidates,path,result,gap - candidates[i],i);
            path.remove(path.size() -1);
        }
    }
    public  static  void main(String[] args){
        int[] candidates ={2,3,5,6,7};
        int target = 7;
        combinationSum(candidates,target);
    }

}
