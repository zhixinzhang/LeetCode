package DataStructure.LinkList;

/**
 * Created by zhang on 2017/9/25.
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)
 */

public class _138_CopyListWIthRandomPointer {
//    public RandomListNode copyRandomList(RandomListNode head) {
//        if (head == null) return null;
//
//        Map<Node, Node> map = new HashMap<Node, Node>();
//
//        // loop 1. copy all the nodes
//        Node node = head;
//        while (node != null) {
//            map.put(node, new Node(node.val));
//            node = node.next;
//        }
//
//        // loop 2. assign next and random pointers
//        node = head;
//        while (node != null) {
//            map.get(node).next = map.get(node.next);
//            map.get(node).random = map.get(node.random);
//            node = node.next;
//        }
//
//        return map.get(head);
//
//    }
}
