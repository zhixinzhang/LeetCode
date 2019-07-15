package google;
import java.util.*;
/**
 * Created by zhang on 2018/5/22.
 */
//正常的 recursion会time out
// 重点是找到规律  ty 永远都是来自
//In each recursive call, if tx > ty, it should derive from (tx % ty, ty), otherwise, from (tx, ty % tx) because the bigger one must come from last transformation from
// (tx - ty, ty) or (tx, ty - tx) until it is less than the smaller number.
public class _780_ReachingPoints{
        public boolean reachingPoints_recur(int sx, int sy, int tx, int ty) {
            if (sx > tx || sy > ty) return false;
            if (sx == tx && (ty - sy) % sx == 0) return true;
            if (sy == ty && (tx - sx) % sy == 0) return true;
            return reachingPoints_recur(sx, sy, tx % ty, ty % tx);
        }
    // 2 3  -----   25 52  27 72


    // time execced
    public static boolean reachingPoints_Iterarto(int sx, int sy, int tx, int ty) {
        Queue<int[]> q = new LinkedList<>();
        // sx + sy > tx + ty
        q.add(new int[]{sx,sy});
        // 9 5   12 8
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] cur = q.poll();
                sx = cur[0];
                sy = cur[1];
                int sx1 = sx+sy;
                int sy1 = sx+sy;
                if(sx > tx && sy>ty)
                    continue;
                if((sx1 == tx && sy == ty) || (sx == tx && sy1 == ty))
                    return true;
                q.add(new int[]{sx,sy1});
                q.add(new int[]{sx1,sy});
            }
        }
        return false;
    }
    public static void main(String[] args){
        reachingPoints_Iterarto(9,5,12,8);
    }
}
