package DataStructure.Integer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/18/19
 * Time: 10:35 AM
 * Description:
 */


public class _970_PowerfulIntegers_Math_Set {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i <= (x == 1 ? 0 : Math.log(bound) / Math.log(x)); i++) {
            for(int j = 0; j <= (y == 1 ? 0 : Math.log(bound) / Math.log(y)); j++) {
                int powerful = ((int) Math.pow(x, i)) + ((int) Math.pow(y, j));
                if(powerful <= bound) s.add(powerful);
            }
        }
        return new ArrayList<>(s);
    }
}
