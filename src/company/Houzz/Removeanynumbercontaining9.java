package company.Houzz;
import java.util.*;
/**
 * Created by zhang on 2018/1/21.
 */
public class Removeanynumbercontaining9 {
    public static void main(String[] args){
        nthNumber(39);
    }


    public static String nthNumber(int n){
        int base = 9;
        char[] digits = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8'};
        StringBuilder str = new StringBuilder("");
        if(0==n){
            str.append(digits[0]);
        }else{
            Stack<Character> s = new Stack<Character>();
            while(n != 0){
                s.push(digits[n%base]);  // 19 -- 20
                n/=base;
            }
            while(!s.isEmpty()){
                str.append(s.pop());
            }
        }
        return str.toString();
    }
}
