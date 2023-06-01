package Company.Square.OOP;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CacheTTL {
    class Object {
        String name;
        long time; 
        
        public Object(long time, String name){
            this.name = name;
            this.time = time;
        }
    }
    private Map<String, String> cache = new HashMap<>();
    private PriorityQueue<Object> queue = new PriorityQueue<Object>(new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
                long t1 = (long) o1.time;
                long t2 = (long) o2.time;
                if(t1 < t2)
                    return -1;
                if(t1 > t2)
                    return 1;
                return 0;
        }
    }); 
        
     
    public String get(String key) {
        removeExpiredCacheKeys();
        return cache.getOrDefault(key, "");
    }

    public void put(String key, String value, int ttl) {
        cache.put(key, value);
        queue.add(new Object(getCurrentTimeInMillisecs() + ttl, key));
    }
    public void delete(String key) {
        cache.remove(key);
    }
     private void removeExpiredCacheKeys(){
        while(!queue.isEmpty() && (long) queue.peek().time <= getCurrentTimeInMillisecs()){
            cache.remove(queue.remove().name);
        }
    }

     private long getCurrentTimeInMillisecs(){
        return System.currentTimeMillis();
     }
}
