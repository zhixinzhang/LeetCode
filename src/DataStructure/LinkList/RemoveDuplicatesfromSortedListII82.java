package DataStructure.LinkList;

/**
 * Created by zhang on 2017/1/9.
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
  1 1 2 3
 */
public class RemoveDuplicatesfromSortedListII82 {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode newDummy = new ListNode(0);
        ListNode tmp = newDummy;
        int curValue = -10;
        while (head != null && head.next != null ){
            if (head.val == head.next.val || head.val == curValue){
                curValue = head.val;
                head = head.next;
            }else {
                tmp.next = new ListNode(head.val);
                tmp = tmp.next;
                head = head.next;
            }
        }
        if (head != null && curValue != head.val){
            tmp.next = head;
        }
        return newDummy.next;
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
        int[] test = {1,2};
        ListNode head = new ListNode(1);
        for(int i=0;i<test.length;i++){
            backInitNode(head,test,i);
        }
        deleteDuplicates(head);
        System.out.print("aaa");
    }
}
