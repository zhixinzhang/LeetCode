package DataStructure.String;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/14/19
 * Time: 2:40 PM
 * Description:
 */


public class _989_AddtoArrayFormofInteger_ {
    public static void main(String[] args){
        addToArrayForm(new int[]{1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3}, 516);
    }
    // 无法处理 超越long的数字
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        long ans = 0;
        for(int i = 0; i < A.length ; i++){
            ans = (ans * 10 + A[i]);
        }
        ans += K;
        while(ans >= 10){
            int left = (int)(ans % 10);
            res.add(left);
            ans /= 10;
        }
        res.add((int) ans);
        Collections.reverse(res);
        return res;
    }

    public List<Integer> addToArrayForm_Best(int[] nums, int k) {
        List<Integer> result = new ArrayList<>(nums.length + 1);
        for (int i = nums.length - 1, carry = 0; i >= 0 || k > 0 || carry > 0; i--, k /= 10) {
            int d1 = i >= 0 ? nums[i] : 0;
            int d2 = k % 10;
            int sum = d1 + d2 + carry;

            result.add(sum % 10);
            carry = sum / 10;
        }
        Collections.reverse(result);
        return result;
    }
}
