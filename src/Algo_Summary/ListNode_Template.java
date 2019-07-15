package Algo_Summary;

import DataStructure.LinkList.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/27/19
 * Time: 9:57 PM
 * Description:
 */


public class ListNode_Template {
    // 删除某一个点   leetcode 203   特殊case 1 1 1 -> 删除1  结果 1
    public ListNode remove(ListNode head, int val){
        if (head == null)
            return head;
        ListNode temp = head;
        while (temp.next != null){
            if (temp.next.val == val){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return head.val == val ? head.next : head;
    }
    // reverse 第k个数 k不知道大小  LeetCode 61
    // 1 2 3 4 5 -》 5 4 1 2 3   k = 2
    // 把ListNode 变成circle 然后砍断
    public ListNode reverseKth(ListNode head, int k){
        int n = 1;
        ListNode temp = head;
        while(head != null){
            temp = temp.next;
            n++;
        }
        temp.next = head;
        k = n - k % n - 1;
        ListNode res = head;
        for (; k >= 0; k--)
            res = res.next;

        ListNode new_head = res.next;
        res.next = null;
        return new_head;
    }
    // 1 2 3 4 5   k = 2
    public ListNode removeKFromRight(ListNode head, int k){
        ListNode l = head, r = head;
        while (k-- > 0)
            r = r.next;
        if (r == null) return head.next;
        while (r.next != null){
            l = l.next;
            r = r.next;
        }
        l.next = l.next.next;
        return head;
    }


}
