package XianQiao;

import DataStructure.LinkList.ListNode;

/**
 * @Author: Xianqiao
 * @Date: 8/4/20 13:19
 */
public class _2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        int carry = 0;
        int sum = 0;
        while (l1 != null && l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            sum = x + y + carry;
            temp.next = new ListNode(sum % 10);
            carry = sum / 10;
            // remember to check null condition! add if to check
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            temp = temp.next;
        }
        // remember if carry is not 0!
        if (carry != 0) {
            temp.next = new ListNode(carry);
        }
        return ans.next;
    }
}
