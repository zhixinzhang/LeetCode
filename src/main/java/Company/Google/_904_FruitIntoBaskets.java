package Company.Google;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/2/19
 * Time: 5:24 PM
 * Description:
 *  * sliding window  看看这个 很有启发
 * https://leetcode.com/problems/fruit-into-baskets/discuss/170745/Problem%3A-Longest-Subarray-With-2-Elements
 */


public class _904_FruitIntoBaskets {
    public static void main(String[] args){
        int[] tree = new int[]{3,3,1,1,2,1,1,2,3,3,4};
        totalFruit_twopointer(tree);
    }

    // brute force O(n^2)
    public static int totalFruit(int[] tree) {
        int res = 0;
        if(tree == null)
            return 0;
        if(tree.length <= 2)
            return tree.length;
        HashSet<Integer> cache = new HashSet<>();
        for (int i = 0; i < tree.length; i++){
            int total = 0;
            for (int j = i; j<tree.length; j++){
                if (!cache.contains(tree[j]) && cache.size() >= 2){
                    res = Math.max(res, total);
                    cache.clear();
                    break;
                }
                else{
                    total++;
                    cache.add(tree[j]);
                }
            }
        }
        return res;
    }

    public int totalFruit_slidingwindow(int[] tree) {
        int res = 0, cur = 0, count_b = 0, a = 0, b = 0;
        for (int c :  tree) {
            cur = c == a || c == b ? cur + 1 : count_b + 1;
            count_b = c == b ? count_b + 1 : 1;
            if (b != c) {a = b; b = c;}
            res = Math.max(res, cur);
        }
        return res;
    }

    // 思路对 但是code很不好
    public static int totalFruit_twopointer(int[] tree) {
        HashMap<Integer, int[]> val_ind = new HashMap<>();
        if (tree == null)   return 0;
        if(tree.length <= 2) return tree.length;
        int left = -1, right = -1, res = 0, total = 0;
        for (int i = 0; i < tree.length; i ++){
            int curVal = tree[i];
            if (val_ind.size() >= 2 && !val_ind.containsKey(curVal)){
                res = Math.max(res, total);
                int[] idxL = val_ind.get(left);
                int[] idxR = val_ind.get(right);
                if (idxL[1] < idxR[1]){
                    total = idxR[1] - idxR[0] + 1;
                    val_ind.remove(left);
                    left = curVal;
                }
                else{
                    total = idxL[1] - idxL[0] + 1;
                    val_ind.remove(right);
                    right = curVal;
                }
                val_ind.put(curVal, new int[]{i,i});
            }else {
                total++;
                if (!val_ind.containsKey(curVal)){
                    val_ind.put(curVal, new int[]{i,i});
                    if (left == -1)
                        left = curVal;
                    else if (right != curVal)
                        right = curVal;
                }else if (val_ind.size() == 1){
                    int[] idxs = val_ind.get(curVal);
                    idxs[1] = i;
//                    val_ind.put(curVal,idxs);
                } else {
                    int[] another;
                    int[] idxs = val_ind.get(curVal);
                    if (curVal == left)
                        another = val_ind.get(right);
                    else
                        another = val_ind.get(left);
                    idxs[1] = i;
                    if (another[1] < idxs[1] && another[1] > idxs[0]){
                        idxs[0] = another[1]+1;
                        val_ind.put(curVal, idxs);
                    }
                    else
                        val_ind.put(curVal, idxs);
                }
            }
        }
        return res;
    }
}
