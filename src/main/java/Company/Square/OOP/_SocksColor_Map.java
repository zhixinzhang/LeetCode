package Company.Square.OOP;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _SocksColor_Map {
    public static void main(String[] args) {
        String[][] inputs = new String[][]{
            {"1", "left", "black"},
            {"2", "right", "pink"},
            {"3", "left", "pink"},
            {"4", "right", "black"},
            {"5", "right", "black"}
        };

        String[][] inputs2 = new String[][]{
            {"1", "left", "white"},
            {"2", "right", "white"},
            {"3", "left", "pink"},
            {"4", "right", "black"},
            {"5", "right", "pink"},
            {"6", "right", "yellow"},
            {"7", "left", "orange"}
        };

        
        findPairs(inputs);      // [4, 1]  [3, 2]
        findPairs(inputs2);      // [2, 1]  [3, 5]

        String[][] rules = new String[][]{{"orange", "black"}, {"black", "red"}};
        System.out.println("follow up");
        findPairsFollow(inputs2, rules);
    }

    private static List<int[]> findPairs(String[][] inputs){
        List<int[]> ans = new ArrayList<>();
        Map<String, ArrayDeque<Integer>> cache = new HashMap<>();
        for (String[] inp : inputs){
            int index = Integer.valueOf(inp[0]);
            String side = inp[1];
            String color = inp[2];
            String curSock = side + " : " + color;      // left : black  1   -> right : black 
            String otherSide = side == "right" ? "left" : "right";
            String expectedSock = otherSide + " : " + color;
            
            if (cache.containsKey(expectedSock)){
                Deque<Integer> q = cache.get(expectedSock);
                int expectedSockIndes = q.pollFirst();
                ans.add(new int[]{index, expectedSockIndes});
                if (q.isEmpty()) {
                    cache.remove(expectedSock);
                }
            } else {
                cache.put(curSock, new ArrayDeque<>());
                cache.get(curSock).addLast(index);
            }
        }

        printSocks(ans);
        return ans;
    }


    private static void printSocks(List<int[]> ans){
        for (int[] indexs : ans){
            System.out.println(String.valueOf(indexs[0]) + " , " + String.valueOf(indexs[1]));
        }
    }

    // static Map<String, ArrayDeque<Integer>> cache = new HashMap<>();
    // static Map<String, List<String>> swapCache = new HashMap<>();
    private static List<int[]> findPairsFollow(String[][] inputs, String[][] rules){
        List<int[]> ans = new ArrayList<>();
        Map<String, ArrayDeque<Integer>> cache = new HashMap<>();
        Map<String, List<String>> swapCache = new HashMap<>();
        for (String[] rule : rules){
            swapCache.putIfAbsent(rule[0], new ArrayList<>());
            swapCache.get(rule[0]).add(rule[1]);
            swapCache.putIfAbsent(rule[1], new ArrayList<>());
            swapCache.get(rule[1]).add(rule[0]);
        }

        for (String[] inp : inputs){
            int index = Integer.valueOf(inp[0]);
            String side = inp[1];
            String color = inp[2];
            String curSock = side + " : " + color;      // left : black  1   -> right : black 
            String otherSide = side == "right" ? "left" : "right";
            String expectedSock = otherSide + " : " + color;
            
            if (cache.containsKey(expectedSock)){
                ans = updateSockCache(cache, expectedSock, ans, index);
            } else {
                List<String> swapColors = swapCache.getOrDefault(color, new ArrayList<>());
                boolean match = false;
                for (String newColor : swapColors){
                    String swapSock = otherSide + " : " + newColor;
                    if (cache.containsKey(swapSock)) {
                        ans = updateSockCache(cache, swapSock, ans, index);
                        match = true;
                    }
                }
                if (!match) {
                    cache.put(curSock, new ArrayDeque<>());
                    cache.get(curSock).addLast(index);
                }
            }
        }

        printSocks(ans);
        return ans;
    }

    private static List<int[]> updateSockCache(Map<String, ArrayDeque<Integer>> cache, String expectedSock, List<int[]> ans, int index){
        Deque<Integer> q = cache.get(expectedSock);
        int expectedSockIndes = q.pollFirst();
        ans.add(new int[]{index, expectedSockIndes});
        if (q.isEmpty()) {
            cache.remove(expectedSock);
        }

        return ans;
    }
}
