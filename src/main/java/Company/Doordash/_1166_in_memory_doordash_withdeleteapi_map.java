package Company.Doordash;

import java.util.HashMap;

public class _1166_in_memory_doordash_withdeleteapi_map {
    HashMap<String, Integer> map;
    public _1166_in_memory_doordash_withdeleteapi_map(){
        this.map = new HashMap<>();
    }

    public boolean create(String menu, int value){
        if(menu.length() == 0 || (menu.length() == 1 && menu.equals("/")) || map.containsKey(menu)) return false;
        int delim = menu.lastIndexOf("/");
        String parent = menu.substring(0, delim);
        if(parent.length() > 1 && !map.containsKey(parent)) return false;
        map.put(menu, value);
        return true;
    }

    public boolean delete(String menu){
        if(menu.length() == 0 || (menu.length() == 1 && menu.equals("/")) || !map.containsKey(menu)) return false;
        int delim = menu.indexOf("/");
        String children = menu.substring(delim, menu.length());
        if(children.length() > 1 && map.containsKey(children)) return false;
        map.remove(menu);
        return true;
    }

    public int get(String menu){
        return map.getOrDefault(menu, -1);
    }
}
