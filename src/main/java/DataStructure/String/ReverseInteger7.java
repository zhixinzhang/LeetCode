package DataStructure.String;

/**
 * Created by zhang on 2017/2/1.
 * Example1: x = 123, return 321
 Example2: x = -123, return -321
 */
public class ReverseInteger7 {
//我的答案会溢出
    public static int reverse(int x) {
        String s = String.valueOf(x);
        char[] sChar = s.toCharArray();
        for(int i = 0,k=sChar.length-1;i<sChar.length;i++){
            if (sChar[i]!= '-'){
                if (i <= sChar.length/2){
                    char tmp = sChar[i];
                    sChar[i] = sChar[k];
                    sChar[k] = tmp;
                    k--;
                }
            }
        }//-321
        int result = 0;
        for(int i = 0;i<sChar.length;i++){
            if(sChar[i] !='-' || sChar[i] !='0'){
                String  xx = String.valueOf(sChar[i]);
                if (i+1<sChar.length){
                    int tmp = Integer.valueOf(xx) *10;
                    if (result!=0) result = result*10;
                    result = result+tmp;
                }else {

                    result = result + Integer.parseInt(xx);

                }

            }
        }
        if (sChar[0] =='-') result = -1*result;
        return  result;
    }


    public static  void main(String args[]){
//        int x =  -123;
        int x = -10;
        reverse(x);

    }
}
