package Company.Robinhood;
import java.util.*;


// https://www.1point3acres.com/bbs/thread-807470-1-1.html
// Similar : https://leetcode.com/discuss/interview-question/1483795/karat-interview-robinhood
// If there are multiple one-hour periods where this was true for an employee, just return the first one.
public class _EmployeeBadgeTime_Map_SlidingWindow {
    public static void main(String[] args) {
        String[][] input = new String[][]{
            {"Paul","13:55"}, 
            {"Jennifer","19:10"},
            {"Paul","13:15"}, 
            {"Paul","14:05"}, 
            {"Paul","14:55"},
            {"Paul","14:40"},
            {"Paul","13:45"},
            {"Paul","13:40"},
            {"Paul","13:55"}, 
            {"Luke","10:10"},
            {"Luke","10:11"}, 
            {"Luke","15:05"}, 
            {"Luke","10:20"},
            {"Luke","10:50"},
            {"Luke","10:55"}  
        };
        int k = 3;
        alertNamesInFirstHour(input, k);
      }

    private static Map<String, List<String>> alertNamesInFirstHour(String[][] input, int k){
        Map<String, List<String>> ans = new HashMap<>();
        Map<String, List<String>> cache = new HashMap<>();

        for (String[] in : input){
            String name = in[0];
            String time = in[1];
            cache.putIfAbsent(name, new ArrayList<>());
            cache.get(name).add(time);
        }

        for (String name : cache.keySet()){
            Collections.sort(cache.get(name));
            int[] minutes = new int[cache.get(name).size()];
            for (int i = cache.get(name).size() - 1; i >= 0; i--) {
                String[] minHour = cache.get(name).get(i).split(":");
                minutes[i] = (Integer.valueOf(minHour[0]) * 60 + Integer.valueOf(minHour[1])) % 1440;
            }

            a:for (int i = 0; i < minutes.length; i++){
                int nextTimeIndex = i + k - 1;
                if (nextTimeIndex < minutes.length && minutes[nextTimeIndex] - minutes[i] <= 60){     // find out time intervial
                    List<String> sb = new ArrayList();
                    int tempIndex = i;
                    while (tempIndex < minutes.length && minutes[tempIndex] - minutes[i] <= 60){
                        sb.add(cache.get(name).get(tempIndex));
                        tempIndex++;
                    }
                    ans.put(name, sb);
                    break a;
                } 
            }
        }

        for (String key : ans.keySet()){
            System.out.println(key + " : " + String.join(",", ans.get(key)));
        }
        return ans;
    }
}
