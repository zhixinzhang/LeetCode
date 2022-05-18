package Company.LinkedIn;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 5/17/2022 11:05 PM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class _716_MaxStack_TreeMap_DoubleLinkedList_TwoStack {
    // TreeMap o(logN) time
    class Node {
        int val;
        Node prev;
        Node next;
        public Node(int v){
            this.val = v;
        }
    }

    class DoubleLinkedList {
        Node head, tail;

        public DoubleLinkedList(){
            head = new Node(0);
            tail = new Node(0);

            head.next = tail;
            tail.prev = head;
        }

        public Node add(int val) {
            Node node = new Node(val);
            node.next = tail;
            node.prev = tail.prev;
            tail.prev = tail.prev.next = node;
            return node;
        }

        public int pop(){
            return unlink(tail.prev).val;
        }

        public int peek(){
            return tail.prev.val;
        }

        public Node unlink(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }
    }

    public class MaxStackTreeMap{
        TreeMap<Integer, List<Node>> map;
        DoubleLinkedList ddl;

        public MaxStackTreeMap(){
            map = new TreeMap<>();
            ddl = new DoubleLinkedList();
        }

        public void push(int x){
            Node node = ddl.add(x);
            if(!map.containsKey(x))
                map.put(x, new ArrayList<>());
            map.get(x).add(node);
        }

        public int top(){
            return ddl.peek();
        }

        public int peekMax(){
            return map.lastKey();
        }

        public int pop(){
            int res = ddl.pop();
            List<Node> list = map.get(res);
            list.remove(list.size() - 1);
            if (list.isEmpty()){
                map.remove(res);
            }
            return res;
        }

        public int popMax() {
            int max = peekMax();
            List<Node> L = map.get(max);
            Node node = L.remove(L.size() - 1);
            ddl.unlink(node);
            if (L.isEmpty()) map.remove(max);
            return max;
        }

    }


    // Two Stack O(N) time
    public class MaxStackTwoStack {
        Stack<Integer> stack;
        Stack<Integer> maxStack;

        public MaxStackTwoStack(){
            stack = new Stack<>();
            maxStack = new Stack<>();
        }

        public void push(int x){
            stack.push(x);
            int max = maxStack.isEmpty() ? x : maxStack.peek();
            maxStack.push(max > x ? max : x);
        }

        public int pop(){
            maxStack.pop();
            return stack.pop();
        }

        public int top(){
            return stack.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax(){
            int max = peekMax();
            Stack<Integer> buffer = new Stack<>();
            while (top() != max){
                buffer.push(pop());
            }
            pop();

            while (!buffer.isEmpty()) {
                push(buffer.pop());
            }
            return max;
        }
    }
}
