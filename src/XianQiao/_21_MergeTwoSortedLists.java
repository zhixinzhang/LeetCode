package XianQiao;

import DataStructure.LinkList.ListNode;

/**
 * @Author: Xianqiao
 * @Date: 8/4/20 13:38
 */
public class _21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1.next;
        }
        if (l2 != null) {
            temp.next = l2.next;
        }
        return ans.next;
    }
}
