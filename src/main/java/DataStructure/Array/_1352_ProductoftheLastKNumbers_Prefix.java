package DataStructure.Array;
import java.util.*;

public class _1352_ProductoftheLastKNumbers_Prefix {
    final List<Integer> list;
    int lastProduct;
    public _1352_ProductoftheLastKNumbers_Prefix() {
        this.list = new ArrayList<Integer>();
        lastProduct = 1;
    }
    
    public void add(int num) {
        if(num == 0){
            list.clear();
            lastProduct = 1;
        }    
        else{
            lastProduct = lastProduct * num;
            list.add(lastProduct);
        }
    }
    
    public int getProduct(int k) {
        int idx = list.size() - k;
        if(idx > 0){
            return lastProduct / list.get(idx - 1);
        }
        if(idx == 0){
            return lastProduct;
        }
        return 0;
    }
}
