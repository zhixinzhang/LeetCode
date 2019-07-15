package google.Design;
import java.util.*;
/**
 * Created by zhang on 2018/6/21.
 */
public class VoteTimeStamp {
    static class Vote{
        String name;
        int time;
        public Vote(String name, int time){
            this.name = name;
            this.time = time;
        }
    }
    public static String solution(List<Vote> list, int curTime){
        if (list == null || list.size() == 0) return "";
        HashMap<String, List<Integer>> hm = new HashMap<>();
        for (Vote v : list){
            hm.putIfAbsent(v.name, new ArrayList<>());
            hm.get(v.name).add(v.time);
        }
        String res = list.get(0).name;
        int maxVote = 0;
        for (Map.Entry<String, List<Integer>> entry : hm.entrySet()){
            int vote = bs(entry.getValue(), curTime);
            if (vote > maxVote){
                res = entry.getKey();
                maxVote = vote;
            }
        }
        return res;
    }
    public static int bs(List<Integer> list, int curTime){
        //0 0 0 1
        /**l 0 2
         * r 3 3
         * m 1 3
         * */
        int l= 0, r = list.size() -1;
        while (l < r){
            int mid = l + (r - l) / 2;
            if (list.get(mid) > curTime)
                r = mid;
            else
                l = mid + 1;  // l = 1
        }
        if (list.get(r) <= curTime)
            return r - 0 + 1;
        else return r - 0;
    }

    public static void main(String[] args){
        Vote vts = new Vote("a",0);
        Vote vts1 = new Vote("a",0);
        Vote vts2 = new Vote("a",1);
        Vote vts3 = new Vote("a",1);

        Vote vt = new Vote("",0);
        Vote vt1 = new Vote("",0);
        Vote vt2 = new Vote("a",1);
        Vote vt3 = new Vote("a",1);

        List<Vote> l = new ArrayList<>();
        l.add(vts);
        l.add(vts1);
        l.add(vts2);
        l.add(vts3);
        l.add(vt);
        l.add(vt1);
        l.add(vt2);
        l.add(vt3);
        solution(l,1);
    }
}
