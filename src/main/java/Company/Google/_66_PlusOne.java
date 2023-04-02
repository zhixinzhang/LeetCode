package Company.Google;

/**
 * Created by zhang on 2018/5/6.
 */
public class _66_PlusOne {
        public static int[] plusOne(int[] digits) {
            // [9 , 9] - [1 , 0 , 0]
            for (int i = digits.length - 1; i >=0; i--) {
                if (digits[i] != 9) {
                    digits[i]++;
                    break;
                } else {
                    digits[i] = 0;
                }
            }
            if (digits[0] == 0) {
                int[] res = new int[digits.length+1];
                res[0] = 1;
                return res;
            }
            return digits;
        }
        public static void main(String[] args){
            plusOne(new int[]{8,9});
        }
    }
