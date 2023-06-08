package Company.Square.OOP.Sock;

import java.util.*;

// https://www.1point3acres.com/bbs/thread-963175-1-1.html
/**
 * Match left and right socks of the same color.
Given an array like [(1, left, red), (2, right, red), (3, left, orange), ...], you would pair [0, 1] since they match color and form a left , right combination.
Follow up:
You are given new color matching rules. For example, if you are given ("blue", "black"), ("black", "red"), then socks (3, left, blue) and (4, right, black) can be paired, but ( 3, right, blue) and (4, left, red) cannot (no transitivity).
 * 
*/
public class _SocksColor_ {
    public static void main(String[] args) {
        String[][] inputs = new String[][]{
            {"1", "left", "red"},
            {"2", "right", "red"},
            {"3", "left", "orange"},
            {"4", "right", "orange"},
            {"5", "left", "red"}
        };

        findPairs(inputs);

        //("blue", "black"), ("black", "red"),
        String[][] inputs2 = new String[][]{
            {"1", "left", "blue"},
            {"2", "right", "black"},
            {"3", "left", "black"},
            {"4", "right", "red"},
            {"5", "left", "blue"}
        };
        String[][] rules = new String[][]{{"blue", "black"}, {"black", "red"}};
        findPairsFollow(inputs2, rules);
    }

    private static void findPairs(String[][] inputs){
        if (inputs == null || inputs.length == 0) {
            try {
                Exception ex = new IllegalArgumentException("empty inputs");
                throw ex;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Map<String, List<List<String>>> cache = new HashMap<>();
        // red -> {{1, 5}, {2}}  -> {1, 2} {5, 2}
        for (String[] sock : inputs){
            String index = sock[0];
            String p = sock[1];
            String color = sock[2];
            if ("left".equals(p)) {
                if (!cache.containsKey(color)){
                    List<List<String>> pairs = new ArrayList<>();
                    pairs.add(new ArrayList<>());
                    pairs.add(new ArrayList<>());
                    cache.put(color, pairs);
                }
                cache.get(color).get(0).add(index);
            } else if ("right".equals(p)) {
                if (!cache.containsKey(color)){
                    List<List<String>> pairs = new ArrayList<>();
                    pairs.add(new ArrayList<>());
                    pairs.add(new ArrayList<>());
                    cache.put(color, pairs);
                }
                cache.get(color).get(1).add(index);
            }
        }


        for (Map.Entry<String, List<List<String>>> entry : cache.entrySet()){
            System.out.println("currenty pairing color : " + entry.getKey());
            List<List<String>> pairs = entry.getValue();
            for (String l : pairs.get(0)){
                for (String r : pairs.get(1)){
                    System.out.println("pair : [ " + l + " , " + r + " ]");
                }
            }
        }
    }

    private static void findPairsFollow(String[][] inputs, String[][] rules){
        Map<String, String> newRules = new HashMap<>();
        for (String[] rule : rules){
            newRules.putIfAbsent(rule[0], rule[1]);
            newRules.putIfAbsent(rule[1], rule[0]);
        }

        Map<String, List<List<String>>> cache = new HashMap<>();
        // red -> {{1, 5}, {2}}  -> {1, 2} {5, 2}
        for (String[] sock : inputs){
            String index = sock[0];
            String p = sock[1];
            String color = sock[2];
            if (p == "left") {
                if (!cache.containsKey(color)){
                    List<List<String>> pairs = new ArrayList<>();
                    pairs.add(new ArrayList<>());
                    pairs.add(new ArrayList<>());
                    cache.put(color, pairs);
                }
                cache.get(color).get(0).add(index);
            } else if (p == "right") {
                if (!cache.containsKey(color)){
                    List<List<String>> pairs = new ArrayList<>();
                    pairs.add(new ArrayList<>());
                    pairs.add(new ArrayList<>());
                    cache.put(color, pairs);
                }
                cache.get(color).get(1).add(index);
            }
        }

        Set<String> paired = new HashSet<>();
        for (Map.Entry<String, List<List<String>>> entry : cache.entrySet()){
            System.out.println("currenty pairing color : " + entry.getKey());
            if (paired.contains(entry.getKey())) {
                System.out.println("currenty pairing color : " + entry.getKey() + "  it's already paired");
                continue;
            }
            List<List<String>> pairs = entry.getValue();
            // pair same color
            for (String l : pairs.get(0)){
                for (String r : pairs.get(1)){
                    System.out.println("pair : [ " + l + " , " + r + " ]");
                }
            }
            
            String rule = newRules.get(entry.getKey()); // ("blue", "black"), ("black", "red")
            List<List<String>> newPairs = new ArrayList<>();
            newPairs.add(cache.get(rule).get(0));
            newPairs.add(pairs.get(1));
            // pair same color
            for (String l : newPairs.get(0)){
                for (String r : newPairs.get(1)){
                    System.out.println("pair : [ " + l + " , " + r + " ]");
                }
            }

            newPairs = new ArrayList<>();
            newPairs.add(cache.get(rule).get(1));
            newPairs.add(pairs.get(0));
            for (String l : newPairs.get(0)){
                for (String r : newPairs.get(1)){
                    System.out.println("pair : [ " + l + " , " + r + " ]");
                }
            }

            paired.add(entry.getKey());
            paired.add(rule);
        }
    }
}
