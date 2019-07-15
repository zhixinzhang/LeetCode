package company.Amazon;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/10/19
 * Time: 3:06 PM
 * Description:
 */


public class _957_PrisonCellsAfterNDays_Map {
    HashMap<int[], int[]> map = new HashMap<>();

    public int[] prisonAfterNDays(int[] cells, int N) {
        N = N % 14;
        if (N == 0) N = 14;
        // the above two lines are magic!!
        int len = cells.length;
        while(N > 0){
            int[] next = change(cells);
            if(!map.containsKey(cells)){
                map.put(cells, next);
            }
            cells = next;
            N--;
        }
        return cells;
    }

    private int[] change(int[] cells){
        int[] res = new int[cells.length];
        if(map.containsKey(cells)) return map.get(cells);

        for(int i = 1; i < cells.length - 1; i++){
            if((cells[i-1] == 0 && cells[i+1] == 0)||(cells[i-1] == 1 && cells[i+1] == 1)){
                res[i] = 1;
            }else{
                res[i] = 0;
            }
        }
        res[0] = 0;
        res[cells.length - 1] = 0;
        return res;
    }
}
