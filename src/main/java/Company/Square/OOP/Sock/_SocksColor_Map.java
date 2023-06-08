package Company.Square.OOP.Sock;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/discuss/interview-question/1555905/Square-or-Sock-Pairs
// https://www.1point3acres.com/bbs/thread-963175-1-1.html
// 一个袜子 只返回一个配对就行

public class _SocksColor_Map {
    static class Sock{
        String color;
        String side;
        int index;
        public Sock(int index, String side, String color){
            this.index = index;
            this.color = color;
            this.side = side;
        }
    }
    public static void main(String[] args) {
        List<Sock> socks = Arrays.asList(
            new Sock(1, "left", "black"),
            new Sock(2, "right", "pink"),
            new Sock(3, "left", "pink"),
            new Sock(4, "right", "black"),
            new Sock(5, "right", "black"),
            new Sock(6, "left", "orange"),
            new Sock(7, "left", "white")
        );

        List<Sock> socks2 = Arrays.asList(
            new Sock(1, "left", "white"),
            new Sock(2, "right", "white"),
            new Sock(3, "left", "pink"),
            new Sock(4, "right", "black"),
            new Sock(5, "right", "pink"),
            new Sock(6, "right", "yellow"),
            new Sock(7, "left", "orange")
        );
        
        findPairs(socks);      // [4, 1]  [3, 2]
        findPairs(socks);      // [2, 1]  [3, 5]

        String[][] rules = new String[][]{{"orange", "black"}, {"black", "red"}};
        System.out.println("follow up");
        findPairsFollow(socks2, rules);
    }

    private static List<int[]> findPairs(List<Sock> socks){
        List<int[]> ans = new ArrayList<>();
        Map<String, ArrayDeque<Integer>> cache = new HashMap<>();
        for (Sock sock : socks){
            int index = sock.index;
            String side = sock.side;
            String color = sock.color;
            String curSock = side + " : " + color;      // left : black  1   -> right : black 
            String otherSide = side == "right" ? "left" : "right";
            String expectedSock = otherSide + " : " + color;
            
            if (cache.containsKey(expectedSock)){
                ans = updateSockCache(cache, expectedSock, ans, index);
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

    private static List<int[]> findPairsFollow(List<Sock> socks, String[][] rules){
        List<int[]> ans = new ArrayList<>();
        Map<String, ArrayDeque<Integer>> cache = new HashMap<>();
        Map<String, List<String>> swapCache = new HashMap<>();
        for (String[] rule : rules){
            swapCache.putIfAbsent(rule[0], new ArrayList<>());
            swapCache.get(rule[0]).add(rule[1]);
            swapCache.putIfAbsent(rule[1], new ArrayList<>());
            swapCache.get(rule[1]).add(rule[0]);
        }

        for (Sock sock : socks){
            int index = sock.index;
            String side = sock.side;
            String color = sock.color;
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
