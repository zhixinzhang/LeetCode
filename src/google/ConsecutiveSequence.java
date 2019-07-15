package google;

import java.util.HashSet;

/**
 * Created by zhang on 2017/12/5.
 */
//A = [1,9,8,6,5,3,2]
//Ans = ["1-3","8-9","5-6"]
//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=305879&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311/
/**convert array to set in O(N)
 for each number e still in set:
 a. while (e+1) in set go up
 b. while (e-1) in set go down
 add range [emin-emax] to ans
 //
 Each element is touched only once, O(N)*/
public class ConsecutiveSequence {

        public char[] rea(int[] arr){
            HashSet<Integer> hs = new HashSet<>();
            char[] c = new char[10];
            //delete duplicate
            for (int i = 0;i<arr.length;i++){
                hs.add(arr[i]);
            }
            for(int i = 0; i<hs.size();i++){
//                hs.contains(arr[i]+1);
                //hs.contains(arr[i]-1);
            }

            return c;
        }



}
