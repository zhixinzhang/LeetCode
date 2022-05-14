package SystemDesign;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/19/19
 * Time: 9:25 PM
 * Description:
 * https://www.1point3acres.com/bbs/thread-518132-1-1.html
 *
 * 1. design hash map with customized key object
 * 第一题hashmap的key需要重写equals()和hashCode().因为hashmap对于相同值的keys（不同的objects 但是里面的data fields有相同的值），
 * 应该有相同的hashCode().这样hashmap才能把相同值的keys，通过hash function映射到同一个存储空间。-
 *
 * hashcode  对比 两个key的地址
 */


public class Fruit_HashMap_Override {
    static class Fruit{
        private String name;
        private int price;
        public String id;

        public Fruit(String name, int price, String id){
            this.name = name;
            this.price = price;
            this.id = id;
        }
        @Override
        public int hashCode(){
            return id != null ? id.hashCode() : 0;
        }
        @Override
        public boolean equals(Object o){
            if (o instanceof Fruit){
                Fruit f = (Fruit) o;
                return f.name.equals(this.name) && f.price == this.price && f.id.equals(this.id);

            }
            return false;
        }

    }
    public static void main(String[] args){
        Fruit f1 = new Fruit("apple", 1, "1");
        Fruit f2 = new Fruit("apple", 1, "1");

        HashMap<Fruit, String> hm = new HashMap<>();
        hm.put(f1, "111");
        hm.put(f2, "222");

        for (Fruit fff : hm.keySet()){
            System.out.println(hm.get(fff));
        }

    }
}
