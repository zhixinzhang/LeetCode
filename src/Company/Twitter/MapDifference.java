package Company.Twitter;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 6/14/2021 1:38 PM
 * <p>
 * Source Link:
 * <p> https://www.1point3acres.com/bbs/thread-770290-1-1.html
 * https://www.1point3acres.com/bbs/thread-692386-1-1.html
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class MapDifference {

    static Map<String, String> itemOnlyInMapOne;
    static Map<String, String> itemOnlyInMapTwo;
    static Map<String, String> differentEntriesMap;

    public MapDifference(){
        this.itemOnlyInMapOne = new HashMap<>();
        this.itemOnlyInMapTwo = new HashMap<>();
        this.differentEntriesMap = new HashMap<>();
    }

    public List<String> getAllDifference(){
        return new ArrayList<>(differentEntriesMap.keySet());
    }

    public static void addItem(String key, String value){
        if (!itemOnlyInMapOne.containsKey(key)){
            if (!itemOnlyInMapTwo.containsKey(key)){
                itemOnlyInMapOne.put(key, value);
            } else {
                itemOnlyInMapTwo.put(key, value);
            }
        } else {
            if (itemOnlyInMapTwo.containsKey(key) && !itemOnlyInMapTwo.get(key).equals(itemOnlyInMapOne.get(key))) {
                differentEntriesMap.put(key, value);
            } else if (!itemOnlyInMapTwo.containsKey(key)) {
                itemOnlyInMapOne.put(key, value);
            }
        }
    }

    public static String getValue(String key) throws Exception{
        if (itemOnlyInMapOne.containsKey(key))
            return itemOnlyInMapOne.get(key);
        else if (itemOnlyInMapTwo.containsKey(key))
            return itemOnlyInMapTwo.get(key);
        else if (differentEntriesMap.containsKey(key))
            return differentEntriesMap.get(key);

        throw new Exception(String.format("This key : %s is not exist in MapDifference", key));
    }

    public static void main(String[] args) throws Exception{
        MapDifference md = new MapDifference();

        Integer a = 1;
        if (a instanceof Integer) {
            System.out.println(a);
        }
        md.addItem("a", "a1");
        md.addItem("a", "a1");
        md.addItem("b", "b1");
        md.getValue("a");
    }
}
