package DataStructure.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/13/19
 * Time: 12:12 PM
 * Description:
 *
 * 把牌按照上面写的数字分组计数（counter），将counter排序，为了找到最小的两个计数。如果最小的计数小于2，也就是牌堆只有一张牌，则不存在大于等于2的X，返回FALSE。如果counter只有一个值，也就是只有一种数字的牌，通过了前面的条件这张牌的张数就不小于2，至少可以按照要求分成1组，返回True。接下来是复杂一点的地方，如果counter前两个计数的最大公约数，是后续所有计数的一个约数，那么就返回True，否则返回False。
 * ---------------------
 * 作者：疯琴
 * 来源：CSDN
 * 原文：https://blog.csdn.net/qq_35753140/article/details/83687870
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */


public class _914_XofaKindinaDeckofCards_MAP {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length <= 1)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : deck) map.put(i, map.getOrDefault(i,0)+1);
//        for (int i : map.keySet()){}
        for (int i : map.values()){
            res = gcd(i,res);
        }
        return res > 1;
    }
    public int gcd(int a, int b){
        return b > 0 ? gcd(b, b % a) : a;
    }
}
