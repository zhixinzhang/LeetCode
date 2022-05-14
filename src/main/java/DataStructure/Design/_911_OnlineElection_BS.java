package DataStructure.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/6/19
 * Time: 5:07 PM
 * Description:
 */


public class _911_OnlineElection_BS {
    class Vote{
        int person, time;
        Vote(int p, int t){
            this.person = p;
            this.time = t;
        }
    }
    List<Vote> A;
    public _911_OnlineElection_BS(int[] persons, int[] times) {
        A = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        int leader = -1;  // current leader
        int m = 0;  // current number of votes for leader
        for(int i = 0; i < persons.length; i++){
            int p = persons[i], t = times[i];
            int c = count.getOrDefault(p,0) + 1;
            count.put(p, c);

            if(c >= m){
                if(p != leader){
                    leader = p;
                    A.add(new Vote(leader, t));
                }
                if (c > m) m = c;
            }
        }
    }

    public int q(int t) {
        int lo = 1, hi = A.size();
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
//            int mid = (lo + hi) / 2;
            if(A.get(mid).time <= t)
                lo = mid + 1;
            else
                hi = mid;
        }
        return A.get(lo - 1).person;
    }
}
