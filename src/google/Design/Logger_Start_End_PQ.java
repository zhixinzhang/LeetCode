package google.Design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by zhang on 2018/7/27.
 */
public class Logger_Start_End_PQ {
    static class Log{
        int id;
        int start;
        int end;
        public Log(int id, int start){
            this.id = id;
            this.start = start;
            end = -1;
        }
    }
    static HashMap<Integer, Log> hm = new HashMap<>();
    static PriorityQueue<Log> pq = new PriorityQueue<>((a,b)->(a.start - b.start));
    public static void wirte(){
        while (!pq.isEmpty()){
            Log l = pq.poll();
            System.out.println(l.id + "   start : " + l.start + " end :" + l.end);
        }
    }
    public static void rStart(int id, int start){
        Log l = new Log(id, start);
        hm.putIfAbsent(id, l);
    }
    public static void end(int id, int end){
        if (!hm.containsKey(id) || end < hm.get(id).start)
            return;
        else
            hm.get(id).end = end;
        pq.add(hm.get(id));
    }

    public static void main(String[] args){
        rStart(2, 7);
        rStart(1, 2);
        rStart(3, 3);

        end(1,5);
        end(2,3);
        end(3,10);
        wirte();
    }
}
