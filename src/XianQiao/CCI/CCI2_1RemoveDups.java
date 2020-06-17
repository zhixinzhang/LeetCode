package XianQiao.CCI;

/**
 * @Author: Xianqiao
 * @Date: 6/11/20 14:27
 */


import DataStructure.LinkList.ListNode;
import javafx.scene.Node;

import java.util.HashSet;
import java.util.LinkedList;

/** Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP : How would you solve this problem if a temporary buffer is not allowed? */

public class CCI2_1RemoveDups {
    // No Buffer Allowed O(1) space O(N^2)time
    private static void deleteDups_TwoPointer(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    //Buffer Allowed O(N) time
    private static void deleteDups_HashSet(ListNode n) {
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode previous = null;
        while (n != null) {
            if (set.contains(n.val)) {
                previous.next = n.next;
            } else {
                set.add(n.val);
                previous = n;
            }
            n = n.next;
        }
    }


    public static void main(String[] args){
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(0);
        l1.next.next.next.next = new ListNode(1);
        l1.next.next.next.next.next = new ListNode(2);
        deleteDups_TwoPointer(l1);
        System.out.println(l1);
    }

}
