package Company.Robinhood;
import java.util.*;

/**
 * https://www.1point3acres.com/bbs/thread-807470-1-1.html
 * Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.
The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.
 * 
*/
public class _ResourceAccessLog_ {
    // Question 1 - Write a function that takes the logs and returns each users min and max access timestamp

    public static void main(String[] args){
        String[][] input = new String[][]{
            {"58523", "user_1", "resource_1"},
            {"62314", "user_2", "resource_2"},
            {"54001", "user_1", "resource_3"},
            {"200", "user_6", "resource_5"},
            {"215", "user_6", "resource_4"},
            {"54060", "user_2", "resource_3"},
            {"53760", "user_3", "resource_3"},
            {"58522", "user_2", "resource_1"},
            {"53651", "user_5", "resource_3"},
            {"2", "user_6", "resource_1"},
            {"100", "user_6", "resource_6"},
            {"400", "user_7", "resource_2"},
            {"100", "user_8", "resource_6"},
            {"54359", "user_1", "resource_3"}
        };

        String[][] input2 = new String[][]{
            {"54001", "user_1", "resource_3"},
            {"54060", "user_2", "resource_3"},
            {"53740", "user_3", "resource_3"},
            {"53651", "user_5", "resource_3"},
            {"54359", "user_1", "resource_3"}
        };
        // findMinAndMaxResources(input);
        most_requested_resource(input2, 100);
    }

    private static Map<String, String[]> findMinAndMaxResources(String[][] input){
        Map<String, String[]> ans = new HashMap<>();
        for (String[] res : input){
            String name = res[1];
            String time = res[0];
            ans.putIfAbsent(name, new String[]{time, time});
            if (Integer.valueOf(time) < Integer.valueOf(ans.get(name)[0])) {
                ans.get(name)[0] = time;
            }
            if (Integer.valueOf(time) > Integer.valueOf(ans.get(name)[1])) {
                ans.get(name)[1] = time;
            }
        }

        for (String name : ans.keySet()){
            System.out.println(name + ":" + "[" + ans.get(name)[0] + "," + ans.get(name)[1] + "]");
        }

        return ans;
    }

    // Question 2 -Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.

    private static Map<String, Integer>  most_requested_resource(String[][] input, int timeGap){
        Map<String, List<Integer>> cache = new HashMap<>();
        Map<String, Integer> ans = new HashMap<>();
        for (String[] res : input){
            String time = res[0];
            String resource = res[2];
            cache.putIfAbsent(resource, new ArrayList<>());
            cache.get(resource).add(Integer.valueOf(time));
        }

        int maxCount = 1;
        for (String resource : cache.keySet()){
            List<Integer> times = cache.get(resource);
            Collections.sort(times);
            for (int i = 0, j = i + 1; j < times.size(); ){
                while (j < times.size() && times.get(j) - times.get(i) <= timeGap) {
                    j++;
                }
                maxCount = Math.max(maxCount, j - i);
                i++;
                if (j == times.size() - 1) {
                    break;
                }
            }

            ans.put(resource, maxCount);
        }

        return ans;
    }
}
