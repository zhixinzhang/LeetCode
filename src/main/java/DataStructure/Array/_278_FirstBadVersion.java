package DataStructure.Array;

/**
 * Created by zhang on 2017/10/7.
 */
/*binary search 折半查找
key point  find mid =   start  + (end - start) / 2
* */
public class _278_FirstBadVersion {
    public int firstBadVersion(int n) {
        if (n <= 0){
            return Integer.MIN_VALUE;
        }
        int start = 1;
        int end = n;
//        while (start < end -1){
//            int mid = start + (end - start)/2;
//            //bad
//            if (isBadVersion(mid)){
//                end = mid;
//            }else{                      // good
//                start = mid;
//            }
//        }
//        return isBadVersion(start) ? start : end;
        return 0;
    }
}
