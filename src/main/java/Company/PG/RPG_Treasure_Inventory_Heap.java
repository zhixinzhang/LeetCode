package Company.PG;
import java.util.*;
/**
 * Created by zhang on 2018/1/27.
 * You’re playing your favorite RPG, and your character has just found a room full of treasure.
 * You have n inventory slots. Luckily, objects of the same type stack together, with the maximum size
 * of the stack depending on the type (e.g. coins might stack to 10, diamonds to 5, armor to 1, etc.). Each stack (or partial stack) takes up 1 inventory slot.
 * Each item has a selling value (e.g. a single diamond might be worth 10, so a stack of 5 diamonds would be worth 50).
 * You want to maximize the total selling value of the items in your inventory.
 */
//O(nlogk)
// like top K problem i maintance a minheap
public class RPG_Treasure_Inventory_Heap {
    public static void main(String[] args) {
        ItemInfo[] infors = new ItemInfo[3];
        infors[0] = new ItemInfo("diamond", 10, 5);
        infors[1] = new ItemInfo("ruby", 5, 5);
        infors[2] = new ItemInfo("armor", 25, 1);
        String[] items = {"diamond", "ruby", "armor", "diamond", "diamond", "ruby", "diamond",
                "diamond", "diamond", "diamond", "diamond", "armor"};
        // diamond 8 10
        // armor  2 25
        // ruby 2  10
        System.out.println(solve_maxValue(3, items, infors));
    }

    public static int solve_maxValue(int n, String[] items, ItemInfo[] infos) {
        if (infos == null || infos.length == 0 || items == null || items.length == 0) return 0;
        Map<String, Integer> values = new HashMap<>();
        Map<String, Integer> size = new HashMap<>();
        Map<String, Integer> frequency = new HashMap<>();
        for (ItemInfo info : infos) {
            values.put(info.name, info.value);
            size.put(info.name, info.max_stack_size);
        }
        for (String item : items) {
            int count = frequency.getOrDefault(item, 0);
            frequency.put(item, count + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            int f = entry.getValue();
            int stackSize = size.get(entry.getKey());
            int value = values.get(entry.getKey());
            while (f != 0) {
                if (f >= size.get(entry.getKey())) {
                    pq.add(stackSize * value);
                    f -= size.get(entry.getKey());
                } else {
                    pq.add(value * f);
                    f = 0;
                }
                if (pq.size() > n) pq.poll();
            }
        }
        int max = 0;
        while (!pq.isEmpty()) max += pq.poll();
        return max;
    }
    static class ItemInfo {
        String name;
        int value;
        int max_stack_size;
        public ItemInfo(String name, int value, int max) {
            this.name = name;
            this.value = value;
            this.max_stack_size = max;
        }
    }


    public static int solve_maxSize(){
        return 0;
    }
}
