package google.Array;

import java.util.*;

/**
 * Created by zhang on 2018/7/26.
 */
public class Student_GPATopK {
    public static class Pair{
        String id;
        double GPA;
        public Pair(String id, double GPA){
            this.id = id;
            this.GPA = GPA;
        }
    }

    public static List<Pair> solu(List<Pair> lists, int k){
        Collections.sort(lists, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.GPA > o2.GPA)
                    return -1;
                else
                    return 1;
            }
        });
        List<Pair> res = new ArrayList<>();
        for (int i = 0; i<k; i++){
            res.add(lists.get(i));
        }
        return res;
    }
    public static List<Pair> solus(List<Pair> lists, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.GPA > o2.GPA)
                    return 1;
                else
                    return -1;
            }
        });
        for (int i = 0; i<lists.size(); i++){
            if (pq.size()<k)
                pq.add(lists.get(i));
            else if (pq.peek().GPA < lists.get(i).GPA){
                pq.poll();
                pq.add(lists.get(i));
            }
        }
        List<Pair> res = new ArrayList<>();
        while (!pq.isEmpty()){
            res.add(pq.poll());
        }
        return res;
    }
        public static void main(String[] args){
        List<Pair> list = new ArrayList<>();
        list.add(new Pair("1",3.0));
        list.add(new Pair("2",2.0));
        list.add(new Pair("3",2.7));
        list.add(new Pair("4",3.1));
        solus(list,3);
        solu(list,3);
    }
}
