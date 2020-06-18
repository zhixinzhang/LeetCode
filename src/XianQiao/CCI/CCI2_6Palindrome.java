package XianQiao.CCI;

/**
 * @Author: Xianqiao
 * @Date: 6/17/20 22:50
 */

/** Reverse LinkedList */
import DataStructure.LinkList.ListNode;

import java.util.Stack;

/** Palindrome: Implement a function to check if a linked list is a palindrome.
 * Toapproachthisproblem,wecanpictureapalindromelike0 -> 1 -> 2 -> 1 -> 0. */

public class CCI2_6Palindrome {
   public boolean isPalindrome_TwoPointer(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;
       while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next;
       }
       if (fast != null) {
           slow = slow.next; //skip the middle node for odd length list.
       }

       ListNode headSecondPart = reverseList(slow);
       while (headSecondPart != null) {
           if (head.val != headSecondPart.val) {
               return false
           }
           head = head.next;
           headSecondPart = headSecondPart.next;
       }
       return true;
   }

    public ListNode reverseList(ListNode head_cur) {

        /** How to reverse LinkedList
         * Initialize three pointers prev as NULL, curr as head and next as NULL.
         * Iterate trough the linked list. In loop, do following.
         * // Before changing next of current,
         * // store next node
         * next = curr->next
         * // Now change next of current
         * // This is where actual reversing happens
         * curr->next = prev
         *
         * // Move prev and curr one step forward
         * prev = curr
         * curr = next
         *
         * What is changed is the direction of pointer(link) 从向后指变成向前指 */

        ListNode newHead_pre = null;
        while (head_cur != null) {
            ListNode next = head_cur.next;
            head_cur.next = newHead_pre;
            newHead_pre = head_cur;
            head_cur = next;
        }
        return newHead_pre;
    }

    /** Iterative Approach */
    public boolean isPalindrome_Stack (ListNode head) {
       ListNode slow = head;
       ListNode fast = head;
       Stack<Integer> stack = new Stack<>();
       while (fast != null && fast.next != null) {
           stack.push(slow.val);
           slow = slow.next;
           fast = fast.next.next;
       }

       if (fast != null) {
           slow = slow.next;
       }

       while (slow != null) {
           if (stack.pop().intValue() != slow.val) {
               return false;
           }
           slow = slow.next;
       }
       return true;
    }
}
