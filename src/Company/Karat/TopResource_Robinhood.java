package Company.Karat;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 6/26/2021 1:57 PM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class TopResource_Robinhood {
    public static void main(String[] args){
        String[][] logs = new String[][]{
                {"resource1", "user0", "300"},
                {"resource2", "user1", "200"},
                {"resource1", "user2", "500"},
                {"resource3", "user0", "600"}
        };
        findTop(logs);
    }


    private static String findTop(String[][] logs){
        int min = 500;
        if (logs == null || logs.length == 0) {
            return "";
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String[] log : logs){
            String res = log[0];
            map.putIfAbsent(res, new ArrayList<>());
            map.get(res).add(log[2]);
        }

        PriorityQueue<String[]> pq = new PriorityQueue<>((a,b) -> (b[1].compareTo(a[1])));
        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            List<String> curTimes = entry.getValue();
            Collections.sort(curTimes);

            Deque<String> dq = new ArrayDeque<>();
//            dq.addLast("1");
//            dq.removeFirst();
            int left = 0, right = 0, maxCount = 0;
            while (left <= right && right < curTimes.size()) {
                int leftVal = Integer.valueOf(curTimes.get(left));
                int rightVal = Integer.valueOf(curTimes.get(right));
                if (rightVal - leftVal < min) {
                    maxCount = Math.max(maxCount, right - leftVal);
                    right ++;
                } else {
                    left ++;
                }
            }

            pq.add(new String[]{entry.getKey(), String.valueOf(maxCount)});
        }

        String ans = pq.peek()[0];
        return ans;
    }
}
