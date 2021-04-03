package DataStructure.LinkedList;

import DataStructure.LinkList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luke(New Man) Zhang
 * @Date 4/2/2021 11:17 PM
 * <p>
 * Description:
 * Similar task :
 * Key Point:
 */

public class _234_PalindromeLinkedList_TwoPointer {

    public boolean isPalindrome_twoPointer(ListNode head) {
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

        while (p1 != null && p2 != null && p1.val == p2.val){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2 ==null;
    }

    private ListNode reverse (ListNode mid){
        ListNode prev = null;
        while (mid != null) {
            ListNode tmp = mid.next;
            mid.next = prev;
            prev = mid;
            mid = tmp;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> cache = new ArrayList<>();
        while (head != null){
            cache.add(head.val);
            head = head.next;
        }

        for (int l = 0, r = cache.size() - 1; l < r; l++, r--){
            if (cache.get(l) == cache.get(r)){
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
