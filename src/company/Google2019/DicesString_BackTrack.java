package company.Google2019;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 2/19/19
 * Time: 4:24 PM
 * Description:
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=482917&page=1
 * 2. 一个是骰子每个面是一个字母（可能为空），给N个骰子和长度<=N的string，判断用这些骰子能不能组成string，给每个骰子编上号的话组成string的骰子顺序是啥？follow up是如果给个字典，骰子上的字母如果在字典里可以用字典的value代替怎么做。
 * Eg： 骰子是{0: ['A','B','C','H','E', ''], 1:['C','W','O','P','I','U'], 2:['E','R','W','X','A','I']}, String='HWO'，输出就是[0,2,1]
 * Follow up就是如果String='HVW'，同时给个字典比如{'U':'V'}表示UV可以互换，如果还是可以组成string，改变字母次数最少的骰子组合是什么
 *
 *
 * 1. 经典 backtrack  什么条件返回 每次clean hashset list。。。。
 * 2. follow up  全局最优解，找到所有可能
 */


public class DicesString_BackTrack {
    static HashMap<Integer, List<String>> hm = new HashMap<>();
    static List<Integer> path = new ArrayList<>();
    static Set<Integer> visited = new HashSet<>();
    static HashMap<String, String> mapping = new HashMap<>();
    static String s = "HWO";
    public static void main(String[] args){
        List<String[]> dices = new ArrayList<>();
        String[] d1 = new String[]{"A","B","C","H","E",""};
        String[] d2 = new String[]{"C","W","O","P","I","U"};
        String[] d3 = new String[]{"E","R","W","X","A","I"};
        dices.add(d1);
        dices.add(d2);
        dices.add(d3);
        for (int i = 0; i < dices.size(); i++){
            String[] cur = dices.get(i);
            List<String> val = Arrays.asList(cur);
            hm.putIfAbsent(i, val);
        }
        findSeq(0);
        System.out.print(path);
        mapping.putIfAbsent("U","V");
        findMinimalSeq(0);
    }

    private static List<Integer> findSeq(int index){
        if(index == s.length())
            return path;
        char c = s.charAt(index);
        String curC = String.valueOf(c);
        for (int i : hm.keySet()){
            if (visited.contains(i))
                continue;
            List<String> values = hm.get(i);
            for (String v : values){
                if (v.equals(curC)){
                    path.add(i);
                    visited.add(i);
                    List<Integer> res = findSeq(index+1);
                    if (res.size() == s.length()){
                        return res;
                    }
                    path.remove(path.size()-1);
                    visited.remove(i);
                }
            }
        }
        return path;
    }


    private static List<Integer> findMinimalSeq(int index){
        // return case
        if (index >= s.length())
            return path;
        String curC = String.valueOf(s.charAt(index));
        for (int i : hm.keySet()){
            if (visited.contains(i))
                continue;
            List<String> values = hm.get(i);
            for (String v : values){
                if (v.equals(curC)){

                }
            }
        }
        return path;
    }

}
