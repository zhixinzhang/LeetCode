package DataStructure.Design;

import java.util.ArrayList;

/**
 * @author Luke Zhang
 * @Date 2021-05-30 00:22
 */
public class _1352_ProductOfTheLastKNumbers_Prefix {
    ArrayList<Integer> A = new ArrayList(){{
        add(1);
    }};

    public void add(int a) {
        if (a > 0)
            A.add(A.get(A.size() - 1) * a);
        else {
            A = new ArrayList();
            A.add(1);
        }
    }

    public int getProduct(int k) {
        int n = A.size();
        return k < n ? A.get(n - 1) / A.get(n - k - 1)  : 0;
    }
}
