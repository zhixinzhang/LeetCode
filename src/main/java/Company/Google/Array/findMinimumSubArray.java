package Company.Google.Array;

import java.util.Arrays;

/**
 * Created by zhang on 2018/6/10.
 * 1.黑哥哥
 input: 一些字符串words， 一个目标字符串， 要求返回words里 包含了所有目标字符串里的所有char 的词中最短的那个。
 eg:  words = [study, haha, stone, school, star, store]  target = "rts", 需要返回 的词是star, 因为star 包含了所有rts, 同时也是最短。
 .本文原创自1point3acres论坛
 follow-up: 多种方法优化这道题的方法， 楼主先排序 （要求写出查找的平均时间复杂度），
 楼主还答了可以把words 存成 s: study, stone, school, star, stor; t : star, stone, store..... 这样的map, 好处是我们查找的时候只需要看target里出现过的char所对应的词，
 然后找并集，在目标字符串很小的情况下有可能会省很多时间。
 */

/**很经典的一道题
 * 我的思路 array.sort input 的 stings 根据 sting的length O（nlogn）
 * new int[26] 存储target每个对应的 char 同时记录 target有多少个字符
 * 遍历每一个 string， 每次找到一个一样的char 在target里 并且 不为空 那么就计算 同时count--
 * 当便利结束 或者count == 0 直接返回
 * **/
public class findMinimumSubArray{
    public static String solution(String[] strings, String target){
            int[] carry = new int[26];
            int count = 0;
            for (char c : target.toCharArray()){
                carry[c-'a'] ++;
                count++;
            }
//            Arrays.sort(strings);
            Arrays.sort(strings,(a,b)->(a.length() - b.length()));
            for (String s : strings){
                int[] temp = carry;
                if (s.length()>=target.length()){
                    for (char c : s.toCharArray()){
                        if (temp[c - 'a'] > 0){
                            temp[c-'a'] --;
                            count--;
                            if (count == 0)
                                return s;
                        }
                    }

                }
            }
            return "";
    }
    public static void main(String[] args){
        solution(new String[]{"study", "haha", "stone", "school", "star", "store"},"rts");
    }
}
