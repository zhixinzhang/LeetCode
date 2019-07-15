package google.Design;

import java.util.*;

/**
 * Created by zhang on 2018/6/13.
 * 公交车管理
 * 公交车站有很多汽车 {bus1 bus2 bus3}
 * bus 是一个类 有int id ,String companyname  和出发时间 实现几个函数
 * add(buss)
 * removeAll(company)
 * getnext
 * dispatch
 *
 */
class Bus{
    int id;
    int time;
    String name;
    Bus(int id, int time, String name){
        this.id = id;
        this.time = time;
        this.name = name;
    }
}
public class BusTerminalFP {
    int size;
    HashMap<String, PriorityQueue<Bus>> hm = new HashMap<String,PriorityQueue<Bus>>();
    Bus dis;
    BusTerminalFP(int size){
        this.size = size;
    }
    void removeAll(String company){
        hm.remove(company);
    }
    boolean add(Bus bus){
       hm.putIfAbsent(bus.name,new PriorityQueue<Bus>((a,b) -> (a.time - b.time)));
       hm.get(bus.name).add(bus);
       return true;
    }
    Bus getNext(){
        Bus b = new Bus(0,Integer.MAX_VALUE,"2");
        for (Map.Entry m : hm.entrySet()){
            PriorityQueue<Bus> buses = (PriorityQueue<Bus>)m.getValue();
            b = b.time < buses.peek().time ? b : buses.peek();
        }
        dis = b;
        return b;
    }
    void disPatch(){
        hm.get(dis.name).remove(dis);
    }
    public static void main(String[] args){
        BusTerminalFP bt = new BusTerminalFP(3);
        bt.add(new Bus(1,1,"a"));
        bt.add(new Bus(2,2,"c"));
        bt.add(new Bus(3,3,"c"));
        Bus re = bt.getNext();
//        bt.disPatch();
//        Bus ree = bt.getNext();
        bt.removeAll("c");

        int a = 0;
    }
}
