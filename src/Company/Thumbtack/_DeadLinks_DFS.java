package Company.Thumbtack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Luke Zhang
 * @Date 2021-06-07 18:27
 *
 * https://www.1point3acres.com/bbs/thread-570239-1-1.html
 *
 * 3.给alive的boolean，找到相关dead links，返回全部dead
 * 比如
 * /*
 * alive = [
 *     0 => true,
 *     1 => true,
 *     2 => true,
 *     3 => true,
 *     4 => false
 * ]
 * links = [
 *     0 => [ 1, 2, 3 ],
 *     1 => [ 3 ],
 *     2 => [ 4 ],
 *     3 => [ 1 ],
 *     4 => [], // irrelevant since alive[4] = false;
 * ]
 *
 * 4是dead， 从4 根据links能推出 2也是dead，因为2指向了4， 然后又能推出0也是dead，因为0里包括了2
 * 所以最后返回
 * want to return [
 *     0 => false,
 *     1 => true,
 *     2 => false,
 *     3 => true,
 *     4 => false,
 * ]‍‌‌‌‌‍‌‍‍‌‍‌‍‌‌‍‍‍‍

 */
public class _DeadLinks_DFS {

    static boolean[] ans ;
    static HashSet<Integer> visited;
    public static void main(String[] args){
        boolean[] alive = new boolean[]{true, true, true, true, true, false};
        ans = alive;

        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Arrays.asList(1,2,3)));
        graph.add(new ArrayList<>(Arrays.asList(3)));
        graph.add(new ArrayList<>(Arrays.asList(4)));
        graph.add(new ArrayList<>(Arrays.asList(1)));
        graph.add(new ArrayList<>(Arrays.asList()));

        for (int i = 0; i < alive.length; i++){
            if (visited.add(i))
                recur(alive, graph, i);
        }

    }

    private static boolean recur(boolean[] alive, List<List<Integer>> graph, int index){

        for (int curLevel : graph.get(index)){
            if (visited.add(curLevel) && alive[curLevel]){
                recur(alive, graph, curLevel);
            }
        }
    }
}
