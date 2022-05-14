package DataStructure.LinkList;

/**
 * Created by zhang on 2017/1/10.
 * For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */
/** each k nums link reverse
 *
 * */
public class _25_ReverseNodesinkGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        int cons = k;
        while (head != null){
            if (k==0){
                tmp .next = null;
                reverse(dummy.next);
                k = cons;
            }else{
                tmp.next = head;
                tmp = tmp.next;
                head = head.next;
            }
            k--;
        }
        return  null;
    }

//reverse linked
    private  static  ListNode reverse(ListNode head){
        ListNode curDummy = new ListNode(-1);
        ListNode cur = curDummy;
        ListNode last = head;
        if(head != null){
            head.next = null;
            ListNode tmp = head;
            head = brackTrack(head,last);
        }
        return  head;
    }
    private  static  ListNode brackTrack(ListNode head,ListNode last){

        return null;
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
        int k = 3;
        reverseKGroup(head,k);
        System.out.print("aaa");
    }
}
