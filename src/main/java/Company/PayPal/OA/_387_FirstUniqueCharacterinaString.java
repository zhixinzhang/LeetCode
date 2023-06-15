package Company.PayPal.OA;

import java.util.HashMap;

/**
 * https://www.1point3acres.com/bbs/thread-952004-1-1.html
 * 3. First Unique Character
暴力解法。遍历string s去count每个字母的个数（可以用ord转换字母为unicode作为数组下标inde‍‌‌‌‌‍‌‌‍‍‌‌‍‌‌‍‌‍‌x）。
数完了再来一层遍历来看谁是unique 就counter个数为1，返回就行。
遍历完了没有的话就返回-1
 * 
*/
public class _387_FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int n = s.length();
        // build char count bucket : <charIndex, count>
        for (int i = 0; i < n; i++) {            
            int index = s.charAt(i) - 'a';
            count[index]++;
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) {
                return i;
            }
                
        }
        return -1;
    }

    public int firstUniqCharMap(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
    }
}
