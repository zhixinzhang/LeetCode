package DataStructure.LinkList;
import java.util.*;
public class _445_AddTwoNumbers2_Stack{

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        
        return list.val == 0 ? list.next : list;
    }


    // Recursion

    int carry = 0;

    public ListNode addTwoNumbers_Recursion(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode res;
        int len1 = getLen(l1), len2 = getLen(l2);
        if (len1 < len2) {
            res = add(l1, l2, len2 - len1);
        } else {
            res = add(l2, l1, len1 - len2);
        }
        if (carry > 0) {
            ListNode res1 = res;
            res = new ListNode(carry);
            res.next = res1;
        }
        return res;
    }

    public int getLen(ListNode l1) {
        int len = 0;
        while (l1 != null) {
            len++;
            l1 = l1.next;
        }
        return len;
    }

    //l2.length - l1.length == diff;
    public ListNode add(ListNode l1, ListNode l2, int diff) {
        if (l1.next == null && l2.next == null) {
            int sum = l1.val + l2.val;
            carry = sum / 10;
            return new ListNode(sum % 10);
        }
        ListNode res, next;
        int sum;
        if (diff == 0) {
            next = add(l1.next, l2.next, 0);
            sum = l1.val + l2.val + carry;
        } else {
            next = add(l1, l2.next, diff - 1);
            sum = carry + l2.val;
        }
        carry = sum / 10;
        res = new ListNode(sum % 10);
        res.next = next;
        return res;
    }

}