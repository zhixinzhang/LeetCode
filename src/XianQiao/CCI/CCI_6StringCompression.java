package XianQiao.CCI;

import java.util.Stack;

/**
 * @Author: Xianqiao
 * @Date: 6/9/20 20:53
 */

/**
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
 * "compressed" string would not become smaller than the original string, your method should
 * return the original string. You can assume the string has only uppercase and lowercase
 * letters (a - z). */

/** My Solutions */
public class CCI_6StringCompression {
    public static void main(String[] args){
        System.out.println(stringCompression("abbbbbccf"));
        //System.out.println(stringCompression_Stack("aaabbbbcc"));
    }
    private static String stringCompression(String str) {
        StringBuilder newStr = new StringBuilder();
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (newStr == null || newStr.length() == 0) {
                newStr.append(str.charAt(i));
                index++;
            } else if (str.charAt(i) != str.charAt(i-1)) {
                newStr.append(index);
                newStr.append(str.charAt(i));
                index = 1;
                if (i == str.length() - 1) {
                    newStr.append('1');
                }
            } else if (str.charAt(i) == str.charAt(i-1)) {
                index++;
                if (i == str.length() - 1) {
                    newStr.append(index);
                }
            }
        }
        return newStr.length() < str.length() ? newStr.toString() : str;
        //if (newStr.length() > str.length()) {
        //    return str;
        //}
        //return newStr.toString();
    }

    private static String stringCompression_Stack(String str) {
        StringBuilder newStr = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        newStr.append(str.charAt(0));
        for (int i = 0; i < str.length(); i++) {
            while (!stack.isEmpty()) {
                if (str.charAt(i) != str.charAt(i-1)) {
                    newStr.append(stack.pop());
                    newStr.append(str.charAt(i));
                    stack.push(1);
                    if (i == str.length() - 1) {
                        newStr.append(stack.pop());
                    }
                } else {
                    stack.push(stack.pop() + 1);
                }
            }
        }
        return newStr.length() < str.length() ? newStr.toString() : str;
    }

    /** CCI Solution */
    String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
}


