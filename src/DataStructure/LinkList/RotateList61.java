package DataStructure.LinkList;
/**
 * Created by zhang on 2017/1/9.
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */
// my solution  two pointer
public class RotateList61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k== 0 ) return head;
        int len = 1;
        ListNode p = head;
        while(p.next != null){
            p = p.next;
            len ++;
        }
        p.next = head;
        k = len - k%len;

        for(int step = 0; step<k; step ++){
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }

    private  static  ListNode getFast(ListNode head,int k){
        ListNode tmp = head;
        for(int i = 0;i<k;i++){
            if(head.next == null){
                return head;
            }else{
                head = head.next;
            }
        }
        return head;
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
        int[] test = {2,3,4,5,6};
        ListNode head = new ListNode(1);
        for(int i=0;i<test.length;i++){
            backInitNode(head,test,i);
        }
        int x =2;
        rotateRight(head,x);
    }
}
