package Company.Roblox.Karat;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 *  2022-6-13
 * https://www.1point3acres.com/bbs/thread-903586-1-1.html
 * */

public class UnsortedLog {
    public static void main(String[] args){
        String[][] logs1 = new String[][]{
                {"58523", "user_1", "resource_1"},
                {"62314", "user_2", "resource_2"},
                {"54001", "user_1", "resource_3"},
                {"200", "user_6", "resource_5"},
                {"215", "user_6", "resource_4"},
                {"54060", "user_2", "resource_3"},
                {"53760", "user_3", "resource_3"},
                {"58522", "user_22", "resource_1"},
                {"53651", "user_5", "resource_3"},
                {"2", "user_6", "resource_1"},
                {"100", "user_6", "resource_6"},
                {"400", "user_7", "resource_2"},
                {"100", "user_8", "resource_6"},
                {"54359", "user_1", "resource_3"}
        };

        System.out.println("first question");
        Map<String, int[]> map = findUserMaxAndMin(logs1);
        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + Arrays.toString(entry.getValue()));
        }
        System.out.println("----------------");
        String[][] logs2 = new String[][]{
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };
        findHighestAccessedRes(logs1);
        System.out.println("----------------");

        System.out.println("follow up");
        Map<String, Map<String, Double>> res = buildTransition(logs1);
        for (Map.Entry<String, Map<String, Double>> entry : res.entrySet()) {
            System.out.println(entry.getKey() + ":" + (entry.getValue()));
        }

    }


    // 1 Question 1 - Write a function that takes the logs and returns each users min and max access timestamp

    public static Map<String, int[]> findUserMaxAndMin(String[][] logs){
        Map<String, int[]> res = new HashMap<>();
        if (logs == null || logs.length == 0) {
            return res;
        }

        for (String[] log: logs) {
            String user = log[1];
            int t = Integer.parseInt(log[0]);
            res.putIfAbsent(user, new int[]{t, t});
            res.get(user)[0] = Math.min(t, res.get(user)[0]);
            res.get(user)[1] = Math.max(t, res.get(user)[1]);
        }
        return res;
    }

    // Question 2 - Write a function that takes the logs and returns the resource with the highest number of accesses
    // in any 5 minute window, together with how many accesses it saw.

    public static void findHighestAccessedRes(String[][] logs) {
        Map<String, List<Integer>> reToTimes = new HashMap<>();
        for (String[] log: logs) {
            reToTimes.computeIfAbsent(log[2], k -> new ArrayList<>()).add(Integer.parseInt(log[0]));
        }

        int maxFreq = 0;
        String maxResource = null;
        for (String resource: reToTimes.keySet()) {
            List<Integer> times = reToTimes.get(resource);
            Collections.sort(times);

            int tmpMaxFreq = helper(times);
            if (tmpMaxFreq > maxFreq) {
                maxFreq = tmpMaxFreq;
                maxResource = resource;
            }
        }
        System.out.println(String.format("('%s', %s)", maxResource, maxFreq));
    }

    // Find out max freq in 5 minutes
    private static int helper(List<Integer> times) {
        int maxFreq = 0;
        int l = 0;
        for (int r = 0; r < times.size(); r++) {
            while (l < r && times.get(l) + 300 < times.get(r)) {
                l++;
            }
            maxFreq = Math.max(maxFreq, r - l + 1);
        }
        return maxFreq;
    }

    // https://leetcode.com/discuss/interview-question/1927273/indeed-karat-question
    // Write a function that takes the logs as input, builds the transition graph and returns it as
    // an adjacency list with probabilities. Add START and END states.
    public static Map<String, Map<String, Double>> buildTransition(String[][] logs) {
        // Create Map(user -> logs)
        Map<String, List<String[]>> userLogs = new HashMap<>();
        for (String[] log: logs) {
            userLogs.computeIfAbsent(log[1], k -> new ArrayList<>()).add(log);
        }

        // Create Map(re -> Map(next, freq))
        Map<String, Map<String, Integer>> reToNextFreqs = new HashMap<>();
        for (List<String[]> logList: userLogs.values()) {
            logList.sort(Comparator.comparing(l -> Integer.parseInt(l[0])));

            String prev = "START";
            for (String[] log: logList) {
                String curr = log[2];
                reToNextFreqs.computeIfAbsent(prev, k -> new HashMap<>()).merge(curr, 1, Integer::sum);
                prev = curr;
            }
            reToNextFreqs.computeIfAbsent(prev, k -> new HashMap<>()).merge("END", 1, Integer::sum);
        }

        // Convert to transit graph with probabilities
        Map<String, Map<String, Double>> res = new HashMap<>();
        reToNextFreqs.forEach((re, nextFreqs) -> {
            int total = nextFreqs.values().stream().mapToInt(i -> i).sum();
            Map<String, Double> probMap = nextFreqs.entrySet().stream().collect(
                    Collectors.toMap(
                            Map.Entry::getKey,
                            e -> (double) e.getValue() / total
                    )
            );
            res.put(re, probMap);
        });
        return res;
    }

}
