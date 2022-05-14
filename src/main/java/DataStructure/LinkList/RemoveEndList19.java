package DataStructure.LinkList;

/**
 * Created by zhang on 2017/1/7.
 *
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveEndList19 {
    public  static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode cur = head;
        int leth = 1;
        while(cur.next != null){
            cur = cur.next;
            leth ++;
        }
        int revNodeNum = leth - n;
        ListNode temp = head;
        if(revNodeNum == 0){
            head = head.next;
        }else{
            for(int i = 1;i<= revNodeNum;i++){
                if (i == revNodeNum){
                    temp.next = temp.next.next;
                    int a = 0;
                }else{
                    temp = temp.next;
                }
            }
        }
        return  head;
    }
//better solution
//public  static DataStructure.LinkList.ListNode removeNthFromEnd(DataStructure.LinkList.ListNode head, int n) {
//    if (head == null || head.next == null ){
//        return  null;
//    }
//    DataStructure.LinkList.ListNode dummy = new DataStructure.LinkList.ListNode(0);
//    DataStructure.LinkList.ListNode slow = dummy;
//    DataStructure.LinkList.ListNode fast = dummy;
//    dummy.next = head;
//    while(n>0){
//        fast = fast.next;
//        n--;
//    }
//    while(fast.next != null) {​
//        slow = slow.next;​
//        fast = fast.next;​
//    }​
//    slow.next = slow.next.next;​
//    return dummy.next;​
//}







    private static ListNode backInitNode(ListNode head,int[] test,int a){
        if(a<test.length && head.next == null){
            head.next = new ListNode(test[a]);
            a++;
            backInitNode(head.next,test,a);
        }
        return head;
    }

    public  static void main(String args[]){
//        int[] test = {2,3,4,5};
        int[] test = {2};

        ListNode head = new ListNode(1);
        for(int i=0;i<test.length;i++){
            backInitNode(head,test,i);
        }

        int x = 2;
        removeNthFromEnd(head,x);
        System.out.print("aaa");
    }
}
