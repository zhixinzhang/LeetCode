package Company.uber;

import java.util.*;

/**
 * Created by zhang on 2018/9/7.
 *
 * 这题是 528 基本一样
 */

// BinarySearch
class Fruit{
    public int weight;
    public String name;
    Fruit(int weight, String name){
        this.weight = weight;
        this.name = name;
    }
}

public class _fruitWeight_ {
    public static void main(String[] args){
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit(1,"apple"));
        list.add(new Fruit(5,"banana"));
        list.add(new Fruit(3,"orange"));
        list.add(new Fruit(2,"a"));
        list.add(new Fruit(4,"b"));
        getRandom(list);
        Collections.sort(list,(a, b)->(a.weight - b.weight)); // O(n * log n) + m * log n
        Fruit cur = getWeight(list, 2);
        if (cur == null)
            System.out.print("not exist fruit");
        else
            System.out.println("we find out fruit: " + cur.name);
    }
    public static Fruit getRandom(List<Fruit> fruits){
        Random r = new Random();
        int idx = r.nextInt(fruits.size()); // num from 0 - fruits.size() - 1
//        int c = r.nextInt(1);
        return fruits.get(idx);
    }

    // binary search  -> O(log n)
    public static Fruit getWeight(List<Fruit> fruits, int target){
        int l = 0;
        int r = fruits.size() - 1;
        if (fruits.size() == 0 || fruits.get(l).weight > target || fruits.get(r).weight < target)
            return null;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (fruits.get(mid).weight == target)
                return fruits.get(mid);
            else if (fruits.get(mid).weight < target)
                l = mid+1;
            else if (fruits.get(mid).weight > target)
                r = mid - 1;
        }
        return null;
    }
}
