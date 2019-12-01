package XianQiao.DataStructure;

import java.util.HashMap;
import java.util.List;

public class Map {
    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, List<String>> mapString =  new HashMap<>();
        map.put("a", 1);
        map.put("b", 1);
        System.out.println(map.get("a"));
        map.clear();
        System.out.println(map.get("a"));

        //#5
        if (map.isEmpty()){
            System.out.println("We eat hot pot in Wangbobo's house tonight.");
        }

        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);

        //#2
        if (map.containsKey("c")){
            System.out.println(map.get("c"));
        }
        if (map.containsKey("h")){
            System.out.println(map.get("h"));
        }

        //#3
        if (map.containsValue(2)){
            System.out.println("zhangzhixinzuishuai");
        }
        if (map.containsValue(7)){
            System.out.println("I need to have dinner with wangbobo now");
        }

        //#6
        System.out.println(map.entrySet());

        //#7
        System.out.println(map.get("d"));

        //#8
        System.out.println(map.keySet());

        //#9
        System.out.println(map.size());

        //#10
        map.put("e", 5);
        System.out.println(map.entrySet());

        //#11
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.putAll(map);
        System.out.println(map2.entrySet());

        //#12
        map2.remove("e");
        System.out.println(map2.entrySet());

        //#13
        System.out.println(map.values());

        //#18
        System.out.println(map.getOrDefault("b", -1));
        System.out.println(map.getOrDefault("h", -1));

        //#20
        HashMap<String, Integer> map3 = new HashMap<>();
        map3.putIfAbsent("a", 1);
        System.out.println(map3.entrySet());

        //#22
        map.replace("e", 5, 6);
        System.out.println(map.entrySet());
    }
}
