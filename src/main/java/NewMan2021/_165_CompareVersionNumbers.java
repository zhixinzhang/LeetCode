package NewMan2021;

/**
 * @Author: Luke
 * @Date: 2020/10/25 20:45
 * Link : https://leetcode.com/problems/compare-version-numbers/
 */
public class _165_CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        if (version1 == version2) {
            return 0;
        }
        if (version1 == null || version2 == null) {
            return -2;
        }

        // 這個split 裏面用的是正則表達式， 別忘了加雙反斜杠， 我的輸入法怎麽是繁體的......
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int maxLen = Math.max(v1.length, v2.length);
        for (int i = 0; i < maxLen; i++){
            int a = 0, b = 0;
            if (i < v1.length) {
                a = Integer.valueOf(v1[i]);
            }

            if (i < v2.length) {
                b = Integer.valueOf(v2[i]);
            }

            if (a == b)
                continue;
            else
                return a - b > 0 ? 1 : -1;
        }
        return 0;
    }

    public static void main(String[] args){
        compareVersion("1.022", "1.0023");
    }
}
