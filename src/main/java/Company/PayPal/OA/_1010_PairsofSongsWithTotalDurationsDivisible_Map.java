package Company.PayPal.OA;

import java.util.HashMap;
import java.util.List;

/*** Two sum  */
public class _1010_PairsofSongsWithTotalDurationsDivisible_Map {
    public long playList(List<Integer> songs) {
        int remainders[] = new int[60];
        long count = 0;
        for (int t: songs) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }

    public int numPairsDivisibleBy60(int[] time) {
        int count =0;
        for(int i=0;i<time.length;i++){
            if(time[i]>=60) time[i]%=60;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<time.length;i++){
            if(time[i]==0 && map.containsKey(time[i])){
                count+=map.get(time[i]);
            }
            if(map.containsKey(60-time[i])){
                count+=map.get(60-time[i]);
            }
            map.put(time[i],map.getOrDefault(time[i],0)+1);
        }
        return count;
    }
}
