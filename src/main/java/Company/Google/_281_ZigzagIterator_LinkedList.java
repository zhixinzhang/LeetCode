package Company.Google;
import java.util.*;
/**
 * Created by zhang on 2018/5/13.
 */
/**
 * 用一个queue（也就是linkedlist） 里面放整个list 比如v1
 * 每次才做 抛出v1 判断是否为空 然后再加入
 * 很有意思的一道题
 *
 * follow up  多个list
 * */
public class _281_ZigzagIterator_LinkedList {

    // follow up 多个list
    List<List<Integer>> lists = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();
    public void ZigzagIterator_2(List<Integer> v1, List<Integer> v2) {
        lists.add(v1);
        lists.add(v2);
        int max = v1.size() > v2.size() ? v1.size() : v2.size();
        for(int i = 0; i < max; i++){
            for(List<Integer> list : lists){
                if(list.size() > i) q.add(list.get(i));
            }
        }

    }

    public int next_() {
        return q.poll();
    }

    public boolean hasNext_() {
        return !q.isEmpty();
    }
}
