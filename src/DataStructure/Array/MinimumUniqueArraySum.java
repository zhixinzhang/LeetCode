package DataStructure.Array;
import java.util.*;
/**
 * Created by zhang on 2018/1/14.
 */
public class MinimumUniqueArraySum {
    public static void main(String[] args){
        Minimum(new int[]{3,2,1,2,2,7});
    }
    public static int Minimum(int[] arr){
        int res = 0;
        if(arr.length ==0) return res;

        Arrays.sort(arr);
        res = arr[0];
        int prev = arr[0];
        for(int i = 1; i< arr.length;i++){
            if(arr[i] != prev){
                res += arr[i];
            }else{
                res += arr[i]*2;
            }
            prev = arr[i];
        }
        return res;
    }

}
