package Company.Turo;
import java.util.*;

class CarData {
    private final String attribute1;

    private final Long attribute2;

    public CarData(String attribute1, Long attribute2) {
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public Long getAttribute2() {
        return attribute2;
    }
    
}

class Node {
    public String key;    // vin 
    public CarData value; // carData
    Node pre;
    Node next;

    public Node(String key, CarData value) {
        this.key = key;
        this.value = value;
    }
}

class CarDataCache {

    // other members ...

    /**
     * Constructor. Initialize a new cache.
     */

    int mapFlagSize = 1000000;
    Map<String, Node> carDataMap;   // O(1000000) CarData 
    Node head, tail;            // LinkedListNode ->  O(1000000)  N Space   O (1) time complexity  
    public CarDataCache() {
      carDataMap  = new HashMap<>();
      head.next = tail;
      tail.pre = head;
      head.pre = null;
      tail.next = null;
        // ...
    }

    /**
     * Get the data stored in the cache for the specified VIN.
     *
     * @param vin unique VIN (car identification number) for car
     * @return string data representing car data
     */
    public CarData get(String vin) {
        if (carDataMap.get(vin) != null){
          Node node = carDataMap.get(vin);
          deleteNode(node);
          addToHead(node);
          return node.value;
        }
        
        // TODO  DB query
        // if (db.query(vin)){
        //   put(vin, carData);
        //   return res;
        // }


        return null;
        // ...
    }

    /**
     *  LRU 
     * Set the data stored in the cache for the specified VIN.
     *
     * @param vin unique VIN for car
     */
    public void put(String vin, CarData data) {
        if (carDataMap.get(vin) != null){    // vin exist
            Node node = carDataMap.get(vin);
            node.value = data;
            deleteNode(node);
            addToHead(node);
        } else {                               // TODO  
            Node node = new Node(vin, data);      // vin not exist
            carDataMap.put(vin, node);
            if (carDataMap.size() >= mapFlagSize){
              carDataMap.remove(tail.pre.key);
              deleteNode(tail.pre);
              addToHead(node);
            }
        }
    }

    public void deleteNode(Node node){
       node.pre.next = node.next;
       node.next.pre = node.pre;
    }

    public void addToHead(Node node){
       node.next = head.next;
       node.next.pre = node;
       node.pre = head;
       head.next = node;
    }
}

class LRUCarDataCache {
    public static void main(String[] args) {
        // Sample usage
        CarDataCache cache = new CarDataCache();
        cache.put("SCBCP73W98C038423",new CarData("attribute1",1L));
        cache.get("SCBCP73W98C038423");
    }
}
