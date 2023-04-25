package Company.Ebay;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/4/19
 * Time: 3:28 PM
 * Description:
 *
 * follow up  判断一个 整数是 palindrone 
 * 不用換成string
 */


public class _125_ValidPalindrome_TwoPointer {
    public static void main(String[] args){
        isPalindrome_Integer(1234);
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }
    
    public static boolean isPalindrome_Integer(int x) {
        if (x < 0) {
            return false;
        }
        int rev = reverse(x);
        return x == rev;
    }

    private static int reverse(int x){
        int rev = 0;
        while (x != 0){
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10)
            return 0;
            if (rev < Integer.MIN_VALUE / 10)
                return 0;
            rev = rev * 10 + pop;    
        }
        return rev;
    }
}
