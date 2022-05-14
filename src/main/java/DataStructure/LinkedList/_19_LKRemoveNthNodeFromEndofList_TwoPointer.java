package DataStructure.LinkedList;


import DataStructure.LinkList.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/30/19
 * Time: 2:30 PM
 * Description:
 */


public class _19_LKRemoveNthNodeFromEndofList_TwoPointer {
    public ListNode remove(ListNode head, int n){
        if (n <= 0 || head == null) return head;
        ListNode l = head, r = head;
        while (n -- > 0) r = r.next;
        if (r == null) return head.next;        // 特殊 删除第一个

        while (r.next != null){
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return head;
    }
}
