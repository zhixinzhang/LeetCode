package company.Apple;

import java.util.*;

// used hashmap<stone set<distance>>
// the value is how we cost distance to arrive stone
public class _403_FrogJump_DFS_HashMap {
    public static void main(String[] args){
        int[] stones = new int[]{0,1,3,5,6,8,12,17};
        canCross_HashMap(stones);
    }
    public static boolean canCross_HashMap(int[] stones) {
        if(stones == null || stones.length == 0) return false;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int pos: stones) {
            map.put(pos, new HashSet<Integer>());
        }
        int[] adjust = new int[]{-1, 0, 1};
        map.get(0).add(0);
        for(int pos: stones) {
            Set<Integer> set = map.get(pos);
            for(Integer step: set) {
                for(int add: adjust) {
                    int nextstep = step + add;
                    int nextstone = pos + nextstep;
                    if(nextstep > 0 && map.containsKey(nextstone))
                        map.get(nextstone).add(nextstep);
                }
            }
        }
        if(map.get(stones[stones.length - 1]).size() != 0) return true;
        return false;
    }


  public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {return false;}
        int n = stones.length;
        if (n == 1) {return true;}
        if (stones[1] != 1) {return false;}
        if (n == 2) {return true;}
        int last = stones[n - 1];
        HashSet<Integer> hs = new HashSet();
        for (int i = 0; i < n; i++) {
            if (i > 3 && stones[i] > stones[i - 1] * 2) {return false;} // The two stones are too far away. 
            hs.add(stones[i]);
        }
        return canReach(hs, last, 1, 1);
    }
  private boolean canReach(HashSet<Integer> hs, int last, int pos, int jump) {
        if (pos + jump - 1 == last || pos + jump == last || pos + jump + 1 == last) {
            return true;
        }
        if (hs.contains(pos + jump + 1)) {
            if (canReach(hs, last, pos + jump + 1, jump + 1)) {return true;}
        }
        if (hs.contains(pos + jump)) {
            if (canReach(hs, last, pos + jump, jump)) {return true;}
        }
        if (jump > 1 && hs.contains(pos + jump - 1)) {
            if (canReach(hs, last, pos + jump - 1, jump - 1)) {return true;}
        }
        return false;
    }
}