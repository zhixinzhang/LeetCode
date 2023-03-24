package Company.Robinhood;
import java.util.*;
/**
 * https://www.1point3acres.com/bbs/thread-977087-1-1.html
 * 写代码：不知道算不算老题。类似于packet commit，给一个数组，里面会是1-n的unique数，挨个处理，处理到x的时候
1）如果之前的1，2，3 ...x-1全部没有被标记为“已处理”，x被视为“未处理”，未处理记为-1
2）如果之前的1，2，3 ...x-1有被标记为‍‌‌‌‌‍‌‌‍‍‌‌‍‌‌‍‌‍‌“已处理”，则输出当前被标记为“已处理”的最高的数
和莉蔻  邀溜舞柳 有点像

1. 输入是一个数组 (0-N)
2. 输出是一个数组 (0-N)
输出的数组里每个元素的含义是: 如果是n, 那么表示我们已经在输入数组里已经访问过了[0,1,..n]. 举几个例子(凭记忆写的):
[0, 1, 2, 3] => [0, 1, 2, 3]
[3, 1, 2, 0] => [-1, -1, -1, 3]
[2, 0, 1, 3] => [-1, 0, 2, 3]
 * 
*/
public class _PacketCommit_ {
    public static void main(String[] args) {
        int[] records = new int[]{3, 1, 2, 0};
        int[] records2 = new int[]{2, 0, 1, 3};
        int[] records3 = new int[]{0, 1, 2, 3};

        solution(records3);
    }

    private static int[] solution(int[] records){
        if (records == null || records.length == 0) {
            return records;
        }
        int[] ans = new int[records.length];

        Set<Integer> cache = new HashSet<>();
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < records.length; i++){
            int curVal = records[i];
            maxVal = Math.max(maxVal, curVal);
            if (curVal == 0) {
                ans[i] = 0;
                // ans[i] = maxVal;
            } else {
                boolean marked = true;
                for (int j = 0; j <= curVal- 1; j++){
                    if (cache.contains(j)) {
                        continue;
                    } else {
                        marked = false;
                        break;
                    }
                }

                if (marked) {
                    ans[i] = maxVal;
                } else {
                    maxVal = Math.max(maxVal, curVal);
                    ans[i] = -1;
                }
                
            }
            cache.add(curVal);
        }

        for (int i : ans){
            System.out.println(i);
        }
        return ans;
    }
}
