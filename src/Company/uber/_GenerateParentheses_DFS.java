package Company.uber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/9/15.
 */
public class _GenerateParentheses_DFS {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        decisionTree(list, "", 0, 0, n);
        return list;
    }

    void decisionTree(List<String> list, String s, int open, int close, int n) {
        if(s.length() == 2 * n) {
            list.add(s);
            return;
        }
        if(open < n) {
            decisionTree(list, s + "(", open + 1, close, n);
        }
        if(open > close) {
            decisionTree(list, s + ")", open, close + 1, n);
        }
    }
}
