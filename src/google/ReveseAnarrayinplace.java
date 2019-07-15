package google;

/**
 * Created by zhang on 2017/12/3.
 */
public class ReveseAnarrayinplace {

    public int[] reverse(int[] s){
        //ArrayUtils.reverse(int[] array)
        for (int i = 0;i<s.length/2;i++){
            int tmp = s[i];
            // 1 2 3 4 5  --- 5 4 3 2 1
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = tmp;
        }
        return s;
    }
}
