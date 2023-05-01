package Company.Atlassian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class _1366_RankByVotesSelfDefineScore_Sort {

    static class Vote {
        int score;
        String name;
        String type; 
    
        public Vote(String name, int score, String type){
            this.name = name;
            this.score = score;
            this.type = type;
        }
    }
    public static void main(String[] args) {
        Vote v1 = new Vote("aa", 10, "school");
        Vote v2 = new Vote("bb", 5, null);
        Vote v3 = new Vote("cc", 20, "work");
        Vote v4 = new Vote("dd", 30, "work");
        Vote v5 = new Vote("ee", 50, "play");

        List<Vote> votes = Arrays.asList(v1, v2, v3, v4, v5);
        calculateVotes(votes);
    }

    private static void calculateVotes(List<Vote> votes){
        if (votes == null || votes.size() == 0) {
            return;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (Vote v : votes){
            if (v.type != null) {
                map.putIfAbsent(v.type, 0);
                int score = map.get(v.type) + v.score;
                map.put(v.type, score);
            }
        }

        List<Map.Entry<String, Integer>> sortedMap = new ArrayList<>();
        sortedMap.addAll(map.entrySet());

        // O(N * Log N)
        Collections.sort(sortedMap, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
                if (e1.getValue() == e2.getValue()) {
                    return e1.getKey().compareTo(e2.getKey());
                } else {
                    return e2.getValue() - e1.getValue();
                }
            }
        });

        for (Map.Entry<String, Integer> ent : sortedMap){
            System.out.println(ent.getKey() + " , " + ent.getValue());
        }
    }
}
