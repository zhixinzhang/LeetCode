package Company.Amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/12/19
 * Time: 4:49 PM
 * Description:
 * https://www.1point3acres.com/bbs/thread-522015-1-1.html
 *
 * follow up 无序的怎么办 ？ 排序
 * 无序就是 leetcode 140
 */


public class findAllCombination_BackTrack {
    public static void main(String[] args){
        String[] words = new String[]{"superhighway", "sup", "er", "super","high", "way", "highway"};
        find(words, "superhighway");
    }
    static List<List<String>> ans = new ArrayList<>();
    public static List<List<String>> find(String[] words, String target){
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++){
            backtrack(i, words, target, new ArrayList<String>(), set,"");
        }
        return ans;
    }
    public static void backtrack(int index, String[] words, String target, List<String> res, HashSet<String> vis, String path){
        if (target.length() == 0){
            if (vis.add(path))
                ans.add(res);
            return;
        }
        for (int i = index; i < words.length; i++){
            if (target.indexOf(words[i]) == 0){
                res.add(words[i]);
                backtrack(i+1, words, target.substring(words[i].length()), new ArrayList<>(res), vis, path + words[i] + "*");
                res.remove(res.size()-1);
            }
        }
    }
}
