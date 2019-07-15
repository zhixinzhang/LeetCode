package DataStructure.LinkList;

/**
 * Created by zhang on 2017/1/10.
 */
public class SwapNodeInPairs24 {
    public static ListNode swapPairs(ListNode head) {
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
            int a = 1;
        }
        return  dummy.next;
    }





    private static ListNode backInitNode(ListNode head,int[] test,int a){
        if(a<test.length && head.next == null){
            head.next = new ListNode(test[a]);
            a++;
            backInitNode(head.next,test,a);
        }
        return head;
    }

    public  static void main(String args[]){
        int[] test = {2,3,4};
        ListNode head = new ListNode(1);
        for(int i=0;i<test.length;i++){
            backInitNode(head,test,i);
        }
        swapPairs(head);
        System.out.print("aaa");
    }

}
