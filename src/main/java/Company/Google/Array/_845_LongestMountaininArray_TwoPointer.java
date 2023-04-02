package google.Array;

/**
 * Created by zhang on 2018/6/3.
 */
public class _845_LongestMountaininArray_TwoPointer {
    public int longestMountain(int[] A) {
        //          2,  1,  4,  7,   3,  2,  5
        //left      l   l                l
        //right     r   r   r   r    r   r
        // peek == 1
        int go = 0;
        int down = 0;
        int len = 0;
        if(A == null || A.length == 0)  return len;
        for(int i = 0; i < A.length - 1; i++){
            if(A[i] < A[i + 1]){
                if(i != 0 && A[i] < A[i - 1]){
                    go = 0;
                    down = 0;
                }
                go++;
            }else if(A[i] > A[i + 1]){
                down++;
                if(go != 0)
                    len = Math.max(len, go+down);
            }else{
                go = 0;
                down = 0;
            }
        }
        if(len < 2){
            return 0;
        }
        return len +1;
    }
}
