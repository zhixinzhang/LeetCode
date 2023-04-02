package google.Integer;

/**
 * Created by zhang on 2018/6/22.
  only divide by 2  3 5
 */
public class _263_UglyNumber {
    public boolean solution(int n){
        if (n == 1) return true;
        while (n > 1){
            if (n % 2 == 0) {
                n = n / 2;
            } else if(n % 3 == 0) {
                n = n / 3;
            } else if (n % 5 == 0) {
                n = n / 5;
            } else
                return false;
        }
        return true;
    }
}
