package Company.Amazon;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/9/19
 * Time: 10:01 PM
 * Description:
 * google也考过 很经典 两中方式
 */


public class _252_MeetingRoom_DesignLog {
    class Log{
        int start;
        int end;
        int memory;
        String userId;
        String server;
        String name;
        public Log(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    //
    public int FindMaxMemory(List<List<String>> logInfo){
        HashMap<String, List<Log>> hm = new HashMap<>();
        for (List<String> info : logInfo){
            String serverName = info.get(3);
            hm.putIfAbsent(serverName, new ArrayList<>());
            Log log = new Log(Integer.valueOf(info.get(0)),Integer.valueOf(info.get(1)));
            hm.get(serverName).add(log);
        }
        if (hm.containsKey("ServerA")){
            List<Log> logs =  hm.get("serverA");
            Collections.sort(logs, new Comparator<Log>(){
                @Override
                public int compare(Log l1, Log l2){
                    if (l1.start != l2.start)
                        return l1.start - l2.start;
                    else
                        return l2.end - l1.end;

                }
            });
            int l = 0, max = logs.get(0).memory, res = logs.get(0).memory;
            for (int i = 1; i < logs.size(); ){
                Log curLog = logs.get(i);
                if (interAct(curLog, logs.get(l))){
                    i++;
                    res += curLog.memory;
                    max = Math.max(res, max);
                }else {
                    res -= logs.get(l).memory;
                    l++;
                }
            }
            return max;
        }
        return -1;
    }

    public boolean interAct(Log l1, Log l2){
        if (l2.start < l1.end)
            return true;
        else
            return false;
    }


    public int find(List<Log> logs){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0] - b[0]));
        for (Log log : logs){
            pq.add(new int[]{log.start, log.memory});
            pq.add(new int[]{log.end, -1 * log.memory});
        }
        int max = 0;
        while(pq.isEmpty()){
            int[] cur = pq.poll();
            max = Math.max(max, max + cur[1]);
        }
        return max;
    }
}
