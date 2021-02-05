package Company.Houzz;

/**
 * Created by zhang on 2018/1/23.
 */
public class _24_SwapNodesinPairs_houzz {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode swapPairs(ListNode head) {
        if(head == null ||head.next == null){
            return  head;
        }
        ListNode dummy = new ListNode(-1) ;
        ListNode tmp = dummy;
        while (head != null && head.next != null){
            ListNode cur = head.next.next;
            tmp.next = head.next;
            tmp.next.next = head;
            tmp.next.next.next = cur;
            tmp = tmp.next.next;

            head = head.next;
        }
        return  dummy.next;
    }
}
