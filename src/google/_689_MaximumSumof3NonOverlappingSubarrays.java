package google;
import java.util.*;

/**
 * Created by zhang on 2018/5/20.
 *DataStructure.DP O（n） 时间
 *threee restrictions requirements 1. 三个部分相加最大值 2. 不能覆盖 overlaaping 3. 字符大小顺序返回
 *建立左右 两个index array  1,2,1,2,6,7,5,1
 * posLeft[] 存左面部分最大值最先出现的位置       0 0 0 4 5 5 5
 * posRight[] 存储右面部分 最大值最后出现的位置   0 0 0 4
 */
public class _689_MaximumSumof3NonOverlappingSubarrays {
    public static int[] maxSumOfThreeSubarrays_DP(int[] nums, int k) {
        int n = nums.length, maxsum = 0;
        int[] sum = new int[n + 1], posLeft = new int[n], posRight = new int[n], ans = new int[3];
        for (int i = 0; i < n; i++) sum[i+1] = sum[i]+nums[i];
        // DataStructure.DP for starting index of the left max sum interval
        //1,2,1,2,6,7,5,1
        for(int i = k, tot = sum[k] - sum[0]; i<n; i++){
            if(sum[i + 1] - sum[i+1 - k] > tot){
                posLeft[i] = i+1 -k;
                tot = sum[i+1] - sum[i+1-k];
            }else{
                posLeft[i] = posLeft[i-1];
            }
        }
        //dp right
        // caution: the condition is ">= tot" for right interval, and "> tot" for left interval
        posRight[n-k] = n-k;
        for (int i = n-k-1, tot = sum[n]-sum[n-k]; i >= 0; i--) {
            if (sum[i+k]-sum[i] >= tot) {
                posRight[i] = i;
                tot = sum[i+k]-sum[i];
            }
            else
                posRight[i] = posRight[i+1];
        }
        for(int i = k; i <= n - 2*k; i++){
            int l = posLeft[i-1], r = posRight[i+k];
            int tot = (sum[i+k]-sum[i]) + (sum[l+k]-sum[l]) + (sum[r+k]-sum[r]);
            if (tot > maxsum) {
                maxsum = tot;
                ans[0] = l; ans[1] = i; ans[2] = r;
            }
        }
        return ans;
    }


    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] res = new int[3];
        //1,2,1,2,6,7,5,1   k = 2
        TreeMap<Integer, List<Integer>> tm = new TreeMap<Integer, List<Integer>>((a,b)->(b - a));
        int sum = 0;
        for(int i = 0;i < k; i++){
            sum += nums[i];
        }
        int curVal = sum;
        List<Integer> index = new ArrayList<>();index.add(0);
        tm.put(sum,index);
        for(int i = 1; i<= nums.length - k; i++){
            sum = sum - nums[i-1] + nums[i+k-1];
            curVal = Math.max(sum,curVal);
            if (tm.containsKey(sum)){
                index = tm.get(sum);
            }else{
                index = new ArrayList<>();
            }
            index.add(i);
            tm.put(sum,index);
        }
        HashSet<String> visited = new HashSet<>();
        dfs(tm,curVal,k,visited,res);
        return res;
    }
    private static void dfs(TreeMap<Integer, List<Integer>> tm,int curVal, int depth, HashSet visited,int[] res){
        // return case
        if (depth == 0) return;
        List<Integer> index_list = tm.get(curVal);
        for (Map.Entry<Integer, List<Integer>> map : tm.entrySet()){

        }
        for (int i = 0; i<index_list.size(); i++){
            // select  13 -> 4
            String v = String.valueOf(curVal)+"->" +String.valueOf(index_list.get(i));
            Map.Entry<Integer, List<Integer>> a = tm.ceilingEntry(curVal);
            if (!visited.contains(v)){
                visited.add(v);
                res[3 - depth] = index_list.get(i);
                dfs(tm,curVal,depth--,visited,res);
                visited.remove(v);
            }
            // no select
            dfs(tm,curVal,depth,visited,res);
        }
    }
    public static void main(String[] args){
        maxSumOfThreeSubarrays_DP(new int[]{1,2,1,2,6,7,5,1},2);
    }
}
