package google;
import java.util.*;
/**
 * Created by zhang on 2018/5/30.
 * 基本是一遍过 我还是很棒的
 * 记住 不能存 0 和 当前的key
 */
public class _841_KeysandRooms_BFS {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // 0       1      2   3
        //[[1,3],[3,0,1],[2],[0]]
        if(rooms.size() <= 1) return true;
        HashSet<Integer> hs = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> keys = rooms.get(0); // 1 2
        for(int key : keys){
            if(!hs.contains(key) && key != 0){
                q.add(key);     // 1 3
                hs.add(key);    // 1 3
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int c = q.poll();
                List<Integer> keyss = rooms.get(c);
                for(int key : keyss){
                    if(!hs.contains(key) && key != c && key != 0){
                        q.add(key);
                        hs.add(key);
                    }
                }
            }
        }
        if(hs.size() != rooms.size()-1)
            return false;
        return true;
    }
}
