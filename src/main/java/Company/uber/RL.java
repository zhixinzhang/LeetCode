package Company.uber;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zhang on 2018/9/18.
 */
public class RL implements Limit {
    Deque<Long> queue = new LinkedList<>();
    int count = 0;
    public void setLimit(int qps){
        count = qps;
    }
    public boolean canSendRequest(){
        Long time = System.currentTimeMillis();
        if (queue.size() >= count){
            Long prev = queue.pollFirst();
            queue.addLast(time);
            if (time - prev < 1000){
                return false;
            }else
                return true;
        }
        if (queue.size() < count){
            queue.add(time);
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        RL r = new RL();
        r.setLimit(2);
        System.out.println(r.canSendRequest());
        System.out.println(r.canSendRequest());
        System.out.println(r.canSendRequest());
        System.out.println(r.canSendRequest());

    }

}
