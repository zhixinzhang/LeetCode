package DataStructure.LinkList;

/**
 * Created by zhang on 2017/1/8.
 */
public class reverseLinkedList206 {
    public  static  ListNode reverseList(ListNode head){
        if(head == null || head.next ==null){
            return head;
        }
        ListNode newHead = null;
        while (head != null){
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return  newHead;
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

        reverseList(head);
        System.out.print("aaa");
    }

}
