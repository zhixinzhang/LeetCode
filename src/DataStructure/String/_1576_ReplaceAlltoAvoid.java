package DataStructure.String;

/**
 * @author Luke(New Man) Zhang
 * @Date 4/5/2021 10:41 PM
 * <p>
 * Description:
 * Similar task :
 * Key Point:
 */

public class _1576_ReplaceAlltoAvoid {
    public static void main (String[] args){
        modifyString("z?a");
    }
    public static String modifyString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char prev = 'a';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char current = s.charAt(i);

            if (current == '?') {
                current = (char)(prev + 1) >= 'z' ? 'a' : (char)(prev + 1);
                if (i < s.length() - 1 && s.charAt(i + 1) == current) {
                    current = (char)(current + 1) >= 'z' ? 'a' : (char)(current + 1);
                }
            }
            prev = current;

            sb.append(prev);
        }

        return sb.toString();
    }
}
