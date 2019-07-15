package company.Amazon;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/5/19
 * Time: 11:44 PM
 * Description:
 */


public class DecimalToHexadecimal {
    // 10 -> 13
    // 20 ->   49*7/49/7  -> 26
    // 280 + 63 = 343   344 -> 101
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        int num = 344;
        while (true){
            int left = num % 7;
            sb.insert(0, left);
            num /= 7;
            if (num == 7){
                sb.insert(0, 1);
                break;
            }
            if (num < 7)
                break;

        }
        String s = sb.toString();
        int ans = Integer.parseInt(s);
    }
}
