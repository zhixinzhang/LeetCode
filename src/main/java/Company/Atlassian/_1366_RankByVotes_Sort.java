package Company.Atlassian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Vote {
    List<String> candidates;
    public Vote(List<String> candidates){
        this.candidates = candidates;
    }
}

class NewVote {
    List<String> candidates;
    int timeStamp;
    public NewVote(List<String> candidates, int ts){
        this.candidates = candidates;
        this.timeStamp = ts;
    }
}



public class _1366_RankByVotes_Sort {
    static int[] score = new int[]{3, 2, 1};
    public static void main(String[] args) {
        Vote v1 = new Vote(Arrays.asList("A", "B", "C"));
        Vote v2 = new Vote(Arrays.asList("B", "C", "A"));
        Vote v3 = new Vote(Arrays.asList("C", "B", "A"));
        Vote v4 = new Vote(Arrays.asList("H", "A", "M"));
        List<Vote> votes = Arrays.asList(v1, v2, v3, v4);
        calculateVotes(votes);


        System.out.println("new vote : ");

        NewVote nv1 = new NewVote(Arrays.asList("A", "B", "C"), 0); 
        NewVote nv2 = new NewVote(Arrays.asList("B", "C", "A"), 1);
        NewVote nv3 = new NewVote(Arrays.asList("C", "B", "A"), 2);
        // NewVote nv4 = new NewVote(Arrays.asList("A", "B", "C"), 3);

        NewVote nv4 = new NewVote(Arrays.asList("H", "A", "M"), 3);
        // B,7 last voted time 2
        // A,7 last voted time 3
        // C,6 last voted time 2
        List<NewVote> newVotes = Arrays.asList(nv1, nv2, nv3, nv4);
        calculateNewVotes(newVotes);
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
                if (e1.getValue().equals(e2.getValue())) {
                    return e2.getValue().compareTo(e1.getValue());
                } else {
                    return e1.getKey().compareTo(e2.getKey());
                }
                
            }
        });

        for (Map.Entry<String, Integer> entry : sortMap){
            ans.add(entry.getKey());
            System.out.println(entry.getKey() + "," + entry.getValue());
        }

        // PQ Solution
        PriorityQueue<Map.Entry<String, Integer>> minPQ = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
                if (e1.getValue().equals(e2.getValue())) {
                    return e2.getValue().compareTo(e1.getValue());
                } else {
                    return e1.getKey().compareTo(e2.getKey());
                }
            }
        });
        minPQ.addAll(candiMap.entrySet());
        while (!minPQ.isEmpty()){
            Map.Entry<String, Integer> e1 = minPQ.poll();
            System.out.println("minPQ : " + e1.getKey() + " " + e1.getValue());
        }
        int a = 0;
    }

    private static void calculateNewVotes(List<NewVote> votes){
        List<String> ans = new ArrayList<>();
        Map<String, int[]> candiMap = new HashMap<>();  // candidatesname , int[] int[0] score, int[1] last voted timestamp
         for (NewVote vote : votes){
            List<String> vs = vote.candidates;
            for (int i = 0; i < vs.size(); i++){
                String cand = vs.get(i);
                int[] info = candiMap.getOrDefault(cand, new int[]{0, 0});
                info[0] += score[i];
                info[1] = Math.max(vote.timeStamp, info[1]);
                candiMap.put(cand, info);
            }
        }
        List<Map.Entry<String, int[]>> sortMap = new ArrayList<>();
        sortMap.addAll(candiMap.entrySet());

        Collections.sort(sortMap, new Comparator<Map.Entry<String, int[]>>() {
            @Override
            public int compare(Map.Entry<String, int[]> e1, Map.Entry<String, int[]> e2) {
                if (e1.getValue()[0] != e2.getValue()[0]) {
                    return e2.getValue()[0] - e1.getValue()[0];
                } else {
                    return e1.getValue()[1] - e2.getValue()[1];
                }
            }
        });

        for (Map.Entry<String, int[]> entry : sortMap){
            ans.add(entry.getKey());
            System.out.println(entry.getKey() + "," + entry.getValue()[0] + " last voted time " + entry.getValue()[1]);
        }
    }

}
