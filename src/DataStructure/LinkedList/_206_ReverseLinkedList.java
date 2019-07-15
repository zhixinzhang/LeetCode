package DataStructure.LinkedList;

import DataStructure.LinkList.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/23/19
 * Time: 4:14 PM
 * Description:
 */


public class _206_ReverseLinkedList {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        reverseList(head);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode temp = head;
        while(temp != null){
            ListNode nextTemp = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextTemp;
        }
        return prev;
    }
}
