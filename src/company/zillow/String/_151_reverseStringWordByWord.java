package company.zillow.String;

/**
 * Created by zhang on 2018/8/21.
 */
public class _151_reverseStringWordByWord {
    public static void main(String[] args){
        reverse("zzx is good boy");
    }
    public static String reverse(String s){
        String[] sArray = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = sArray.length - 1; i >= 0; i--) {
            //if(sArray[i].isEmpty())
            //continue;
            if (!sArray[i].isEmpty()) {
                sb.append(sArray[i]);
                sb.append(" ");
            }

        }
        return sb.toString().trim();
    }
}
