package google;

/**
 * Created by zhang on 2018/5/13.
 */
public class _BigInteger_design {
    static class BigInteger {
        String val;
        BigInteger(String val) {
            this.val = val;
        }

        //  1 2 3
        //4 5 6 7
         BigInteger add(BigInteger bb) {
            StringBuilder sb = new StringBuilder();
            int s = val.length();       // 3
            int a = bb.val.length();     // 4
            int flag = 0;
            for (int i = s - 1, j = a - 1; i >= 0 || j >= 0 || flag == 1; i--, j--) {
                int sV = i < 0 ? 0 : val.charAt(i) - '0';
                int aV = j < 0 ? 0 : bb.val.charAt(j) - '0';
                sb.append((sV + flag + aV) % 10);
                flag = (sV + aV + flag) / 10;
            }

            BigInteger res = new BigInteger(sb.reverse().toString());
            return res;
        }
    }

    public static void main(String[] args) {
        BigInteger b = new BigInteger("123");
        BigInteger bb = new BigInteger("5456");
        bb.add(b);
    }
}
