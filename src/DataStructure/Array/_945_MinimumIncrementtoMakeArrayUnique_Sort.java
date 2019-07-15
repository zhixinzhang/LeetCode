package DataStructure.Array;

import java.util.Arrays;


/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/17/19
 * Time: 8:53 PM
 * Description:
 */


public class _945_MinimumIncrementtoMakeArrayUnique_Sort {
    public static void main(String[] args){
        minIncrementForUnique(new int[]{3,2,1,2,1,7});
    }
    public static int minIncrementForUnique(int[] A) {
        int len=A.length,count=0;
        if(len==1) {
            return 0;
        }
        Arrays.sort(A);
        for(int i=0;i<len-1;i++) {
            if(A[i]==A[i+1]) {
                A[i+1]=A[i]+1;
                count++;
            }else if(A[i]>A[i+1]) {
                int inc=A[i]-A[i+1]+1;
                A[i+1]+=inc;
                count+=inc;
            }
        }

        return count;
    }
}
