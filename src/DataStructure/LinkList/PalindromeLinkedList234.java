package DataStructure.LinkList;

/**
 * Created by zhang on 2017/3/22.
 */
public class PalindromeLinkedList234 {
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next ==null) return  true;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        mid.next = reverse(mid.next);
        ListNode p1= head;
        ListNode p2 = mid.next;

        while (p1 != null && p2 !=null && p1.val == p2.val){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2 ==null;
    }

public static ListNode reverse(ListNode mid){
    ListNode prev = null;
    while ( mid != null){
        ListNode tmp = mid.next;
        mid.next = prev;
        prev = mid;
        mid = tmp;
    }
    return prev;
}

    public  static  void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        isPalindrome(listNode1);

    }

}
