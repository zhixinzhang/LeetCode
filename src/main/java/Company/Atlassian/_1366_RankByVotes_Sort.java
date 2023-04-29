package Company.Atlassian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Vote {
    List<String> candidates;
    
    public Vote(List<String> candidates){
        this.candidates = candidates;
    }
}

public class _1366_RankByVotes_Sort {
    static int[] score = new int[]{3, 2, 1};
    public static void main(String[] args) {
        Vote v1 = new Vote(Arrays.asList("A", "B", "C"));
        Vote v2 = new Vote(Arrays.asList("B", "C", "A"));
        Vote v3 = new Vote(Arrays.asList("A", "B", "C"));
        Vote v4 = new Vote(Arrays.asList("A", "B", "C"));
        List<Vote> votes = Arrays.asList(v1, v2, v3, v4);
        calculateVotes(votes);
    }

    private static void calculateVotes(List<Vote> votes){
        List<String> ans = new ArrayList<>();
        Map<String, Integer> candiMap = new HashMap<>();
        for (Vote vote : votes){
            List<String> vs = vote.candidates;
            for (int i = 0; i < vs.size(); i++){
                String cand = vs.get(i);
                int preTotalScore = candiMap.getOrDefault(cand, 0);
                preTotalScore += score[i];
                candiMap.put(cand, preTotalScore);
            }
        }
        List<Map.Entry<String, Integer>> sortMap = new ArrayList<>();
        sortMap.addAll(candiMap.entrySet());

        Collections.sort(sortMap, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : sortMap){
            ans.add(entry.getKey());
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }

}
