package Company.Square.Algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1.  给你square 这个词，再给一堆别的词诸如Square, Squars,....找出只有一个typo的词， 注意大小写（要问面试官）
 * 不需要map，每个字符串 从左到右扫一遍 计算多少个不同
 * 
1.2 给你square这个词，再给别的一堆词swuare之类的，w 和q在键盘上比较近，close typo，返回只有一个close typo的词
1.3 给你square，找出squares，squre，这种删减只有一个的词
 * 
 * 
*/
public class SquareWordMatch {
    public static void main(String[] args){
        findCorrectWords("square", Arrays.asList("Square", "Squars", "square", "ssuare", "*quare"));
        findCorrectWords_Delete("square", Arrays.asList("squares", "squre", "sqaur", "Squae"));
    }

    //1.1
    private static void findCorrectWords(String original, List<String> dictionary){
        if (dictionary == null || dictionary.size() == 0 || original.length() == 0) {
            return;
        }

        for (String target : dictionary){
            if (target.length() == original.length()) {
                int distance = findDistance(target, original);
                if (distance == 1) {
                    System.out.println(target);
                }
            }
        }
    }

    private static int findDistance(String original, String target){
        int ans = 0;
        for (int i = 0; i < original.length(); i++){
            // ignore upper or lower letter
            char oriChar = Character.toLowerCase(original.charAt(i));
            char targetChar = Character.toLowerCase(target.charAt(i));
            if (oriChar != targetChar) {
                ans ++;
            }

            if (ans >= 2) {
                break;
            }
        }
        return ans;
    }

    //1.2
    static Map<Character, int[]> charCache = new HashMap<>();
    
    private static void findCorrectWordsCloest(String original, List<String> dictionary){
        
        if (dictionary == null || dictionary.size() == 0 || original.length() == 0) {
            return;
        }

        charCache.put('q', new int[]{0, 0});
        charCache.put('w', new int[]{0, 1});
        charCache.put('e', new int[]{0, 2});
        charCache.put('s', new int[]{1, 1});

        for (String target : dictionary){
            if ( original.length()  == target.length()) {
                int distance = findDistanceWithDelete(target, original);
                if (distance == 1) {
                    System.out.println(target);
                }
            }
        }
    }

    private static int findDistanceWithCloset(String target, String original){
        int ans = 0;
        
        for (int i = 0, j = 0; i < original.length() && j < target.length(); i++, j++){
            // ignore upper or lower letter
            char oriChar = Character.toLowerCase(original.charAt(i));
            char targetChar = Character.toLowerCase(target.charAt(j));
            int[] oriPosition = charCache.get(oriChar);
            int[] tarPosition = charCache.get(targetChar);
            
            if (oriChar != targetChar) {
                ans ++;
                if (oriPosition[0] == tarPosition[0] && Math.abs(oriPosition[1] - tarPosition[1]) != 1 || 
                oriPosition[1] == tarPosition[1] && Math.abs(oriPosition[0] - tarPosition[0]) != 1) {
                    ans ++;
                    break;
                }
            }

            if (ans >= 2) {
                break;
            }
        }
        return ans;
    }

    
        //1.3
    private static void findCorrectWords_Delete(String original, List<String> dictionary){
        if (dictionary == null || dictionary.size() == 0 || original.length() == 0) {
            return;
        }

        for (String target : dictionary){
            if ( original.length() - 1 == target.length()) {
                int distance = findDistanceWithDelete(target, original);
                if (distance == 1) {
                    System.out.println(target);
                }
            }
        }
    }

    // square, suare
    private static int findDistanceWithDelete(String target, String original){
        int ans = 0;
        
        for (int i = 0, j = 0; i < original.length() && j < target.length(); i++, j++){
            // ignore upper or lower letter
            char oriChar = Character.toLowerCase(original.charAt(i));
            char targetChar = Character.toLowerCase(target.charAt(j));
            if (oriChar != targetChar) {
                ans ++;
                j--;
            }

            if (ans >= 2) {
                break;
            }
        }
        return ans;
    }
    
}
