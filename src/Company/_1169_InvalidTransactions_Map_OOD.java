package Company;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/20/2021 9:55 PM
 * <p>
 * Description: https://leetcode.com/problems/invalid-transactions/discuss/759550/Java-good-OO-design-95-fast
 *
 * Similar task :
 *
 * Key Point:
 *
 */

public class _1169_InvalidTransactions_Map_OOD {

    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>();
        if (transactions == null || transactions.length == 0) {
            return ans;
        }

        // O(n) for loop, n is the lenght of transactions
        Map<String, List<String[]>> map = new HashMap<>();
        for (String tran : transactions){
            String[] splittedTran = tran.split(",");
            map.putIfAbsent(splittedTran[0], new ArrayList<>());
            map.get(splittedTran[0]).add(splittedTran);
        }

        for (String tran : transactions){
            String[] trans = tran.split(",");
            if (Integer.parseInt(trans[2]) > 1000) {
                ans.add(tran);
                continue;
            }

            List<String[]> transList = map.get(trans[0]);
            for (String[] s : transList){
                if(Math.abs(Integer.parseInt(trans[1]) - Integer.parseInt(s[1])) <= 60 && !trans[3].equals(s[3])) {
                    ans.add(tran);
                    break;
                }
            }
        }

        return ans;
    }
}
