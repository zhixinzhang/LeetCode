package Company.Apple;
/**
 * Created by zhang on 2018/2/7.
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 Note:
 The length of both num1 and num2 is < 110.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero
 */
// O(n * m)    from left position multiply each num
public class _43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        if (num1.equals("0") || num2.equals("0")) return "0";
        int length1 = num1.length(), length2 = num2.length();
        if (length1 < length2) return multiply(num2, num1);
        char[] num1Array = num1.toCharArray(), num2Array = num2.toCharArray();
        StringBuilder res = new StringBuilder();
        int carry = 0, sum;
        for (int i = 0; i < length1 + length2; i++) {
            sum = carry;
            for (int j = 0; j < length2; j++) {
                int index = i-j;
                if (index>=0 && index < length1)
                    sum += (num1Array[length1 - index - 1] - '0') * (num2Array[length2 - j - 1] - '0');
            }
            res.append(sum % 10);
            carry = sum / 10;
        }
        return res.reverse().charAt(0) == '0'? res.deleteCharAt(0).toString() : res.toString();
    }
}
