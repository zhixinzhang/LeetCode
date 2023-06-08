package Company.Square.Algo.StringWord;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1.  给你square 这个词，再给一堆别的词诸如Square, Squars,....找出只有一个typo的词， 注意大小写（要问面试官）
 * 不需要map，每个字符串 从左到右扫一遍 计算多少个不同
 * 
1.2 给你square这个词，再给别的一堆词swuare之类的，w 和q在键盘上比较近，close typo，返回只有一个close typo的词
1.3 给你square，找出squares，squre，这种删减只有一个的词   two pointer scan from left to right
 * 
 * 
*/
public class SquareWordMatch {
    public static void main(String[] args){
        findCorrectWords("square", Arrays.asList("Square", "Squars", "square", "ssuare", "*quare"));
        findCorrectWords_Delete("square", Arrays.asList("squares", "squre", "sqaur", "Squae"));
    }

    //1.1 找出只有一个typo的词， 注意大小写  不需要map，每个字符串 从左到右扫一遍 计算多少个不同
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
    static String[] lines = new String[]{"qwertyuiop", "asdfghhjkl", "zxcvbnm"};
    
    private static void findCorrectWordsCloest(String original, List<String> dictionary){
        
        if (dictionary == null || dictionary.size() == 0 || original.length() == 0) {
            return;
        }

        for (int i = 0; i < lines.length; i++){
            for (int j = 0; j < lines[i].length(); j++){
                charCache.put(lines[i].charAt(j), new int[]{i, j});
            }
        }

        for (String target : dictionary){
            if ( original.length()  == target.length()) {
                int distance = findClosetDistancee(target, original);
                if (distance == 1) {
                    System.out.println(target);
                }
            }
        }
    }

    private static int findClosetDistancee(String target, String original){
        int distance = 0;
        
        for (int i = 0, j = 0; i < original.length() && j < target.length(); i++, j++){
            // ignore upper or lower letter
            char oriChar = Character.toLowerCase(original.charAt(i));
            char targetChar = Character.toLowerCase(target.charAt(j));
            int[] oriPosition = charCache.get(oriChar);
            int[] tarPosition = charCache.get(targetChar);
            
            if (oriChar != targetChar) {
                distance ++;
                if (oriPosition[0] == tarPosition[0] && Math.abs(oriPosition[1] - tarPosition[1]) != 1 || 
                oriPosition[1] == tarPosition[1] && Math.abs(oriPosition[0] - tarPosition[0]) != 1) {
                    distance ++;
                    break;
                }
            }

            if (distance >= 2) {
                break;
            }
        }
        
        return distance;
    }

    
        //1.3  给你square，找出squares，squre，这种删减只有一个的词  two pointer
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
