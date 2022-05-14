package DataStructure.Integer;

/**
 * Created by zhang on 2018/4/19.
 * 最优解是二分法   例如 16 最高为是 16/2 最低为是1 去中间 4
 */
public class _367_ValidPerfectSquare_BinarySearch {
    //O(log num)
    public boolean isPerfectSquare_BS(int num) {
        if(num == 1)
            return true;

        long low = 1,
                high = num / 2,
                mid = 0;

        long nums = (long)num;

        while(low <= high)
        {
            mid = low + (high - low) / 2;

            if((mid * mid) == nums)
                return true;
            else if( (mid * mid) < nums)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    //O(num/2)
    public boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;
        if(num < 0)
            return false;
        int i = 1;
        while(i<= num/2){
            if(num == i*i ){
                return true;
            }
            i++;
        }
        return false;
    }
}
