package XianQiao.CCI;

import DataStructure.LinkList.ListNode;

/**
 * @Author: Xianqiao
 * @Date: 6/17/20 14:50
 */

/** Given a circular linked list, implement an algorithm that returns the node at the beginning
 *  of the loop.
 *  Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier
 *  node, so as to make a loop in the linked list.
 *  EXAMPLE: Input: A -> B -> C -> D -> E -> C [the same C as earlier] Output: C */

public class CCI2_8LoopDetection {
    public ListNode FindBeginning_TwoPointer(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        /**Find meeting point。 This will be LoopSize - k steps into the linked list */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }

        /** Move slow the head. Keep fast at meeting point. Each are k steps from
         *  loop start. If they move at the same pace, they must meet at loop start. */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        /** Both now point to the start of the loop */
        return fast;
    }
}
