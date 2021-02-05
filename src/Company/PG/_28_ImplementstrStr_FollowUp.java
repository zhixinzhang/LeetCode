package Company.PG;

/**
 * Created by zhang on 2018/1/29.
 */
//follow up，允许一个maxError数，如“pocket gems”“game”
// maxError = 2, 则返回7. 时间复杂度。
//O(m n)
public class _28_ImplementstrStr_FollowUp {
    public static int strStr(String base, String target, int maxError){
        if (base == null || target == null) {
            return -1;
        }
        if (base.isEmpty() && target.isEmpty()) {
            return 0;
        }
        int i, j;
        int diff = base.length() - target.length();
        int curError = 0;
        for (i = 0; i <= diff; i++) {
            for (j = 0; j < target.length(); j++) {
                if (base.charAt(i + j) != target.charAt(j)) {
                    curError++;
                    if (curError > maxError){
                        curError = 0;
                        break;
                    }
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        strStr("Inter","Invert",1);
    }
}
