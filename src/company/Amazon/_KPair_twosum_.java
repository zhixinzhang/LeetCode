package company.Amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/7/19
 * Time: 7:39 PM
 * Description:
 * https://www.1point3acres.com/bbs/thread-518970-1-1.html
 */

//1.一个数组，找到所有相差为k的pair
//[1, 3, 4, 6, 8, 2, 9]
public class _KPair_twosum_ {
    public static void main(String[] args){
        int k = 3;
        int[] nums = new int[]{1,2,3,4,5,6};
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        for (int i : nums){
            if (set.contains(i + k))
                System.out.println(i);
        }
    }
}
