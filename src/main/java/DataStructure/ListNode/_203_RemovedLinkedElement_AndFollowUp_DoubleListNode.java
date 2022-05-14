package DataStructure.ListNode;

import DataStructure.LinkList.ListNode;
import google.LinkedNode.DoubleListNode;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description:
 * Key Point:
 */

public class _203_RemovedLinkedElement_AndFollowUp_DoubleListNode {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
//        head.next = new ListNode(3);
//        head.next.next = new ListNode(5);
//        head.next.next.next = new ListNode(7);
        removeElements(head, 1);

//        DoubleListNode root = new DoubleListNode(1);
//        root.next = new DoubleListNode(2);
//        root.next.next = new DoubleListNode(3);
//        root.next.next.next = new DoubleListNode(4);
//
//        root.next.prev = root;
//        root.next.next.prev = root.next;
//        root.next.next.next.prev = root.next.next;
//        remove(root,3);
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode pointer = head;
        while (pointer.next != null){
            if (pointer.next.val == val){
                pointer.next = pointer.next.next;
            }else {
                pointer = pointer.next;
            }
        }

        return head.val == val ? head.next : head;
    }


    // follow up :
    public static DoubleListNode remove(DoubleListNode head, int target){
        if (head == null) return null;
        DoubleListNode point = head;

        while (point.next != null){
            if (point.next.val == target){
                point.next = point.next.next;
                point.next.prev = point;
            }else {
                point = point.next;
            }
        }
        return head;
    }
}
