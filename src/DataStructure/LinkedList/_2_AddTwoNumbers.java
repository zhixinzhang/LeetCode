package DataStructure.LinkedList;

import DataStructure.LinkList.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/15/19
 * Time: 12:50 AM
 * Description:
 */


public class _2_AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p, dummy = new ListNode(0);
        p = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);
            carry /= 10;
            p = p.next;
        }
        return dummy.next;
    }
    public static void main(String[] args){
        ListNode p = new ListNode(2);
        p.next = new ListNode(4);
        p.next.next = new ListNode(3);
        p.next.next.next = new ListNode(1);


        ListNode q = new ListNode(5);
        q.next = new ListNode(6);
        q.next.next = new ListNode(4);

        addTwoNumbers(p,q);

    }
}
