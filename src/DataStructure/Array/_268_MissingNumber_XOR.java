package DataStructure.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/5/19
 * Time: 1:10 PM
 * Description:
 * Well, the XOR solution is based on the fact that the largest element in the list is the one that replaced the missing element we are searching for. This means the largest element can never be missing.
 * The actual list contains integers from 0 to n, the list we are given has 1 missing element.
 * So we can conclude n = length of the given list
 * What you need to know about XOR is that it's both commutive and assosiative
 * commutive means A ^ B = B ^ A
 * assosiative means (A ^ B) ^ C = A ^ (B ^ C)
 * This means that order doesn't matter
 * Other thing you need to know about XOR, if you XOR 2 similar numbers, the result is 0. A ^A = 0
 * So now we will XOR the value of n with all the indicies from 0 to n-1 and with all the values we have in our array.
 * For example:
 * array = 0,1,2,4
 * index = 0,1,2,3
 * n = 4
 * 4 ^ (0^0) ^ (11) ^ (2^2) ^ (4^3)
 * = (4^4) ^ (0^0) ^ (11) ^ (2^2) ^ 3
 * = 0 ^ 0 ^ 0 ^ 0 ^ 3
 * = 3
 */


public class _268_MissingNumber_XOR {
    public int miss(int[] nums){
        int res = nums.length;
        for(int i = 0; i < nums.length; i ++){
            res = res ^ i;
            res ^= nums[i];
        }
        return res;
    }

    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        Set<Integer> visited = new HashSet<>();
        for(int i : nums){
            visited.add(i);
        }
        int n = nums.length;
        while(n > 0){
            if(!visited.contains(n))
                return n;
            n--;
        }
        return n;
    }
}
