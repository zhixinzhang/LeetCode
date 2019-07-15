package company.Amazon;

import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/10/19
 * Time: 6:16 PM
 * Description:
 */


public class ItemInstance_TreeMap {
    static class Item{
        String name;
        int val;
        public Item(String name, int val){
            this.name = name;
            this.val = val;
        }
    }
    public static void findItem(){
        TreeMap<Integer, Item> tm = new TreeMap<>();
        tm.put(10, new Item("A", 10));
        tm.put(9, new Item("B", 9));
        tm.put(8, new Item("C", 8));
        tm.put(7, new Item("D", 7));
        tm.put(5, new Item("E", 5));

        int a = tm.lowerKey(7);
        int c = tm.higherKey(8);
        System.out.println(a);
    }

    public static void main(String[] args){
        findItem();
    }
}
