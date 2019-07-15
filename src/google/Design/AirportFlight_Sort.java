package google.Design;

import java.util.Collections;
import java.util.List;

/**
 * Created by zhang on 2018/8/5.
 * 1. 飞机场A，B，C，D。 A只能飞到B， B只能飞到C，以此类推。A到B有很多航班，starttime， endtime表示，每个航班飞行时间不一样。比如1:15～1:40， 2:00～2:10.。。。
 问最早到达飞机场D的时间
 */
public class AirportFlight_Sort {
    class Flight{
        double startTime;
        double endTime;
        Flight(double startTime, double endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    public double findFisrtTime(List<List<Flight>> schedule){
        double res = -1;
        if (schedule == null || schedule.size() == 0) return res;
//        res = Double.MIN_VALUE;
        for (int i = 0; i<schedule.size(); i++){
            int size = schedule.get(i).size();
            List<Flight> curSch = schedule.get(i);
            Collections.sort(curSch,(a,b)->Double.compare(a.endTime , b.endTime));
            for (int j = 0; i < size; i++){
                if (res < curSch.get(j).startTime){
                    res = curSch.get(j).endTime;
                    break;
                }
            }
        }
        return res;
    }
}
