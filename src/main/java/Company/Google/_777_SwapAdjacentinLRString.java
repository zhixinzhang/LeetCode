package Company.Google;

/**
 * Created by zhang on 2018/5/16.
 * 第一行容易理解，去除X之后，只剩L和R，它们的位置是严格对应的，不对应返回false。
 * 因为只有两种replace模式，RX -> XR 和XL -> LX，所以无论如何都不会出现LR，
 * 变成RL的情况。而X的出现只是可以让R或者L可以左右浮动到相应的位置而已。
 */
public class _777_SwapAdjacentinLRString {
        public static boolean canTransform(String start, String end) {
            if (!start.replace("X", "").equals(end.replace("X", ""))) return false;
            char[] s = start.toCharArray();
            char[] e = end.toCharArray();
            int n = s.length;
            int i = 0, j = 0;
            while (i < n && j < n) {
                while (j < n && e[j] == 'X') j ++;
                while (i < n && s[i] == 'X') i ++;
                if (i == n || j == n) break;
                if (s[i] == 'R' && i > j) return false;
                if (s[i] == 'L' && i < j) return false;
                i ++;
                j ++;
            }
            return true;
        }
        public static void main(String[] args){
            canTransform("RXXLRXRXL","XRLXXRRLX");
        }
    }
