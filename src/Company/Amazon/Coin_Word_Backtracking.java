package Company.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/13/19
 * Time: 12:06 PM
 * Description:
 *
 * https://www.1point3acres.com/bbs/thread-521306-1-1.html
 */


public class Coin_Word_Backtracking {
    public boolean find(String[] coins, String word){
        HashMap<String, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < coins.length; i++){
            String coin = coins[i];
            String[] co = coin.split(",");
            for (String c : co){
                hm.putIfAbsent(c, new ArrayList<>());
                hm.get(c).add(i);
            }
        }

        return backtrack(0, word.toCharArray(), hm, new HashSet<>());

    }
    public boolean backtrack(int idx, char[] word, HashMap<String, List<Integer>> hm, HashSet<Integer> set){
        if (idx >= word.length)
            return true;
        String cur = String.valueOf(word[idx]);
        for (int i : hm.get(cur)){
            if (set.add(i)){
                if (backtrack(idx + 1, word, hm, set))
                    return true;
                else
                    set.remove(i);
            }
        }
        return false;
    }
}
