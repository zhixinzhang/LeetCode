package Company.Thumbtack;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 6/7/2021 2:01 AM
 * <p>
 * Source Link:
 * <p> https://www.1point3acres.com/bbs/thread-557892-1-1.html
 * Description:
 * <p> 给出一个input: {"browser": "chrome", "device_category": "mobile"}
 * Expected output: chrom, mobile, chrome and mobile
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 *
 * Time complexity: \mathcal{O}(N \times 2^N)O(N×2
 * N
 *  ) to generate all subsets and then copy them into output list.
 */

public class _UserGroups_Map_SubSet {
    public static void main(String[] args){
        Map<String, List<String>> map = new HashMap<>();
        map.put("os", Arrays.asList("mac", "linux"));
        map.put("devices", Arrays.asList("chrome", "firefox"));
        map.put("version", Arrays.asList("1.2", "1.12.3"));


        helper(map);
    }

    private static void helper(Map<String, List<String>> map){
        List<String> parameters = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            parameters.add(entry.getKey());
        }

        List<String> ans = new ArrayList<>();
        recursion(ans, parameters, 0, new ArrayList<String>());
        for (String s : ans){
            System.out.println(s);
        }
    }

    private static void recursion(List<String> ans, List<String> parameters, int index, List<String> curS){
        ans.add(new String(curS.toString()));
        for (int i = index; i < parameters.size(); i++) {
            curS.add(parameters.get(i));
            recursion(ans, parameters, i + 1, curS);
            curS.remove(curS.size() - 1);
        }
    }
}
