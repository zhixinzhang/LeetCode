package company.Apple;

import java.util.*;

/**
 * Created by zhang on 2018/2/18.
 */
public class _17_LetterCombinationsofaPhoneNumber_backtrack {
    static String[] s  = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static List<String> res = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        digits = digits.replace("1","").replace("*","").replace("#","");
        String curS = "";
        helper(digits,0,curS);
        return res;
    }
    private static List<String> helper(String digits,int index,String curS){
        // return case
        if (index == digits.length()){
            res.add(curS);
            return res;
        }

        int c = Integer.valueOf(digits.charAt(index))-48;
        String curVal = s[c];
        for (int i = 0; i < curVal.length();i++){
            String cur = curS + String.valueOf(curVal.charAt(i));
            helper(digits,index+1,cur);
        }
        return res;
    }
    public static void main(String[] args){
        letterCombinations("123*4");
    }
}
