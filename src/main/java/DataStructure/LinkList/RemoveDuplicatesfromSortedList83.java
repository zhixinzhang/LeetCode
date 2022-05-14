package DataStructure.LinkList;

/**
 * Created by zhang on 2017/1/9.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
//my solution  首先确定head是否空
public class RemoveDuplicatesfromSortedList83 {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return  head;
        }
        ListNode resultLink = head;
        while (head != null && head.next!= null){
            ListNode tmp = head.next;
            if (head.val == tmp.val) head.next = head.next.next;  //如果当前的点跟下一个点值一样  不要下移  还是用当前点跟下下一个点对比
            else head = head.next;
        }
        return  resultLink;
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
        int[] test = {1,2,3,3};
        ListNode head = new ListNode(1);
        for(int i=0;i<test.length;i++){
            backInitNode(head,test,i);
        }
        deleteDuplicates(head);
        System.out.print("aaa");
    }
}
