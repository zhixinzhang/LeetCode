package DataStructure.Array;

/**
 * Created by zhang on 2017/12/12.
 */
// XOR  ^ 转换成2进制然后对比 如果一样 返回0 不一样返回1
// https://www.youtube.com/watch?v=C4GWPpNivfI
// 3 3 ---  011  011  --》 000
public class _136_SingleNumber_XOR {
    public static int singleNumber(int A[]) {
        int result=A[0];
        for(int i=1;i<A.length;i++)
        {
            result= result^A[i];  /* Get the xor of all elements */
            int c = 0;
        }
        return result;
    }
    public  static  void main(String[] args){
        int[] nums = {9,4,3,3,4};
        int c = singleNumber(nums);
    }
}
