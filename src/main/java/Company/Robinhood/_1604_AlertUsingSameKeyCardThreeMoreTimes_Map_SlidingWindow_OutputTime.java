package Company.Robinhood;
import java.util.*;
// https://leetcode.com/discuss/interview-question/1483795/Karat-Interview-Robinhood
// * @author Luke Zhang
// * @Date 2023-2-18

public class _1604_AlertUsingSameKeyCardThreeMoreTimes_Map_SlidingWindow_OutputTime {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
          map.putIfAbsent(keyName[i], new ArrayList<>());
          map.get(keyName[i]).add(keyTime[i]);
        }
    
        for (String key : map.keySet()) {
          map.get(key).sort(Comparator.naturalOrder());
        }
    
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
    
          List<String> access = map.get(key);
          int[] minutes = new int[access.size()];
    
          for (int i = access.size() - 1; i >= 0; i--) {
            String[] minHour = access.get(i).split(":");
            minutes[i] = (Integer.valueOf(minHour[0]) * 60 + Integer.valueOf(minHour[1])) % 1440;
          }
          
          int j = 2;
          while (j < minutes.length) {
            if (minutes[j] - minutes[j - 2] <= 60) {
              StringBuilder sb = new StringBuilder();
              int i = j-1;
              while (i < minutes.length && minutes[i]-minutes[i-1] <= 60) {
                sb.append(access.get(i) +",");
                i++;
              }
              sb.deleteCharAt(sb.length()-1);
              result.add(key + ": " + sb.toString());
              break;
            }
            j++;
          }
        }
    
        result.sort(Comparator.naturalOrder());
        return result;
      }
    
      public static void main(String[] args) {
        _1604_AlertUsingSameKeyCardThreeMoreTimes_Map_SlidingWindow_OutputTime algo = new _1604_AlertUsingSameKeyCardThreeMoreTimes_Map_SlidingWindow_OutputTime();
        String[] keyName = new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime = new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        System.out.println(algo.alertNames(keyName, keyTime).toString());
    
        String[] keyName2 = new String[]{"alice", "alice", "alice", "bob", "bob", "bob", "bob"};
        String[] keyTime2 = new String[]{"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"};
        System.out.println(algo.alertNames(keyName2, keyTime2).toString());
    
        String[] names = new String[]{"a", "a", "a", "a", "b", "b", "b", "b", "b", "b", "c", "c", "c", "c"};
    String[] times = new String[]{"01:35", "08:43", "20:49", "00:01", "17:44", "02:50", "18:48", "22:27", "14:12", "18:00", "12:38", "20:40",     "03:59", "22:24"};
        System.out.println(algo.alertNames(names, times));
    
        String[] nomis = new String[]{"daniel", "daniel", "daniel", "daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] timis = new String[]{"10:00", "10:40", "10:50", "10:51", "10:55", "11:00", "09:00", "11:00", "13:00", "15:00"};
        System.out.println(algo.alertNames(nomis, timis));
      }
}
