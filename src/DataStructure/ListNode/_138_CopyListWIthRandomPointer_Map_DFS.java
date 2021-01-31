package DataStructure.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Luke(New Man) Zhang
 * @Date 1/30/2021 12:49 AM
 * <p>
 * Description:
 * Key Point:
 *  * https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)
 *
 *  Time Complexity : O(N)O(N) because we make one pass over the original linked list.
 * Space Complexity : O(N)O(N) as we have a dictionary containing mapping from old list nodes to new list nodes. Since there are NN nodes, we have O(N)O(N) space complexity.
 */

public class _138_CopyListWIthRandomPointer_Map_DFS {
    class Node{
        int val;
        Node next;
        Node random;
        public Node(int val){
            this.val = val;
        }
    }


    public Node copyRandomList_IterativeWithMap(Node head) {
        if (head == null) {
            return head;
        }

        Map<Node, Node> cache = new HashMap<>();
        // first loop, copy all nodes
        Node root = head;
        while (root != null) {
            cache.put(root, new Node(root.val));
            root = root.next;
        }

        //second loop, assign next and random pointers;
        root = head;
        while(root != null){
            cache.get(root).next = cache.get(root.next);
            cache.get(root).random = cache.get(root.random);
            root = root.next;
        }

        return cache.get(head);
    }


    // https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43488/Java-O(n)-solution
    // Solution 2 : usd dfs and hashmap
    /**
     * Clean solution, but I have some concerns when I thought about HashTables: What is RandomListNode's hashValue, is it Object's in-memory representation? Is it guaranteed to be unique for each object?
     *
     * For some followup, if the RandomListNode's a black-box, seems we cannot use this solution, cause its hash value computation is not transparent. Am I correct?
     *
     * I agree, if the Node's a black-box, we cannot use this solution because hashcode() method is unknown and we can't promise every instance has an unique hashcode.
     * but in the problem, It doesn't override hashcode(), so every node has an unique hashcode by default.
     *
     * */
    public Node copyRandomList_DFS(Node head) {
        HashMap<Node, Node> cached = new HashMap<>();
        return copyRandomList(head, cached);
    }

    private Node copyRandomList(Node head, HashMap<Node, Node> cached){
        if (head == null) {
            return null;
        }
        if (cached.containsKey(head)) {
            return cached.get(head);
        }

        Node newHead = new Node(head.val);
        cached.put(head, newHead);
        newHead.next = copyRandomList(head.next, cached);
        newHead.random = copyRandomList(head.random, cached);

        return newHead;
    }
}
