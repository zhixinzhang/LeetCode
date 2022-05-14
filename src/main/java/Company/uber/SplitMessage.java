package Company.uber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/9/5.
 */
public class SplitMessage {
    public static void main(String[] args){
        String message = "Hey Alice, your Uber is arriving now!";
        slpit(message);
    }
    public static List<String> slpit(String message){
        List<String> res = new ArrayList<>();
        // (1/1)
        if(message == null || message.length() <= 15){
            res.add(message + "(1/1)");
            return res;
        }
        // split string to string[]
        String[] m = message.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m.length; ){
            if (sb.length() + m[i].length() + 1 <= 15){
                sb.append(m[i] + " ");
                i++;
            }else {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        res.add(sb.toString());
        for (int i = 1; i <= res.size(); i++){
            String curM = res.get(i-1);
            curM += "(" + i + "/" + res.size() + ")";
            res.set(i-1,curM);
        }
        return res;
    }
}
