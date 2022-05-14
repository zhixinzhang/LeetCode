package google.Design;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/6/13.
 *
 第一轮： 国人小哥，聊了一会上题 （数据结构题）  公交车站里面有若干公共汽车， 类似这样 terminal:{bus1, bus2, bus3, ...}， bus是一个类， 有int id, String company name 和一个出发时间 int time. 然后让实现几个函数 ： add(bus) 向一个车站里加入一辆车，getnext() 得到下一辆出发的车， dispatch() 让下一辆车从车站出发, removeAll(company) 除掉车站中某一个公司的所有车。 每个函数的时间复杂度。
 follow up, 自己实现priority queue 来实现上面的每个问题。

 最开始用arrayList follow up 用 pq
 */
public class BusTerminal {  // follow up  BusTerminalFP
    int size;
    List<Bus> terminalList;
   static class Bus{
        int id;
        String company;
        int time;
        Bus(int id, String company, int time){
            this.company = company;
            this.id = id;
            this.time = time;
        }
    }
    BusTerminal(int size){
        this.size = size;
        terminalList =  new ArrayList<>();
    }
    boolean addBus(Bus bus){
        if (terminalList.size() >= size){
            return false;
        }
        terminalList.add(bus);
        return true;
    }
    Bus getNext(){
        if (terminalList.size() == 0) return null;
        Bus res = terminalList.get(0);
        for(int i = 1; i<terminalList.size();i++){
            Bus cur = terminalList.get(i);
            res = res.time > cur.time ? res : cur;
        }
        return res;
    }
    void dispatch(){
        if (terminalList.size() == 0) return;
        Bus nextBus = getNext();
        terminalList.remove(nextBus);
        return;
    }

    void removeAll(){
        if (terminalList.size() == 0) return;
        terminalList.clear();
    }


    public static void main(String[] args){
        BusTerminal bt = new BusTerminal(5);
        Bus bus = new Bus(1,"zzx",1);
        Bus bus1 = new Bus(2,"zzx",2);
        bt.addBus(bus);
        bt.addBus(bus1);
        Bus b = bt.getNext();
        bt.removeAll();
    }

}
