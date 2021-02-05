package Company.uber;

import java.util.HashMap;

/**
 * Created by zhang on 2018/9/10.
 * follow up 多线程处理
 */
public class _359_LoggerRateLimiter_HM_ {
    public static void main(String[] args){
        Logger log = new Logger();
    }
    static class Logger{
        HashMap<String, Integer> hm;
        public void Logger(){
            hm = new HashMap<>();
        }
        public boolean add(int time, String message){
            if (!hm.containsKey(message)){
                hm.put(message, time);
                return true;
            }else {
                int last = hm.get(message);
                if (time - last > 10){
                    hm.put(message, time);
                    return true;
                }else
                    return false;
            }
        }
    }
}
