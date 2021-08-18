package Company.BloomBerg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Luke Zhang
 * @Date 2021-07-29 17:43
 */
public class MergeInteval_Bank {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> ans = new ArrayList<>();
        for (int[] inter : intervals){
            if (ans.isEmpty()){
                ans.add(inter);
            } else {
                int[] last = ans.get(ans.size() - 1);
                if (last[1] < inter[0]) {
                    ans.add(inter);
                } else {
                    last[0] = Math.min(inter[0], last[0]);
                    last[1] = Math.max(inter[1], last[1]);
                }
            }
        }


        return ans.toArray(new int[ans.size()][]);
    }

    private boolean isValid(int[][] intervals, int[] range){
        for (int[] inter : intervals){
            if (range[0] >= inter[0] && range[1] <= inter[1])
                return true;
        }

        return false;
    }
}
