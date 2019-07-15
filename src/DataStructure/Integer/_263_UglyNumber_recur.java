package DataStructure.Integer;

/**
 * Created by zhang on 2017/11/30.
 */
public class _263_UglyNumber_recur {
    public static void main(String[] args){
        isUgly(8);
    }
    public static boolean isUgly(int num) {
        if(num == 1)
            return true;
        if(num < 0)
            return false;
        boolean res = dfs(num);
        return res;
    }
    private static boolean dfs(int num){
        //break conition
        if(num < 2 ){
            return false;
        }

        if(num == 2 || num == 3 || num == 5){
            return true;
        }
        boolean a = true;
        boolean b = true;
        boolean c = true;
        if(num%2 == 0){
            a =  dfs(num/2);
        }else {
            a = false;
        }
        if(num%3 == 0){
            b = dfs(num/3);
        }else {
            b  = false;
        }
        if(num%5 ==0){
            c = dfs(num/5);
        }else{
            c = false;
        }
        if(a||b||c){
            return true;
        }
        return false;
    }



//    if(num <= 0) return false;
//            if(num == 1) return true;
//
//            while (num > 1) {
//        if (num % 2 == 0) {
//            num = num / 2;
//        } else if(num % 3 == 0) {
//            num = num / 3;
//        } else if (num % 5 == 0) {
//            num = num / 5;
//        } else
//            return false;
//    }
//            return true;


}
