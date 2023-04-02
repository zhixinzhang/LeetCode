package google.Design;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by zhang on 2018/6/21.
 * . 白人大叔
 首先互相做了自我介绍，极其简短。
 说了一堆data service system之类的，刚吃完冰淇淋的我一脸懵逼。
 许久交流之后，终于弄明白是一个list<log>  log has：
 task id
 startTime
 endTime
 memoryUse
 求整个时间段的最大memory用量，不考虑是哪个task
 */
// LC 253 跟meeting room基本一样  区别meeting room 占一个 这个是memory time
public class MeetingRoom2_DesigLog_PQ {
   static class Log{
        int id;
        int startTime;
        int endTime;
        int memoryUse;
        public Log(int id, int startTime, int endTime, int memoryUse){
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
            this.memoryUse = memoryUse;
        }
    }

    /**
      [1  2] = 7      [1 5]
     [1  3] = 5
     [1  4] = 6
     [2 4] = 5
     [5  6] = 4
     //pq   1 - 7  1 - 5  1 - 6  2 - 5  5 - 4
     //pq  2 - 7   3 - 5  4 - 6  4 - 5  6 - 4
     *
     */

    public static int solution(List<Log> logs){
        if (logs == null || logs.size() == 0) return 0;
//        PriorityQueue<int[]> pqStart = new PriorityQueue<>((a,b)->(a[0] - b[0]));
        PriorityQueue<int[]> pqStart = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else
                    return o1[1] - o2[1];
            }
        });
        for (Log log : logs){
            int[] startLog = new int[]{log.startTime, log.memoryUse};
            int[] endLog = new int[]{log.endTime, -log.memoryUse};
            pqStart.add(startLog);
            pqStart.add(endLog);
        }
        int res = 0;
        int a = 0;
        while (!pqStart.isEmpty()){
            a += pqStart.poll()[1];
            res = Math.max(res,a);
        }
        return res;
    }
    public static void main(String[] args){
        List<Log> logs = new ArrayList<>();
        Log l = new Log(1,1,3,7);
        Log l1 = new Log(1,1,2,5);
        Log l2 = new Log(1,1,4,6);
        Log l3 = new Log(1,2,4,5);
        Log l4 = new Log(1,5,6,4);
        Log l5 = new Log(1,5,8,4);
        logs.add(l);
        logs.add(l1);
        logs.add(l2);
        logs.add(l3);
        logs.add(l4);
        logs.add(l5);
        solution(logs);
    }
}
