package google;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zhang on 2018/5/19.
 */
// 用一个treemap 存储每个时间点， 如果是start 就代表有一个会议开始 +1 ， 如果是end 就代表有有个会议结束 -1
//每次搜索整个treemap 如果会议总数大于要求 返回false 切记要recover treemap
public class _731_MyCalendar2_TreeMap {
    TreeMap<Integer, Integer> tm;
    public _731_MyCalendar2_TreeMap() {
        tm = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (start >= end )  return false;
        tm.put(start, tm.getOrDefault(start, 0) + 1);
        tm.put(end, tm.getOrDefault(end, 0) - 1);
        int count = 0;
        for (Map.Entry<Integer,Integer> entry : tm.entrySet()){
            count += entry.getValue();          // 10 1
            if (count > 2){
                // recover
                tm.put(start, tm.get(start) - 1);
                if(tm.get(start) == 0) {
                    tm.remove(start);
                }
                tm.put(end, tm.get(end) + 1);
                if(tm.get(end) == 0) {
                    tm.remove(end);
                }
                return false;
            }
        }
        return true;
    }
}
