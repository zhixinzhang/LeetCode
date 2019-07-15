package google.Design;

import java.util.*;

/**
 * Created by zhang on 2018/7/2.
 */
public class TopKTalkUser {
    public static List<String> solution(List<String> logs, int k){
        //nlogk
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i<logs.size(); i++){
            String name = logs.get(i).split(">")[0].split("<")[1];
            hm.putIfAbsent(name,0);
            int count = hm.get(name);
            hm.put(name,count+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for (Map.Entry<String,Integer> entry : hm.entrySet()){
            minHeap.add(entry);
            if (minHeap.size() > k)
                minHeap.poll();

//            if (minHeap.size() < k)
//                minHeap.add(entry);
//            else if (entry.getValue() > minHeap.peek().getValue()){
//                minHeap.add(entry);
//            }
        }
        for (int i = 0; i<minHeap.size(); i++){
            res.add(minHeap.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }


    public static void main(String[] args){
        String l = "preambles <zzx> \"Senetence\"";
        String l2 = "preambles <zzx> \"Senetence\"";
        String l3 = "preambles <zzx> \"Senetence\"";
        String l4 = "preambles <a> \"Senetence\"";
        String l5 = "preambles <b> \"Senetence\"";
        String l6 = "preambles <b> \"Senetence\"";


        List<String> list = new ArrayList<>();
        list.add(l);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);
        list.add(l6);

        solution(list,2);
    }


}
