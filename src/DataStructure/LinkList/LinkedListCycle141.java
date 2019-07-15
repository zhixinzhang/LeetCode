package DataStructure.LinkList;

/**
 * Created by zhang on 2017/3/16.
 */
public class LinkedListCycle141 {
    //0(n) spance o(n)
//    public static boolean hasCycle(ListNode head) {
//        if(head == null || head.next == null) return false;
//
//        Hashtable<ListNode,DataStructure.Integer> hashtable = new Hashtable<>();
//        while(head != null){
//            if (!hashtable.containsKey(head)){
//                hashtable.put(head,head.val);
//                head = head.next;
//            }else {
//                return true;
//            }
//        }
//        return false;
//    }
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode fast =head;
        ListNode slow = head;
        while(fast.next !=null && fast.next.next !=null){
            slow =slow.next;
            fast = fast.next.next;
            if (slow == fast) return  true;
        }
        return false;
    }
    public  static  void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        hasCycle(listNode1);

    }



}
