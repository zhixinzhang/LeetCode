package DataStructure.String;

import java.util.Stack;

/**
 * Created by zhang on 2018/5/1.
 * //根据 stack 去存储 character 根据字母排序
 *
 * https://leetcode.com/problems/remove-duplicate-letters/discuss/76762/Java-O(n)-solution-using-stack-with-detail-explanation
 */
public class _316_RemoveDuplicateLetters_stack {
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        char[] arr = s.toCharArray();
        for(char c : arr) {
            count[c-'a']++;
        }
        for(char c : arr) {
            count[c-'a']--;
            if(visited[c-'a']) {
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a'] > 0) {
                visited[stack.peek()-'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        removeDuplicateLetters("bcabc");
    }
}
