package Company.Amazon.onethree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/29/19
 * Time: 4:51 PM
 * Description:
 */


public class CalculateCurrenty {
    public static void main(String[] args){
        solve("Mary bought an ipad for $200.54 and a pencil for USD100.56");
    }
    public static List<Double> solve(String s){
        List<Double> ans = new ArrayList<>();
        if (s == null || s.length() == 0) return ans;
        String[] subS = s.split(" ");
        for (String curS : subS){
            int l = curS.indexOf("$");
            int r = curS.indexOf("USD");
            String price = "";
            if (curS.charAt(0) == '$'){
                price = curS.substring(1, curS.length());
            }else if (r != -1){
                price = curS.substring(r+3);
            }
            if (price.length() >= 1){
                if (price.charAt(price.length()-1) == '.'){
                    price = price.substring(0, price.length()-1);
                }
                ans.add(convert(price));
            }
        }
        return ans;
    }
    public static double convert(String price){
        double left = 0.00;
        double right = 0.00;
        double flag = 0.1;
        String[] prices = price.split("\\.");
        String l = prices[0];
        String r = prices.length == 2 ? prices[1] : "";

        double a = Double.parseDouble(price);

        for (int i = 0; i < l.length(); i++){
            left *= 10;
            double curVal = l.charAt(i) - '0';
            left += curVal;
        }
        for (int i = 0; i < r.length(); i++){
            double curVal = r.charAt(i) - '0';
            curVal *= flag;
            flag *= 0.1;
            right+=curVal;
        }
        return left + right;
    }
}
