package Company.Apple;

/**
 * Created by zhang on 2018/2/7.
 * Given an integer, write a function to determine if it is a power of two.
 * 如果是power of two, 则2进制表达中,有且仅有一个1
 */
public class _231_PowerofTwo {
    public  static void main(String[] args){
        isPowerOfTwo(8);
    }
    //        ：仅有首位为1，其余各位都为0.
    //  8     1 0 0 0
    //  7     0 1 1 1
    //  &     0 0 0 0

    public boolean isPowerOfTwo_itera(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        while(n % 2 == 0){
            n = n/2;
        }
        return n == 1;
    }

    public static boolean isPowerOfTwo(int n){
        return n > 0 && ((n & (n - 1)) == 0 );
//        String c = DataStructure.Integer.toBinaryString(n);
//        int count = 0 ;
//        for (int i = 0; i < c.length();i++){
//            if (c.charAt(i) == '1')
//                count++;
//            if (count >=2)
//                return false;
//        }
//        return true;
    }
}
