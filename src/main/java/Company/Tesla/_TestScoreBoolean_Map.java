package Company.Tesla;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/12/2021 10:23 PM
 * <p>
 * Description:
 * Similar task :
 * Key Point: https://www.1point3acres.com/bbs/thread-657538-1-1.html
 *
 * 3. 这题好像是TESLA自己出的？题目非常的长废话很多但相对真实化～～我看了很久
 * 反正就是给两个vector<string>, 第一个是test name, 第二个是test 结果～～回传计算分数成百分制 0~100
 * 李扣本来有讨论被删除了
 */

public class _TestScoreBoolean_Map {
    public static void main(String[] args){
        String[] arrs = new String[]{"testname1a", "testname2", "testname1b"};
        boolean[] res = new boolean[]{true, true, false};
        test(arrs, res);

    }

    private static void test (String[] arrs, boolean[] res){
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < arrs.length; i++) {
            String s = arrs[i];
            boolean b = res[i];

            String a = s.replaceAll("testname", "");
            int j = 0;
            while (j < a.length()) {
                if (Character.isDigit(a.charAt(j))){
                    j++;
                } else {
                    break;
                }
            }
            String aa = a.substring(0, j);
            int val = Integer.valueOf(a.substring(0, j));

            map.putIfAbsent(val, b);  // t or f
            if (b == false) {
                map.put(val, b);
            }
        }

        int score = 0;
        int val = 100 / map.size();
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()){
            if (entry.getValue())
                score += val;
        }

        System.out.println(score);
    }
}
