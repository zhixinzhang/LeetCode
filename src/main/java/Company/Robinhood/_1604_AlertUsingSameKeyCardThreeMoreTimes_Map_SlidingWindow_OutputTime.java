package Company.Robinhood;
import java.util.*;
// https://leetcode.com/discuss/interview-question/1483795/Karat-Interview-Robinhood
// * @author Luke Zhang
// * @Date 2023-2-18
/**
 * i/p:
["daniel","daniel","daniel","daniel","daniel","daniel","luis","luis","luis","luis"]
["10:00","10:40","10:50","10:51","10:55","11:00","09:00","11:00","13:00","15:00"]
o/p:
[[daniel:10:00,10:40,10:50,10:51,10:55,11:00]]

daniel user's badge access time is 3 or more times in the 1 hr window and the badge time list of 1 hr window is 10:00,10:40,10:50,10:51,10:55,11:00.
 * 
*/

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
    
      // Only output name use Treeset and Deque
      public List<String> alertNames_TreeSet(String[] keyName, String[] keyTime) {
        Map<String, TreeSet<Integer>> nameToTime = new HashMap<>();
        for (int i = 0; i < keyName.length; ++i) {
            int time = Integer.parseInt(keyTime[i].substring(0, 2)) * 60 + Integer.parseInt(keyTime[i].substring(3));
            nameToTime.computeIfAbsent(keyName[i], s -> new TreeSet<>()).add(time);
        }
        TreeSet<String> names = new TreeSet<>();
        for (Map.Entry<String, TreeSet<Integer>> e : nameToTime.entrySet()) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int time : e.getValue()) {
                dq.offer(time);
                if (dq.peekLast() - dq.peek() > 60) {
                    dq.poll();
                }
                if (dq.size() >= 3) {
                    // names.add(e.getKey());
                    StringBuilder sb = new StringBuilder();
                    while (!dq.isEmpty()){
                      sb.append(String.valueOf(dq.pollFirst()));
                      sb.append(",");
                    }
                    names.add(e.getKey() + ": " + sb.toString());
                    break;
                }
            }
        }
        return new ArrayList<>(names);
      }

    // Only output name use Map and sliding and Deque
    public List<String> alertNames_Sliding(String[] keyName, String[] keyTime) {
           Map<String, List<Integer>> accessMap = new HashMap<>();

          for (int i = 0; i < keyName.length; i++) {
              accessMap.computeIfAbsent(keyName[i], k -> new ArrayList<Integer>()).add(getMin(keyTime[i]));
          }
          
          List<String> alertList = new ArrayList<>();
          for (Map.Entry<String, List<Integer>> records : accessMap.entrySet()) {
              String name = records.getKey();
              List<Integer> times = records.getValue();
              Collections.sort(times);
              
              for (int i = 2; i < times.size(); i++) {
                  if (times.get(i) - times.get(i - 2) <= 60) {
                      alertList.add(name);
                      break;
                  }
              }
          }
          Collections.sort(alertList);
          return alertList;
        }

    private int getMin(String timestamp) {
              String[] parts = timestamp.split(":");
              return Integer.valueOf(parts[1]) + 60 * Integer.valueOf(parts[0]);   
    }
      public static void main(String[] args) {
        _1604_AlertUsingSameKeyCardThreeMoreTimes_Map_SlidingWindow_OutputTime algo = new _1604_AlertUsingSameKeyCardThreeMoreTimes_Map_SlidingWindow_OutputTime();
        String[] keyName = new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime = new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        System.out.println(algo.alertNames(keyName, keyTime).toString());
        // System.out.println(algo.alertNames_TreeSet(keyName, keyTime).toString());
    
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
