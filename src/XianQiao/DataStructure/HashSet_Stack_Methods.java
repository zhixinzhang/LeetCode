package XianQiao.DataStructure;

import java.util.HashSet;
import java.util.Stack;

public class HashSet_Stack_Methods {
    public static void main(String[] args){
        HashSet<String> set = new HashSet<>();
        System.out.println(set.isEmpty());
        set.add("I love Lord Jesus Christ!");
        set.add("Lord is my life.");
        set.add("I like GeGe too");
        if (set.contains("I love Lord Jesus Christ!")){
            System.out.println("My Lord loves me!");
        }
        set.remove("I like GeGe too");
        System.out.println(set);
        System.out.println(set.remove("a"));
        System.out.println(set.isEmpty());
        System.out.println(+ set.size());
        // what's this add sign means?
        HashSet<String> clone_set = new HashSet<>();
        clone_set = (HashSet)set.clone();
        //need explanation.
        System.out.println(clone_set);
        clone_set.clear();
        System.out.println(clone_set);
        //iterator

        Stack<String> stack = new Stack<>();
        stack.push("I");
        stack.push("love");
        stack.push("luke");
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.pop();
        stack.push("lord");
        System.out.println(stack);
        System.out.println(stack.empty());
        System.out.println(stack.search("I"));
        System.out.println(stack.search("luke"));
    }
}
