package Company.uber;

/**
 * Created by zhang on 2018/9/16.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=371960&ctid=201324
 */
public class BuildWord {
    public static void main(String[] args){
        System.out.println("we need time :  " + build("ubercab", "bearuuu"));
    }
    public static int build(String word, String target){
        word = word.toLowerCase();
        target = target.toLowerCase();
        int[] countT = new int[26];
        int[] countW = new int[26];
        for (int i = 0; i < target.length(); i++){
            char c = target.charAt(i);
            if (c != ' ')
                countT[target.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word.length(); i++)
            if (word.charAt(i) != ' ')
                countW[word.charAt(i) - 'a']++;
        int res = 0;

        for (int i = 0; i < 26; i++){
            int tN = countT[i];
            int wN = countW[i];
            if (tN != 0 && wN == 0)
                return -1;
            if (tN == 0)    continue;
            int cur;
            if (tN % wN != 0)
                cur = tN / wN + 1;
            else
                cur = tN / wN;
            res = Math.max(res, cur);
        }
        return res;
    }
}
