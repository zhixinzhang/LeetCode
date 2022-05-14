package Company.Amazon.String;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/4/19
 * Time: 3:28 PM
 * Description:
 *
 * follow up  判断一个 整数是 palindrone
 */


public class _125_ValidPalindrome_TwoPointer {
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
    public static boolean isPalindrome_Integer(long num) {
        String s = String.valueOf(num);
        return isPalindrome(s);
    }

    public static void main(String[] args){
        isPalindrome_Integer(1115454534);
    }
}
