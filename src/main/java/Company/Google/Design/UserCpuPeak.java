package Company.Google.Design;

import java.util.*;

/**
 * Created by zhang on 2018/7/2.
 */
class resource{
    String id;
    int start;
    int end;
    int num;
}
class user{
    String id;
    List<resource> resId;
}
public class UserCpuPeak {
    public static List<user> solution(List<user> list){
        List<user> res = new ArrayList<>();
        // each user Peak cpu
        HashMap<String, Integer> hm = new HashMap<>();
        for (user u : list){
            int peak = helper(u);
            hm.put(u.id,peak);
        }
        return res;
    }
    public static int helper(user u){
        int res = 0;
        List<resource> resources = u.resId;
        HashMap<String, List<resource>> hm = new HashMap<>();
        for (resource r : resources){
            hm.putIfAbsent(r.id, new ArrayList<>());
            hm.get(r.id).add(r);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });
        for (Map.Entry<String, List<resource>> entry : hm.entrySet()){
            int curRes = 0;
            for (resource r : entry.getValue()){
                pq.add(new int[]{r.start, r.num});
                pq.add(new int[]{r.end, -r.num});
            }
            int max = 0;
            while (!pq.isEmpty()){
                int[] cur = pq.poll();
                curRes += cur[1];
                max = Math.max(curRes,max);
            }
            res = Math.max(res,max);
        }
        return res;
    }
    public static void main(String[] args){
        List<user> list = new ArrayList<>();
        solution(list);
    }
}
