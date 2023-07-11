package Company.Doordash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.1point3acres.com/bbs/thread-828828-1-1.html
// 简单讲就是饭店都有开门时间和关门时间，要写一个function，输入是开门和关门的时间

// https://www.1point3acres.com/bbs/thread-990863-1-1.html

public class TimeNextOpen {
     public static Map<String, Integer> dayToInt;
        static {
            dayToInt = new HashMap<>();
            dayToInt.put("mon", 1);
            dayToInt.put("tue", 2);
            dayToInt.put("wed", 3);
            dayToInt.put("thu", 4);
            dayToInt.put("fri", 5);
            dayToInt.put("sat", 6);
            dayToInt.put("sun", 7);
        }

    public static List<String> openCloseTime(String[] timeRange){
        //Getting all the arguments
        String open = timeRange[0];
        String close = timeRange[1];
        String[] openArgs = open.split(" ");
        String[] openHourMin = openArgs[1].split(":");
        String[] closeArgs = close.split(" ");
        String[] closeHourMin = closeArgs[1].split(":");
        int openDay = dayToInt.get(openArgs[0]);
        int closeDay = dayToInt.get(closeArgs[0]);
        int openH = Integer.parseInt(openHourMin[0]);
        int closeH = Integer.parseInt(closeHourMin[0]);
        int openMin = Integer.parseInt(openHourMin[1]);
        int closeMin = Integer.parseInt(closeHourMin[1]);
        //Convert pm
        if(openArgs[2].equals("pm")){
            openH += 12;
        }
        if(closeArgs[2].equals("pm")){
            closeH += 12;
        }
        //Covert non 5 min interval open minutes and close minutes
        if(openMin % 5 != 0){
            int addOn = 5 - (openMin % 5);
            openMin += addOn;
        }
        if(closeMin % 5 != 0){
        int remove = closeMin % 5;
        closeMin -= remove;
        }
        //Populate result
        List<String> result = new ArrayList<>();
        if(openDay <= closeDay){
        helper(openDay, openH, openMin, closeDay, closeH, closeMin, result);
        } else {
        helper(openDay, openH, openMin, 7, 23, 55, result);
        helper(1, 0, 0, closeDay, closeH, closeMin, result);
        }
        return result;
    }

     private static void helper(int openDay, int openH, int openMin, int closeDay, int closeH, int closeMin, List<String> result){
        int day = openDay;
        int hour = openH;
        int min = openMin;
        while(day <= closeDay){
            int endHour = day == closeDay ? closeH : 23;
            while(hour <= endHour){
                int endMin = hour == closeH ? closeMin : 55;
                while(min <= endMin){
                    StringBuilder sb = new StringBuilder();
                    sb.append(day);
                    if(hour < 10) sb.append(0);
                    sb.append(hour);
                    if(min < 10) sb.append(0);
                    sb.append(min);
                    result.add(sb.toString());
                    min += 5;
                }
                if(min == 60) min = 0;
                     hour++;
                }
                hour = 0;
                day++;
            }
        }

        public static void main(String[] args) {
            String[] testTimeRange0 = new String[]{"mon 11:22 am", "mon 12:14 am"};
            List<String> result0 = openCloseTime(testTimeRange0);
            System.out.println("Test 0");
            System.out.println(result0);
            String[] testTimeRange1 = new String[]{"mon 10:00 am", "mon 11:00 am"};
            List<String> result1 = openCloseTime(testTimeRange1);
            System.out.println("Test 1");
            System.out.println(result1);
            String[] testTimeRange2 = new String[]{"mon 9:15 am", "mon 10:00 am"};
            List<String> result2 = openCloseTime(testTimeRange2);
            System.out.println("Test 2");
            System.out.println(result2);
            String[] testTimeRange3 = new String[]{"mon 11:55 pm", "tue 00:15 am"};
            List<String> result3 = openCloseTime(testTimeRange3);
            System.out.println("Test 3");
            System.out.println(result3);
            String[] testTimeRange4 = new String[]{"mon 10:02 am", "mon 11:06 am"};
            List<String> result4 = openCloseTime(testTimeRange4);
            System.out.println("Test 4");
            System.out.println(result4);
        }
}


