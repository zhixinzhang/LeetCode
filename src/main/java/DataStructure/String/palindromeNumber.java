package DataStructure.String;

/**
 * Created by zzx on 16-10-20.
 */

public class palindromeNumber {

    public static boolean isPalindrome(int x) {
        boolean result = false;
        if (x<0) return result;
        //1221
        int d = 1;
        while (x/d >= 10) d *= 10;

        while (x>0){
            int curNum = x/d;
            int curInt = x%10;
            if (curInt != curNum){
                return  result;
            }
            x = x%d /10;
            d = d/100;
        }
        return result = true;
    }



//    public static boolean isPalindrome(int x) {
//        int length = String.valueOf(x).length();
//        String s = String.valueOf(x);
//        char[] charList = s.toCharArray();
//        int lon = length/2;
//        Boolean end = true;
//        a: for(int i = 0;i<lon;i++){
//            char ee = charList[i];
//            char cc = charList[length-1-i];
//            if (charList[i] != charList[length-1-i]){
//                end = false;
//                break a;
//            }
//        }
//        return end;
//    }

    public  static  void main(String args[]){
//        int ii = 1231;
        int ii = -2147483648;
        int i = 1221; //122 1,12,21,  ,   9==9, 2==8
        int m = 12321; //88 79 ,  23432 77,68 1234321 877 679, 123454321 8766 5679
        int iii = 1221;
        Boolean result = isPalindrome(iii);
        System.out.print(result);
    }

}
