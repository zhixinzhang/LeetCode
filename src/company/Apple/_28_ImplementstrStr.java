package company.Apple;

/**
 * Created by zhang on 2018/2/12.
 */
public class _28_ImplementstrStr {
    // O(mn)
    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        if (haystack == null)
            return -1;

        int n = needle.length();
        for(int i = 0;i <= haystack.length() - needle.length(); i++){
            String s = haystack.substring(i,i + n);
            if(s.equals( needle))
                return i;
        }
        return -1;
    }

    //如果字符串允许有几个错误
    public static int strStr_fellowUP(String base, String target,int error){
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
                    if (curError > error){
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
        strStr_fellowUP("Inter","Inverk",1);
    }
}
