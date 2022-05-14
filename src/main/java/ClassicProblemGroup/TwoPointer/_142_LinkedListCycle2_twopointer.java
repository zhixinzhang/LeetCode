package ClassicProblemGroup.TwoPointer;

import DataStructure.LinkList.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/23/19
 * Time: 12:04 PM
 * Description:
 *
 *
 * Floyd's cycle detection
 * Define two pointers slow and fast. Both start at head node, fast is twice as fast as slow.
 * If it reaches the end it means there is no cycle, otherwise eventually it will eventually catch up to slow pointer somewhere in the cycle.
 *
 * 2(F+a)=F+nC+a, where nn is some integer.
 *
 * Hence the coordinate of the intersection point is F + a = nCF+a=nC.
 *
 */


public class _142_LinkedListCycle2_twopointer {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
