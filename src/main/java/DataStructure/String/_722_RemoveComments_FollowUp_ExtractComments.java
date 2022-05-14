package DataStructure.String;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description: 写一个函数 返回string 里面的comments
 *
 * Key Point:
 */



public class _722_RemoveComments_FollowUp_ExtractComments {
    public static List<String> removeComments(String[] source) {
        if (source == null || source.length == 0) {
            return new ArrayList<>();
        }

        boolean isComment = false;
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        for (String s : source){
            char[] curChar = s.toCharArray();
            for (int i = 0; i < curChar.length; i++){
                char c = curChar[i];

                if (isComment) {
                    if (c == '*' && i < curChar.length - 1 && curChar[i + 1] == '/'){
                        isComment = false;
                        i++;            //skip '/' on next iteration of i
                    } else if (c != '/' && c != '*') {
                        sb.append(c);
                    }
                } else {
                    if (c == '/' && i < curChar.length - 1 && curChar[i + 1] == '/') {
                        i++;
                        build(i, sb, curChar, ans);
                        sb = new StringBuilder();
                        break;
                    } else if (c == '/' && i < curChar.length - 1 && curChar[i + 1] == '*') {
                        isComment = true;
                        i++; //skip '*' on next iteration of i
                    }
                }
            }

            if (!isComment && sb.length() > 0) {
                ans.add(sb.toString());
                sb = new StringBuilder();   //reset for next line of source code
            }
        }

        return ans;
    }

    private static void build(int i, StringBuilder sb, char[] curChar, List<String> ans){
        for (; i < curChar.length; i++){
            if (curChar[i] != '/' && curChar[i] != '*') {
                sb.append(curChar[i]);
            }
        }
        ans.add(sb.toString());
    }

    public static void main(String[] args){
        String[] source = new String[]{
                "// this is a test",
                "I love databricks // truly",
                "I really like /** coding */",
                "// I like apple  /** or not*/",
                "/***ccccc*/"
        };

        removeComments(source);
    }
}
