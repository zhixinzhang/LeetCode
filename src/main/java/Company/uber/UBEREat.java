package Company.uber;

import java.util.*;

/**
 * Created by zhang on 2018/9/20.
 */



public class UBEREat {
    static class UberEat{
        HashMap<Integer, Order> history = new HashMap<>();
        public void add(int id, String name, int time){
            history.putIfAbsent(time, new Order());
            Order cur = history.get(time);
            cur.update(name);
        }
        public List<String> topK(int time, int k){
            List<String> res;
            Order order = history.get(time);
            res = order.findK(time,k);
            return res;
        }
    }
    static class Order{
        HashMap<String, Integer> count = new HashMap<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(1, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.num - o2.num;
            }
        });
        public void update(String name){
            count.putIfAbsent(name, 0);
            count.put(name, count.get(name)+1);
        }
        public List<String> findK(int time, int k){
            List<String> res = new ArrayList<>();
            for (String s : count.keySet()){
                Pair p = new Pair(count.get(s), s);
                minHeap.add(p);
            }
            for(Pair i : minHeap){
                res.add(i.name);
            }
            return res;
        }
    }
    static class Pair{
        int num;
        String name;
        public Pair(int num, String name){
            this.name = name;
            this.num = num;
        }
    }
        public static void main(String[] args){
            UberEat u = new UberEat();
            u.add(1,"a",1);
            u.add(1,"a",1);
            u.add(1,"a",1);
            u.add(1,"a",1);
            u.add(1,"a",1);
            u.add(1,"b",1);
            u.add(1,"b",1);
            u.add(1,"b",1);
            System.out.println(u.topK(1,3));
        }
}
