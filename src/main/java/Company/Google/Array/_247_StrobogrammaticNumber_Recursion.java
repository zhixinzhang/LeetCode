package Company.Google.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/6/30.
 * 返回条件  彼此之间的参数影响****
 *
 *
 */
public class _247_StrobogrammaticNumber_Recursion {
    public List<String> findStrobogrammatic(int n) {
        char[] c = new char[n];
        List<String> res = new ArrayList<>();
        helper(c,0,n-1,res);
        return res;
    }
    public void helper(char[] c, int l, int r, List<String> res){
        // return condition
        if(l > r){
            res.add(new String(c));
            return;
        }
        if(l == r){             // upside down 0 1 8
            c[l] = '0'; res.add(new String(c));
            c[l] = '1'; res.add(new String(c));
            c[l] = '8'; res.add(new String(c));
            return;
        }
        if(l != 0){
            c[l] = '0';c[r] = '0'; helper(c,l+1,r-1,res);
        }

        c[l] = '1'; c[r] = '1'; helper(c,l+1,r-1,res);
        c[l] = '6'; c[r] = '9'; helper(c,l+1,r-1,res);
        c[l] = '9'; c[r] = '6'; helper(c,l+1,r-1,res);
        c[l] = '8'; c[r] = '8'; helper(c,l+1,r-1,res);

        return;
    }
}
