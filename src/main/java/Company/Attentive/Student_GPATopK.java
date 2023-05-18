package Company.Attentive;

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

    // Top K PQ different all PQ
    // Top K PQ use Min Heap
    // All PQ use Max Heap
    public static List<Pair> solus(List<Pair> lists, int k) {
        PriorityQueue<Pair> minPQ = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.GPA != o2.GPA)
                    return Double.compare(o1.GPA, o2.GPA);
                else
                    return o1.id.compareTo(o2.id);
            }
        });

        for (int i = 0; i < lists.size(); i++){
            minPQ.add(lists.get(i));
            if (minPQ.size() > k)
                minPQ.poll();
            
        }

        List<Pair> res = new ArrayList<>();
        while (!minPQ.isEmpty()){
            Pair p = minPQ.poll();
            System.out.println(p.id);
            res.add(p);
        }


        Collections.reverse(res);
        res.forEach(System.out::println);
        return res;
    }
        public static void main(String[] args){
        List<Pair> list = new ArrayList<>();
        list.add(new Pair("1",3.0));
        list.add(new Pair("2",2.0));
        list.add(new Pair("3",2.7));
        list.add(new Pair("4",3.1));
        list.add(new Pair("5",3.1));
        solus(list,5);
        // solu(list,3);
    }
}
