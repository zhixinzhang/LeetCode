package DataStructure.Array;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/15/19
 * Time: 2:39 PM
 * Description:
 */


public class _1024_VideoStitching_Sort_DP {

    public int videoStitching_Greedy(int[][] clips, int T) {
        int cnt = 0;
        int start = 0;
        while(start < T) {
            int max = -1;
            boolean exist = false;
            for(int[] clip : clips) {
                if(clip[0] <= start && clip[1] > start && max < clip[1]) {
                    max = clip[1];
                    exist = true;
                }
            }
            if(!exist) {
                return -1;
            }
            start = max;
            cnt++;
        }
        return cnt;
    }

    public int videoStitching(int[][] clips, int T) {
        List<int[]> list = new ArrayList<>();
        for (int[] clip : clips){
            if (clip[0] > T)    continue;
            list.add(clip);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                else
                    return o1[0] - o2[0];
            }
        });
        if(list.get(0)[0] != 0) return -1;
        int[] dp = new int[list.size()];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++){
            for (int j = i+1; j < list.size(); j++){
//                if (isInteraction(list,i,j)){
//                    dp[j] = dp[i] + 1;
//                }else
            }
        }
        return -1;
    }
}
