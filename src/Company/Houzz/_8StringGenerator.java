package Company.Houzz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Created by zhang on 2018/1/19.
 */
//写一个生成8位String的生成器，要求在A-Z，a-z，0-9，%$&#里挑，每组至少选一个
public class _8StringGenerator {
    public static void main(String[] args){
        for (int i = 0; i<1000;i++)
            System.out.println(random(8));
    }
    public static String random(int len){
            String upLetter = "abcdefghizklmnopqrstuvwxyz";
            String special = "%$&#";
            String num = "123456789";
            List<String> list = new ArrayList<>();
            list.add(upLetter.toUpperCase());
            list.add(upLetter);
            list.add(special);
            list.add(num);
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            int max = 25;
//            sb.append(upLetter.charAt(random.nextInt(max)));
//            sb.append(String.valueOf(upLetter.charAt(random.nextInt(max))).toUpperCase());
//            sb.append(random.nextInt(9));
//            char a = special.charAt(random.nextInt(3));
//            sb.append(special.charAt(random.nextInt(3)));
            int restLen = len;
            int resType = 4;
            HashSet<Integer> hs = new HashSet<>();
            //5 1 1 1
           // 4 2 1 1
           // 3 3 1 1
            int i = 0;
            while (i <= 7){
                int next = random.nextInt(4);
                while (hs.contains(next)){
                    if (resType < len - i)
                        break;
                    else
                        next = random.nextInt(4);
                }
                if (!hs.contains(next))
                    resType--;
                hs.add(next);
                String randomStr = list.get(next);
                sb.append(randomStr.charAt(random.nextInt(randomStr.length())));
                i++;
            }
            return sb.toString();
    }
}
