package DataStructure.String;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/20/19
 * Time: 7:36 PM
 * Description:
 */


public class _925_LongPressedName_TwoPointer {
    public static void main(String[] args){
        String a = "alex";
        String b = "aaalleexxx";
        isLongPressedName(a, b);
    }

    public boolean isLongPressedName_(String name, String typed) {
        if(name.length() == 0 && typed.length() == 0){
            return true;
        }
        if(name.length() == 0 || typed.length() == 0){
            return false;
        }
        int n = 0;
        for(int i = 0; i < typed.length();i++){
            if(typed.charAt(i) == name.charAt(n)){
                n++;
            }
            if(n == name.length()){
                return true;
            }
        }
        return false;
    }

    public static boolean isLongPressedName(String name, String typed) {

        if(typed == null || name == null || typed.length() < name.length())
            return false;
        int l = 0, r = 0;
        while(r < typed.length()){
            if(l >= name.length() || typed.charAt(r) != name.charAt(l))
                return false;
            while( r < typed.length() && typed.charAt(r) == name.charAt(l))
                r++;
            l++;
        }
        return true;
    }
}
