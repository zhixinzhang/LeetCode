package Company.Revel;
import java.util.*;

public class _JsonSimple_Map {
    public static void main(String[] args) {
        String test =   
                        "\"K1\":V1\n" +
                        "\"K2\":V2\n";
        
        find(test);
    }
    private static void find(String message){
        Map<String, String> map = new HashMap<>();
        String[] arrs = message.split("\n");
        for (String s : arrs){
            String[] parts = s.split(":");
            String key = parts[0];
            key = key.replaceAll("\"", "");
            map.put(key, key);
            key = key.substring(0, key.length() - 1);
            System.out.println("our key is : " + key);
        }
    }          
}
