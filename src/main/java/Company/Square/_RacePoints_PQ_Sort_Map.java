package Company.Square;
import java.util.*;

public class _RacePoints_PQ_Sort_Map {
    public static void main(String[] args) {
        String[][] races = new String[][]{{"Dan,3", "Sam,2", "Ron,1"}, {"Dan,1", "Sam,2", "Ron,3"}, {"Dan,1", "Sam,3", "Ron,2"}};
 
        scoreRaces(races);
     }
    
    public static void scoreRaces(String [][]races){
        Queue<String> pq = new PriorityQueue<>( (x, y) -> (int) x.charAt(x.length() - 1) - (int) y.charAt(y.length() - 1));
        Map<String, Integer> map = new HashMap();
        Queue<String> scoreBoard = new PriorityQueue<String>( (x, y) -> map.get(y) - map.get(x));
        int raceNum = 1;
        for(String [] race: races){
            for(String racer: race){
                pq.offer(racer);
            }
            int highestScore=15;
            while(!pq.isEmpty()){
                String racer = pq.poll();
                String key = racer.substring(0,racer.indexOf(','));
                map.put(key, map.getOrDefault(key,0)+highestScore);
                scoreBoard.offer(key);
                highestScore-=5;
            }
            System.out.println("Race "+raceNum);
            StringBuilder output = new StringBuilder();
            while(!scoreBoard.isEmpty()){
                String key = scoreBoard.poll();
                Integer score = map.get(key);
                output.append(key).append(":").append(score).append(", ");
            }
            System.out.println(output.toString()+"\n");
        }
    }
}
