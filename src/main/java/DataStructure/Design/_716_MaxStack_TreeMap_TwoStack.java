package DataStructure.Design;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/10/19
 * Time: 4:07 PM
 * Description:
 *
 * https://www.1point3acres.com/bbs/thread-519628-1-1.html
 */


public class _716_MaxStack_TreeMap_TwoStack {
    // TreeMap O(log n) time
    class Node{
        int val;
        Node prev;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
    class DoubleLinkedList{
        Node head, tail;
        public DoubleLinkedList(){
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }
        public Node add(int val) {
            Node x = new Node(val);
            x.next = tail;
            x.prev = tail.prev;
            tail.prev = tail.prev.next = x;
            return x;
        }
        public int pop() {

            return unlink(tail.prev).val;
        }

        public int peek() {
            return tail.prev.val;
        }

        public Node unlink(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }
    }


    class MaxStackT{
        TreeMap<Integer, List<Node>> map;
        DoubleLinkedList ddl;
        public MaxStackT(){
            map = new TreeMap<>();
            ddl = new DoubleLinkedList();
        }

        public void push(int x) {
            Node node = ddl.add(x);
            if(!map.containsKey(x))
                map.put(x, new ArrayList<>());
            map.get(x).add(node);
        }
        public int top() {
            return ddl.peek();
        }

        public int peekMax() {

            return map.lastKey();

        }

        public int pop() {
            int res = ddl.pop();
            List<Node> list = map.get(res);
            list.remove(list.size()-1);
            if (list.isEmpty())
                map.remove(res);
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


    // two stack O(n) time
    class MaxStack{
        Stack<Integer> stack;
        Stack<Integer> maxStack;

        public MaxStack() {
            stack = new Stack();
            maxStack = new Stack();
        }

        public void push(int x) {
            int max = maxStack.isEmpty() ? x : maxStack.peek();
            maxStack.push(max > x ? max : x);
            stack.push(x);
        }

        public int pop() {
            maxStack.pop();
            return stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            int max = peekMax();
            Stack<Integer> buffer = new Stack();
            while (top() != max)
                buffer.push(pop());
            pop();
            while (!buffer.isEmpty())
                push(buffer.pop());
            return max;
        }
    }
}
