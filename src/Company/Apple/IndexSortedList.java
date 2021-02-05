package Company.Apple;

/**
 * Created by zhang on 2018/2/8.
 */
// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=315073&page=1#pid3495219
//找到一个sorted list里面target的最小和最大index.
// O(logn) * 2
public class IndexSortedList {
    // s =  [1,2,4,4,4,8,9]         [2,4]
    public static int[] bs(int[] s, int target){
        int[] res = new int[2];
        int left = 0;
        int right = s.length - 1;
        // find smallest index
        while (left <= right){
            int mid = (left + right) / 2;
            if (s[mid] > target){
                right = mid+1;
            }else if (s[mid] == target){
                if (mid == 0){
                    res[0] = mid;
                    break;
                }
                if (s[mid-1] == target){
                    right = mid - 1;
                }else{
                    res[0] = mid;
                    break;
                }
            }else if(s[mid] < target){
                left = mid + 1;
            }
        }
        left = 0;right = s.length-1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (s[mid] < target){
                 left = mid;
            }else if (s[mid] == target){
                if (mid == s.length-1){
                    res[1] = s.length-1;
                    break;
                }
                if (s[mid + 1] == target){
                    left = mid + 1;
                }else{
                    res[1] = mid;
                    break;
                }
            }else if(s[mid] > target){
                right = mid;
            }
        }
        return res;
    }
    public static void main(String[] args){
//        bs(new int[]{1,2,4,4,4,8,9},4);
        bs(new int[]{4,4},4);

    }
}
