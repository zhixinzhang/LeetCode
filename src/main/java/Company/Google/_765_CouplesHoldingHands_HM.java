package google;
import java.util.*;
/**
 * Created by zhang on 2018/5/22.
 * 首先遍历一遍 将现在的index 值存入 map中
 * 在遍历一遍 更新map 错误的 就将操作数 +1
 */
public class _765_CouplesHoldingHands_HM {
    public int minSwapsCouples(int[] row) {
        // 0 1 2 3 4 5
        // 0 3 1 4 5 2
        // 0
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        while(index < row.length){
            map.put(row[index],row[index + 1]);
            map.put(row[index + 1], row[index]);
            index = index + 2;
        }
        index = 0;
        while(index < row.length){
            if(map.get(index) != index + 1){
                // 0 - 3  --- 0 -- 1
                //1 - 4
                int nextvalue = map.get(index + 1);
                int currentvalue = map.get(index);
                map.put(index, index + 1);
                map.put(currentvalue, nextvalue);
                map.put(nextvalue, currentvalue);
                res++;
            }
            index += 2;
        }
        return res;
    }
}
