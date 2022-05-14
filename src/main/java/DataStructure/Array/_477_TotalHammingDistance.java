package DataStructure.Array;

/**
 * Created by zhang on 2018/1/16.
 */
// 不能用for loop casue tle
public class _477_TotalHammingDistance {
    public static  void main(String[] args){
        totalHammingDistance(new int[]{4,14,2});
    }
        public static int totalHammingDistance(int[] nums) {
            int res = 0;
            int len = nums.length;
            for(int i = 0;i<32;i++){
                int zero = 0;
                for(int j = 0 ;j<nums.length;j++){
                    if(nums[j] % 2 == 0)
                        zero++;
                    nums[j] = nums[j]/2;
                }
                res += zero * (len - zero);
            }
            return res;
        }
    }
