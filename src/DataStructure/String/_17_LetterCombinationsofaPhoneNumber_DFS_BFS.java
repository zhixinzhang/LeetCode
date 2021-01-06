package DataStructure.String;

import java.util.*;

/**
 * @Author: Luke(New Man) Zhang
 * @Date: 2021/1/5 20:30
 * Link :
 * Description:
 */
public class _17_LetterCombinationsofaPhoneNumber_DFS_BFS {

    static Map<Character, String> cache = new HashMap<>();
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        cache.put('2', "abc");
        cache.put('3', "def");
        cache.put('4', "ghi");
        cache.put('5', "jkl");
        cache.put('6', "mno");
        cache.put('7', "pqrs");
        cache.put('8', "tuv");
        cache.put('9', "wxyz");

        // dfs
        dfs(digits, "", 0, ans);

        return ans;
    }

    private static void dfs(String digits, String cur, int index, List<String> ans){
        if (index == digits.length()) {   // at the end of string
            ans.add(cur);
            return;
        }

        String options = cache.get(digits.charAt(index));
        for (int i = 0; i < options.length(); i++){
            char c = options.charAt(i);
            String nextS = cur + c;
            dfs(digits, nextS, index + 1, ans);
        }
    }

    public List<String> letterCombinations_BFS(String digits) {
        if(digits == null || digits.length() == 0)
            return new ArrayList<>();
        List<String> res = new ArrayList<>();
        res.add("");
        String[] cache = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i = 0; i < digits.length(); i++){
            int index = digits.charAt(i) - '0';
            String s = cache[index];
            List<String> tmp = new ArrayList<>();

            for(int j = 0; j < s.length(); j++){
                for(int k = 0; k < res.size(); k++){
                    tmp.add(res.get(k) + s.charAt(j));
                }
            }
            res = tmp;
        }

        return res;
    }



    public static void main(String[] args){
        letterCombinations("345");
    }
}
