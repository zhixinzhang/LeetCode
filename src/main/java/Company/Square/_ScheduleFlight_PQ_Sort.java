package Company.Square;

import java.util.*;
// https://www.1point3acres.com/bbs/thread-917529-1-1.html

/**
 * # United_123, 05:30, 180
 * # Alaska_475, 14:50, 92
 * # Alaska_472, 16:00, 48
 * # Southwest_447, 07:30, 176
 * # Southwest_847, 15:10, 151
 * 
 */

public class _ScheduleFlight_PQ_Sort {

    static private class FlightNode {
        String uID;
        String time;
        int passenger;

        public FlightNode(String uID, String time, int value) {
            this.uID = uID;
            this.time = time;
            this.passenger = value;
        }
    }

    public static void main(String[] args) {
        List<FlightNode> schedules = new ArrayList<>();
        schedules.add(new FlightNode("United_123", "05:30", 180));
        schedules.add(new FlightNode("Alaska_475", "14:50", 92));
        schedules.add(new FlightNode("Alaska_472", "16:00", 48));
        schedules.add(new FlightNode("Southwest_447", "07:30", 176));
        schedules.add(new FlightNode("Southwest_847", "15:10", 151));
        schedules.add(new FlightNode("Southwest_848", "15:10", 152));
        scheduleFlight(schedules);

        addFlight(schedules);
    }

    private static void scheduleFlight(List<FlightNode> schedules){
        Collections.sort(schedules, new Comparator<FlightNode>() {
            @Override
            public int compare(FlightNode o1, FlightNode o2){
                if (o1.time == o2.time) {
                    return o2.passenger - o1.passenger;
                } else {
                    return o1.time.compareTo(o2.time);
                }
            }
        });

        for (FlightNode fNode : schedules){
            System.out.println("flight ID is :  " + fNode.uID + "   time is " + fNode.time + "  " + String.valueOf(fNode.passenger));
        }
    }

    private static void addFlight(List<FlightNode> schedules){
        PriorityQueue<FlightNode> pq = new PriorityQueue<>(new Comparator<FlightNode>() {
            @Override
            public int compare(FlightNode o1, FlightNode o2){
                if (o1.time == o2.time) {
                    return o2.passenger - o1.passenger;
                } else {
                    return o1.time.compareTo(o2.time);
                }
            }
        });

        for (FlightNode fNode : schedules){
            pq.add(fNode);
        }
    }
}
