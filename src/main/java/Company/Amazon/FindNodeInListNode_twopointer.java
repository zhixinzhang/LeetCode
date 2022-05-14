package Company.Amazon;

import DataStructure.LinkList.ListNode;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/21/19
 * Time: 5:27 PM
 * Description:
 *
 * https://www.1point3acres.com/bbs/thread-517328-1-1.html
 *
 *  另一道是两个单链表，a->b->c->d,   e->f->g->c->d, 在c的地方香蕉了，返回node c，能不能o(1)空间。
 */


public class FindNodeInListNode_twopointer {
    public static void main(String[] args){
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);


        ListNode r = new ListNode(7);
        r.next = new ListNode(8);
        r.next.next = new ListNode(9);
        r.next.next.next = new ListNode(4);
        r.next.next.next.next = new ListNode(11);


        findNode(l,r);
        findNode_twopointer(l,r);
    }
    public static ListNode findNode (ListNode node1, ListNode node2){
        if(node1 == null && node2 == null) return null;
        HashSet<Integer> hs = new HashSet<>();
        ListNode n = node1;
        while (n != null){
            hs.add(n.val);
            n = n.next;
        }
        while (node2 != null){
            if (hs.contains(node2.val))
                return node2;
            node2 = node2.next;
        }
        return null;
    }

    public static ListNode findNode_twopointer (ListNode node1, ListNode node2){
        //
        ListNode n = node1;
        ListNode pre = null;
        while (n != null){
            if (pre != null)
                pre = pre.next;
            else
                pre = n;
            n = n.next;
        }
        pre.next = node1;

        ListNode slow = node1, fast = node2;
        while (slow != null && fast != null){
            if (slow.val == fast.val)
                return slow;
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next.next;
            else
                fast = fast.next;
        }

        return null;
    }
}
