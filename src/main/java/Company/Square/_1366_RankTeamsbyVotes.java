package Company.Square;
import java.util.*;

// https://leetcode.com/problems/rank-teams-by-votes/solutions/524853/java-o-26n-26-2-log26-sort-by-high-rank-vote-to-low-rank-vote/

public class _1366_RankTeamsbyVotes {
    public String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();
        int l = votes[0].length();
        for(String vote : votes){
          for(int i = 0; i < l; i++){
            char c = vote.charAt(i);
            map.putIfAbsent(c, new int[l]);
            map.get(c)[i]++;
          }
        }
        
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a,b) -> {
          for(int i = 0; i < l; i++){
            if(map.get(a)[i] != map.get(b)[i]){
              return map.get(b)[i] - map.get(a)[i];
            }
          }
          return a - b;
        });
        
        StringBuilder sb = new StringBuilder();
        for(char c : list){
          sb.append(c);
        }
        return sb.toString();
      }
}
