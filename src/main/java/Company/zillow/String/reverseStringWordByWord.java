package Company.zillow.String;

/**
 * Created by zhang on 2018/8/21.
 */
public class reverseStringWordByWord {
    public static void main(String[] args){
        reverse("zzx is good boy");
    }
    public static String reverse(String s){
        String[] sArr = s.split(" ");
        String res = "";
        for (int i = sArr.length-1; i>=0; i--)
            if (i != 0)
                res += sArr[i] + " " ;
            else
                res += sArr[i];
        return res;
    }
}
