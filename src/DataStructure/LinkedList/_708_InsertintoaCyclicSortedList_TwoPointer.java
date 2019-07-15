package DataStructure.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/30/19
 * Time: 3:09 PM
 * Description:
 * https://leetcode.com/problems/insert-into-a-cyclic-sorted-list/
 */


public class _708_InsertintoaCyclicSortedList_TwoPointer {
//    public Node insert(Node head, int val) {
//        Node node = new Node(val);
//
//        if(head == null) {
//            node.next = node;
//            return node;
//        }
//
//        Node pre = head;
//        Node next = head.next;
//
//        while(next != head) {
//
//            if(( val < next.val && pre.val <= val)           // e.g [1 -> 3] with val=1 or 2      (same as pre OR between pre and next)
//                    || (pre.val <= val && pre.val > next.val )   // e.g [3 -> 1] with val=3 or higher (same as pre OR higher than pre)
//                    || (pre.val > next.val && val <= next.val )){// e.g [3 -> 1] with val=1 or lower  (same as next OR lower than next)
//                break;
//            }
//            pre = next;
//            next = next.next;
//        }
//
//        pre.next = node;
//        node.next = next;
//        return head;
//    }
}
