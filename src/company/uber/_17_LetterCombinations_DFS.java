package company.uber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/9/19.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=335628&ctid=201324
 *LC 17 变种
 * 有n个list，假设平均长度是m，每个必须出一个元素，要求输出所有的可能的组合. 1point3acres
 例如输入{a,b}, {c,d}, {e,f}
 则要输出{a,c,e}, {a,c,f}, {a,d,e}, {a,d,f},{b,c,e},{b,c,f},{b,d,e},{b,d,f}
 */
//time O(m ^ n)
public class _17_LetterCombinations_DFS {
    static List<String> res = new ArrayList<>();

    public static void main(String[] args){
        List<List<String>> lists = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("a");l1.add("b");
        lists.add(l1);
        List<String> l2 = new ArrayList<>();
        l2.add("c");l2.add("d");
        lists.add(l2);
        List<String> l3 = new ArrayList<>();
        l3.add("e");l3.add("f");
        lists.add(l3);
        StringBuilder sb = new StringBuilder();
        combin(lists, 0, sb);
        System.out.println(res);
    }
    public static void combin(List<List<String>> lists, int idxL,StringBuilder sb){
        if (sb.length() == lists.size()){
            StringBuilder print = new StringBuilder(sb);
            res.add(print.toString());
            return;
        }
        for (int i = 0; i < lists.get(idxL).size(); i++){
            String cur = lists.get(idxL).get(i);
            sb.append(cur);
            combin(lists,idxL+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
