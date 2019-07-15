package company.Houzz;

/**
 * Created by zhang on 2018/1/16.
 */
public class HammingDistance {
    public int hammingDistance_O(int x, int y) {
        if (x == y) return 0;
        int res = 0;
        for(int i = 0; i<31;i++){
            int bx = x % 2;                 // 8     1001
            int by = y % 2;                 // 6     0110
            if(by != bx) res++;
            x = x/2;
            y = y/2;  // 6 3 1 0
        }
        return res;
    }
}
