package google.Array;

/**
 * Created by zhang on 2018/6/19.
 */
public class _268_MissingNumber_XOR {
// value  0 1 3    i = 2 ^ 3
// index 0 1 2
    public static int solution(int[] nums){
        int result = 0;
        // 0 1 2 4
        // 0 1 2 3
        for (int i = 1; i<nums.length; i++){

            result ^= i;
            result ^= nums[i - 1];
        }
        return result;
    }
    public static void main(String[] args){
        solution(new int[]{0,1,3});
    }
}
