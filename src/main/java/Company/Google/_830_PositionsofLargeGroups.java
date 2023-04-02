package Company.Google;
import java.util.*;
/**
 * Created by zhang on 2018/5/14.
 */
public class _830_PositionsofLargeGroups {
    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if(S == null || S.length() < 3) return res;
        // "abbbxxxxzyy"
        for(int i = 0; i<S.length(); i++){
            List<Integer> group = new ArrayList<>();
            int right = i+1;
            int count = 1;
            while(right <= S.length()-1 && S.charAt(i) == S.charAt(right)){
                right++;
                i++;
                count++;
            }
            if(count >= 3){
                group.add(right - count);
                group.add(right-1);
                res.add(group);
            }
        }
        return res;
    }
    public static void main(String[] args){
        largeGroupPositions("abbbxxxxzyy");
    }
}
