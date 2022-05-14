package DataStructure.LinkList;

/**
 * Created by zhang on 2017/3/13.
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 return 1->4->3->2->5->NULL.
 */
public class ReverseLinkedList92 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return  head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1;i<m;i++){
            prev = prev.next;
        }
        ListNode  head2 = prev;
        prev = head2.next;
        ListNode cur= prev.next;

        for (int i = m;i<n;i++){
            prev.next = cur.next;
            cur.next = head2.next;
            head2.next = cur;
            cur = prev.next;
        }
        return dummy.next;
    }



    public static void main(String args[]){
        int[] test = {1,2,3,4,5,6};
        ListNode head = new ListNode(-1);

        IntialListNode intialListNode = new IntialListNode();
        int i =0;
        ListNode h = intialListNode.iniListNode(test,i,head);
        int m = 3;
        int n = 5;
        reverseBetween(head.next,m,n);
    }
}
