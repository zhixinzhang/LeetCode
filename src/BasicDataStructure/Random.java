package BasicDataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luke(New Man) Zhang
 * @Date 2/5/2021 12:41 AM
 * <p>
 * Description:
 * Similar task :
 * Key Point:
 */

public class Random {
    List<Integer> ans = new ArrayList<>();
    java.util.Random random = new java.util.Random();
    int a = random.nextInt(ans.size());

    // NOTE: Usually this should be a field rather than a method
    // variable so that it is not re-seeded every call.
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int max = 10, min = 5;
    int randomNum = rand.random.nextInt((max - min) + 1) + min;

}
