package DataStructure.ListNode;

import DataStructure.LinkList.ListNode;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/15/19
 * Time: 4:38 PM
 * Description:
 * 自己写的 一遍成
 */


public class _23_MergekSortedLists_PQ {
    public static void main(String[] args){
        ListNode l = new ListNode(1);
        l.next = new ListNode(4);
        l.next.next = new ListNode(5);

        ListNode ll = new ListNode(1);
        ll.next = new ListNode(3);
        ll.next.next = new ListNode(4);

        ListNode lll = new ListNode(2);
        lll.next = new ListNode(6);

        mergeKLists(new ListNode[]{l,ll,lll});
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        ListNode ans = new ListNode(0);
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->(a.val - b.val));
        for(ListNode l : lists){
            pq.add(l);
        }
        ListNode dum = ans;
        while(!pq.isEmpty()){
            ListNode cur = pq.poll();
            ans.next = new ListNode(cur.val);
            ans = ans.next;
            cur = cur.next;
            if(cur != null)
                pq.add(cur);
        }
        return dum.next;
    }
}
