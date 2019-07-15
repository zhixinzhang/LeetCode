package google.Integer;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/25/19
 * Time: 7:58 PM
 * Description:
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=518250&page=1
 *
 */


public class StringToNumber_FollowUp {
    public static void main(String[] args){
//        StringToNumber("1234.4456");
        StringToNumber("200");

    }
    public static double StringToNumber(String s){
        if (s == null || s.length() == 0)
            return 0;
        int i = s.charAt(0) == '-' ? -1 : 1;
        double ansL = 0.0;
        double ansR = 0.0;
        boolean flag = false;
        int left = 10;
        double right = 0.1;
        for (char c : s.toCharArray()){
            if (c == '-' || c == '+')   continue;
            if (c == '.'){
                flag = true;
                continue;
            }
            if (!flag){         // left dot
                double val = c - '0';
                if (ansL == 0.0)
                    ansL = val;
                else{
                    ansL *= left;
                    ansL += val;
                }
                System.out.println(ansL);
            }else {
                double val = c - '0';
                val *= right;
                ansR += val;
                right *= 0.1;
            }
        }
        double ans = i * (ansL + ansR);
        return ans;
    }
}
