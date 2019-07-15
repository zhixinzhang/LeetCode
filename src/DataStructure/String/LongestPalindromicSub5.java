package DataStructure.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2017/2/1.
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 */
//最长回文字串  我的不对
    /***/
public class LongestPalindromicSub5 {
//    public static String longestPalindrome(String s) {
//        if (s.length() == 1 || s == "") return s;
////        String result = s;
//        int[] pointNum = {0, 0};
//        char[] sChar = s.toCharArray();
//        int lastPoint = 0;
//        List<String> str = new DataStructure.ArrayList<>();
//        for (int i = 0; i < sChar.length; i++) {
//            String result = s;
//            pointNum[0] = i;
//            lastPoint = sChar.length - 1;
//            pointNum[1] = lastPoint;
//            boolean judPal = true;
//            judPal = judgePali(i, lastPoint, sChar, pointNum, judPal);
//                if (judPal == true ){
//                    if (pointNum[0] != pointNum[1]){
//                        result =  result.substring(pointNum[0],pointNum[1]+1);
//                        if (str.size() == 0) {
//                            str.add(result);
//                        } else {
//                            if (str.get(0).length() < result.length()) {
//                                str.clear();
//                                str.add(result);
//                            }
//                        }
//                    }
//
//            }
//        }
//        String a =s.substring(0,1);
//        if (str.size()==0) str.add(a);
//        return str.get(0);
//    }
//
//    private static boolean judgePali(int i, int lastPoint, char[] sChar, int[] pointNum, boolean judPal) {
//        if (sChar[i] == sChar[lastPoint]) {
//            if (i == lastPoint || i + 2 == lastPoint) {
//                return judPal;
//            }
//            if (pointNum[1] != 0) {
//                i++;
//                lastPoint--;
//                if (i>=lastPoint){
//                    return judPal;
//                }
//                judPal = judgePali(i, lastPoint, sChar, pointNum, judPal);
//            }
//        } else if (i < lastPoint) {
//            lastPoint --;
//            pointNum[1]--;
//            judPal = judgePali(i, lastPoint, sChar, pointNum, judPal);
//        }
//        if (sChar[i] != sChar[lastPoint] && i+1 == lastPoint){
//            judPal = false;
//            return judPal;
//        }
////        judPal = false;
//        return judPal;
//    }



    //best answer
    public  static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
        return longest;
    }

    // Given a center, either one letter or two letter,
    // Find longest palindrome
    public static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1
                && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        String subS = s.substring(begin + 1, end);
        return subS;
    }

    public static void main(String args[]) {
        String s = "abbcaba";
        String ss = "bb";
        String sss = "babad";
        String ssss = "abcda";
        String sssss = "aaabaaaa";


        longestPalindrome(sssss);

    }
}
