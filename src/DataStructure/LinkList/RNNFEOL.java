package DataStructure.LinkList;

/**
 * Created by zzx on 11/9/16.
 19. Remove Nth Node From End of List   QuestionEditorial Solution
 *
 *Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5
 */
public class RNNFEOL {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        for(int i = 1;i<=n+1;i++){
                fast = fast.next;

        }

        return  null;
    }

    public static void main(String args[]){

        ListNode result = new ListNode(0);
        for(int i = 1;i<5;i++){
            result = result.next;
        }
//        DataStructure.LinkList.ListNode answer = removeNthFromEnd(result,2);
        System.out.print(result);
    }

}
//class DataStructure.LinkList.ListNode {
//    int val;
//    DataStructure.LinkList.ListNode next;
//    DataStructure.LinkList.ListNode(int x) { val = x; }
//}