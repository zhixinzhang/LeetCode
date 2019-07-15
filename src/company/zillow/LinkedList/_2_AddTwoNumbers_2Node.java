package company.zillow.LinkedList;

import DataStructure.LinkList.ListNode;

/**
 * Created by zhang on 2018/8/21.
 */
public class _2_AddTwoNumbers_2Node {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(4);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(0);
        l2.next.next = new ListNode(2);
        addTwoNumbers(l1,l2);
    }
}
