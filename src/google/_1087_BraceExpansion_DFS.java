package google;

//https://leetcode.com/problems/brace-expansion/

import java.util.ArrayList;
import java.util.List;

public class _1087_BraceExpansion_DFS {
    static List<String> result = new ArrayList<>();

    public static void main(String[] args){
        expand("{a,b}c{d,e}f");
    }

    public static String[] expand(String S) {
        if (S == null || S.length() == 0)
            return new String[0];
        StringBuilder sb = new StringBuilder();
        helper(S.toCharArray(), sb, 0);
        String[] res = new String[result.size()];
        for (int i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }
        return res;
    }

    public static void helper(char[] S, StringBuilder sb, int index){
        // edge case
        if(index < S.length){
            if (S[index] == '{')
                helper(S, sb, index+1);
            else {
                int l = index, r = S.length;
                for (int i = index; i < S.length; i++){
                    if (S[i] == '}'){
                        r = i;
                        break;
                    }
                }
                while (l <= r){
                    sb.append(S[l]);
                    helper(S, sb, r+1);
                    sb.deleteCharAt(sb.length()-1);
                }

            }
        }else{
            result.add(sb.toString());
        }
    }
}
