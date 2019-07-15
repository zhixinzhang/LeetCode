package google;

/**
 * Created by zhang on 2018/5/30.
 */
public class _484_FindPermutation_Swap {
    public static int[] findPermutation(String s) {
        // IIIIII   1234567
        // DIIIDD   2134765  each D we swap
        // DIIDID   2134567  21354 67 DIIDID 2135476
        // DIIDIDD  21354678
        int l = s.length();
        int[] res = new int[l+1];
        for(int i = 0; i<res.length;i++){
            res[i] = i+1;
        }
        for(int i = 0; i<res.length; i++){
            if(i>=s.length()) break;
            char c = s.charAt(i);
            if(c == 'D'){
                i = swap(s,res,i);
            }
        }
        return res;
    }
    //找到连续的D区间 然后reverse D
    private static int swap(String s, int[] res, int index){
        int lastD = index;
        while(lastD < s.length()-1 && s.charAt(lastD+1) == 'D'){
            lastD++;
        }
        int resIndex = lastD+1;
        for(int i = index; i<lastD+1; i++){
            int tmp = res[lastD+1];
            res[lastD+1] = res[index];
            res[index] = tmp;      // 4567 --- 7654
            index++;
            lastD--;
        }
        return resIndex;
    }
    public static void main(String[] args){
        findPermutation("DDIIDI");
    }
}
