package Company.Atlassian;
import java.util.*;

// O(n) time and O(1) space - LinkedList + HashMap
public class _362_DesignHitCounter_LinkedList {
    class Entry {
        int timestamp;
        int hitcount;
        public Entry(int timestamp, int hitcount) {
          this.timestamp = timestamp;
          this.hitcount = hitcount;
        }
      }
    
      Map<Integer, Entry> map;
    
      LinkedList<Entry> entries;
    
      private int hits;
    
      public _362_DesignHitCounter_LinkedList () {
        map = new HashMap<>();
        entries = new LinkedList<>();
        hits = 0;
      }
      
      public void hit(int timestamp) {
        if (!map.containsKey(timestamp)) {
          Entry newEntry = new Entry(timestamp, 0);
          map.put(timestamp, newEntry);
          entries.addLast(newEntry);
        }
        Entry entry = map.get(timestamp);
        entry.hitcount++;
        hits++;    
      }
      
      public int getHits(int timestamp) {
        while (!entries.isEmpty() && entries.peekFirst().timestamp <= (timestamp - 300)) {
          Entry entry = entries.removeFirst();
          hits -= entry.hitcount;
        }
        return hits;
      }
}
