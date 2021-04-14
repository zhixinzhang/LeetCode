package Company.Micorsoft;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/13/2021 7:48 PM
 * <p>
 * Description:  https://www.1point3acres.com/bbs/thread-744749-1-1.html
 * Similar task :
 * Key Point:
 *
 * 第四轮：
 * 一个场景，从source到destination的代价，每周从source去一次destination，然后从destination返回source， 让算一个最小代价，要求时间O (n)
 *       Mon  Tues  Wes， Thur， Fri
 * SD    10    30     20         10       15
 * DS    30     25     15        10       15
 *
 * 没想起来，最后面试官直接告诉的答案， 预处理DS，变成 [10, 10, 10, 10, 15], 从i到末尾最小的元素放到DS的位置
 */

public class _SourceAndDestination_Array {
    public int solution(int[] source, int[] destination){
        if (source == null || source.length == 0 || destination == null || destination.length == 0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < source.length; i++){            // [10, 30, 20, 10, 15]  -> [10, 10, 10, 10, 10]
            min = Math.min(source[i], min);                 //                           30, 25, 15, 10, 15
            source[i] = min;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < destination.length; i++){
            res = Math.min(destination[i] + source[i], res);
        }

        return res;
    }
}
