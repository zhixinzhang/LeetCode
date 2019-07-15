package company.Google2019;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 2/18/19
 * Time: 3:19 PM
 * Description:
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=482576&page=1&authorid=256744
 */


//     "(a(bc()d(ef))g)" -> a(bcd(ef)g)
//      "( )" -> " "
//      "(a(b)()c)"  -> "(a(b)()c)"
public class RemoveExtraParentheses {
    public static void main(String[] args){
        String res = res("(a()(bcd(ef))g)");
    }

    private static String res(String s){
        s = s.replaceAll(" ","");
        StringBuilder validS = new StringBuilder();

        for (int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(c == '('){
                validS.append('(');
            }else if (c != ')'){
                validS.append(c);
            }else {
                if (validS.charAt(validS.length()-1) == '('){
                    validS.deleteCharAt(validS.length()-1);
                }else {
                    validS.append(')');
                }
            }
        }

        return validS.toString();
    }

}
