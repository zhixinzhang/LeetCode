package Company.Sofi;

import DataStructure.LinkList.ListNode;

/**
 * @author Luke(New Man) Zhang
 * @Date 2/1/2021 2:33 AM
 * <p>
 * Description:
 * Key Point:
 */

public class _206_ReverseLinkedList_Recursive_Iterative {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        reverseList_Recursive(head);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode temp = head;
        while (temp != null){
            ListNode nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }
        return prev;
    }

    // [1,2,3,4,5]
    public static ListNode reverseList_Recursive(ListNode head) {
        if (head == null) {
            return null;
        }

        return recursive(head);
    }

    private static ListNode recursive(ListNode head){
        if (head.next == null) {
            return head;
        }

        ListNode last = recursive(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
