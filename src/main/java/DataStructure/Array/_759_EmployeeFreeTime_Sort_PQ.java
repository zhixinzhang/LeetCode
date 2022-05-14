package DataStructure.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/17/19
 * Time: 2:40 PM
 * Description:
 */


public class _759_EmployeeFreeTime_Sort_PQ {
//    public int[][] employeeFreeTime(int[][][] schedule) {
//        if(schedule == null || schedule.length == 0 || schedule[0].length == 0)
//            return new int[][]{{}};
//        Arrays.sort(schedule, new Comparator<int[][]>() {
//            @Override
//            public int compare(int[][] o1, int[][] o2) {
//                    if(a[0] != b[0])
//                        return a[0] - b[0];
//                    else
//                        return a[1] - b[1];
//            }
//        });
//        int[] pre;
//        List<int[]> res = new DataStructure.ArrayList<>();
//        for(int[] s : schedule){
//            if(pre == null && res.size() == 0){
//                pre = s;
//                if(s[0] > 1)
//                    res.add(new int[]{1, s[0]});
//            }else{
//                if(prev[1] >= s[0]){
//                    prev = new int[]{prev[0], s[1]};
//                    res.get(res.size()-1) = prev;
//                }else{
//                    prev = s;
//                    res.add(prev);
//                }
//            }
//        }
//        int[][] ans = new int[res.size()][2];
//        for(int i = 0; i < res.size(); i++){
//            ans[i] = res.get(i);
//        }
//        return ans;
//    }
}
