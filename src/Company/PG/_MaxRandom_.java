package Company.PG;

/**
 * Created by zhang on 2018/1/29.
 */
public class _MaxRandom_ {
    public int getMaxRandom(int val){
        return (int) Math.random()*val;
    }
    public int solve(int val){
        int res = getMaxRandom(val);
        while (res >= val){
            res = getMaxRandom(val);
        }
        return res;
    }
}
