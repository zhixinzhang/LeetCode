package DataStructure.String;

import java.util.HashSet;

/**
 * Created by zhang on 2017/11/17.
 */
public class _681_NextClosestTime_ {
        public static String nextClosetTime(String time){
            //19:34 --- 19.39
            String res = "";
            int hourTime = Integer.valueOf(time.split(":")[0]);
            int minTime = Integer.valueOf(time.split(":")[1]);
            while (true) {
                Boolean timeIsValid = true;
                //mintues ++
                if (++minTime == 60) {
                    minTime = 0;
                    ++hourTime;
                    hourTime %= 24;
                }
//                res = String.valueOf(hour) + ":" + String.valueOf(min);
                 res = String.format("%02d:%02d", hourTime, minTime);
                for (int i = 0; i < res.length(); ++i)
                    if (time.indexOf(res.charAt(i)) < 0) {
                        timeIsValid = false;
                        break;
                    }
                if (timeIsValid){
                    return res;
                }
            }
        }
//public static  String nextClosetTime(String time) {
//    int hour = DataStructure.Integer.parseInt(time.substring(0, 2));
//    int min = DataStructure.Integer.parseInt(time.substring(3, 5));
//    while (true) {
//        if (++min == 60) {
//            min = 0;
//            ++hour;
//            hour %= 24;
//        }
//        String curr = String.format("%02d:%02d", hour, min);
//        Boolean valid = true;
//        for (int i = 0; i < curr.length(); ++i)
//            if (time.indexOf(curr.charAt(i)) < 0) {
//                valid = false;
//                break;
//            }
//        if (valid) return curr;
//    }
//}
        public static void main(String[] args){
            String res = nextClosetTime("23:59");
            System.out.println(res);
            int a = 0;
        }
}
