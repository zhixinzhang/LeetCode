package google.LinkedNode;

import DataStructure.LinkList.ListNode;

/**
 * Created by zhang on 2018/8/12.
 * https://www.geeksforgeeks.org/reverse-a-linked-list/
 */
public class _reverseListNode_ {
    // 2 pointer recursion   n* log n
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reser(head);
    }
    public static void reverse(ListNode head){
        if (head == null)
            return;
        recur(head,null);
        int a = 0;
    }
    public static void recur(ListNode head, ListNode end){
        if (head.next == end){
            System.out.println(head.val);
            return;
        }
        ListNode start = head;
        ListNode mid = head, fast = head;
        while (fast != null && fast.next != null){
            mid = mid.next;
            fast = fast.next.next;
        }
//        if ()
        recur(mid,null);
        System.out.println(mid.val);
        recur(start,mid);
    }

    public static void reser(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
